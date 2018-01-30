/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key exists 
 * in the cache, otherwise return -1.
 * 
 * put(key, value) - Set or insert the value if the key is not already present. 
 * When the cache reached its capacity, it should invalidate the least recently used 
 * item before inserting a new item.
 * 
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * 
 * Example:
 * 
 * LRUCache cache = new LRUCache(2) // capacity;
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * 
 * https://leetcode.com/problems/lru-cache/description/
 */
public class LRUCache {
    int size;
    int capacity;
    ListNode head;
    ListNode tail;
    Map<Integer, ListNode> map;

    public LRUCache (int capacity) {
        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.size = 0;
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        ListNode n = map.get(key);
        if (n != null) {
            moveToHead(n);
            return n.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        ListNode n = map.get(key);
        if (n == null) {
            n = new ListNode(value, key);
            attachToHead(n);
            size++;
        } else {
            n.val = value;
            moveToHead(n);
        }
        // 如果更新节点后超出容量，删除最后一个
        if (size > capacity) {
            removeLast();
            size--;
        }
        map.put(key, n);
     }

     // 将一个孤立节点放到头部
    private void attachToHead(ListNode n) {
        n.next = head.next;
        n.next.prev = n;
        head.next = n;
        n.prev = head;
    }

    // 将一个链表中的节点放到头部
    private void moveToHead(ListNode n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
        attachToHead(n);
    }

    // 移出链表最后一个节点
    private void removeLast() {
        ListNode last = tail.prev;
        last.prev.next = tail;
        tail.prev = last.prev;
        map.remove(last.key);
    }

    public class ListNode {
        ListNode prev;
        ListNode next;
        int val;
        int key;
        public ListNode(int v, int k) {
            this.val = v;
            this.key = k;
            this.prev = null;
            this.next = null;
        }
    }
}

