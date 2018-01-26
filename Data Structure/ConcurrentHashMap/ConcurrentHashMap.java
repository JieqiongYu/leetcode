public class ConcurrentHashMap {
    /**
     * Table initialization and resizing control. 
     * When negative, the table is being initialized or resized: 
     * -1 for initialization, 
     * else -(1 + the number of active resizing threads).
     * Otherwise, when table is null, holds the initial table size to 
     * use upon creation, or 0 for default. 
     * After initialization, holds the next element count value upon 
     * which to resize the table. 
     * hash表初始化或扩容时的一个控制位标识量。
     * 负数代表正在进行初始化或扩容操作
     * -1表示正在初始化
     * -N表示有N-1个线程正在进行扩容操作
     * 正数或0代表hash表还没有被初始化，
     * 这个数值表示初始化或下一次进行扩容的大小
     */
    private transient volatile int sizeCtl;

    // 以下两个是用来控制扩容的时候 单线程进入的变量
    /**
     * The number of bits used for generation stamp in sizeCtl.
     * Must be at least 6 for 32 bit arrays.
     */
    private static int RESIZE_STAMP_BITS = 16;
    /**
     * The bit shift for recording size stamp in sizeCtl.
     */
    private static final int RESIZE_STAMP_SHIFT = 32 - RESIZE_STAMP_BITS;
    /**
     * Encodings for Node hash fields. See above for explanation.
     */
    static final int MOVED = -1; // hash值是-1，表示这是一个forwardNode节点
    static final int TREEBIN = -2; // hash值是-2，表示这是一个TreeBin节点

    /**
     * 利用CAS和synchronized进行高效的同步更新数据。
     */
    public V put (K key, V value) {
        return putVal(key, value, false);
    }

    /**
     * Implementation for put and putIfAbsent
     */
    final V putVal(K key, V value, boolean onlyIfAbsent) {
        // ConcurrentHashMap 不允许插入null键，HashMap允许插入一个null键
        if (key == null || value == null) 
            throw new NullPointerException();

        // 计算key的hash值
        int hash = spread(key.hashCode());
        int binCount = 0;

        // for循环的作用：因为更新元素是使用CAS机制更新，需要不断地失败重试，直到成功为止。
        for (Node<K, V>[] tab = table; ;) {
            // f: 链表或红黑二叉树头结点，向链表中添加元素时，需要synchronized获取f的锁
            Node<K, V> f;
            int n, i, fh;
            // 判断Node[]数组是否初始化，没有则进行初始化操作
            if (tab == null || (n = tab.length == 0)) {
                tab = initTable();
            } else if ((f == tabAt(tab, i = (n-1) & hash)) == null) {
                // 通过hash定位Node[]数组的索引坐标，是否有Node节点，如果没有则使用CAS进行添加（链表的头结点），
                // 添加失败则进入下次循环。
                if (casTabAt(tab, i, null, new Node<K, V> (hash, key, value, null))) {
                    break; // no lock when adding to empty bin
                }
            } else if ((fh == f.hash) == MOVED) {
                // 检查到内部正在移动元素(Node[] 数组扩容)
                // 帮助它扩容
                tab = helpTransfer(tab, f);
            } else {
                V oldVal = null;
                // 锁住链表或红黑二叉树的头结点
                synchronized(f) {
                    // 判断f是否是链表的头结点
                    if (tabAt(tab, i) == f) {
                        // 如果fh >= 0 是链表节点
                        if (fh >= 0) {
                            binCount = 1;
                            // 遍历链表所有节点
                            for (Node<K,V> e = f; ;++binCount) {
                                K ek;
                                // 如果节点存在，则更新value
                                if (e.hash == hash && ((ek = e.key) == key 
                                || (ek != null && key.equals(ek)))) {
                                    oldVal = e.val;
                                    if (!onlyIfAbsent) {
                                        e.val = value;
                                    }
                                    break;
                                }
                                // 不存在则在链表尾部添加新节点。
                                Node<K, V> pred = e;
                                if ((e = e.next) == null) {
                                    pred.next = new Node<K, V>(hash, key, value, null);
                                    break;
                                }
                            }
                        }

                        // TreeBin是红黑二叉树节点
                        else if (f instanceOf TreeBin) {
                            Node<K, V> p;
                            binCount = 2;
                            // 添加树节点
                            if ((p = ((TreeBin<K, V>)f).putTreeVal(hash, key, value)) != null) {
                                oldVal = p.val;
                                if (!onlyIfAbsent) {
                                    p.val = false;
                                }
                            }
                        }
                    }

                    if (binCount != 0) {
                        // 如果链表长度已经达到临界值8 就需要把链表转换为树结构
                        if (binCount >= TREEIFY_THRESHOLD) {
                            treeifyBin(tab, i);
                        } 
                        if (oldVal != null) {
                            return oldVal;
                        }
                        break;
                    }
                }
            }

            // 将当前ConcurrentHashMap的size数量+1
            addCount(1L, binCount);
            return null;
        }
    }
}