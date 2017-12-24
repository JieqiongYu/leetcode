/**
* Implement your own HashMap.
*/

package hashmap;

public class MerHashMap {

    /**
     * Constructor
     */
    public MerHashMap() {
    }

    class Node {

        private String key;
        private String value;
        private Node next;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }

    // The inital size of the bucket array.
    private int BUCKET_ARRAY_SIZE = 256;
    private Node[] bucketArray = new Node[BUCKET_ARRAY_SIZE];

    public MerHashMap(int initialSize) {
        this.BUCKET_ARRAY_SIZE = initialSize;
    }

    /**
     * Put a key-value pair into the data structure.
     *
     * @param key Key String that is used to identify the key-value pair.
     * @param value Value String in which the key string maps to.
     */
    public void put(String key, String value) {
        // Get the hash code.
        int hash = Math.abs(key.hashCode() % BUCKET_ARRAY_SIZE);
        // Create the Node to add to the linked list
        Node entry = new Node(key, value);

        // insert the node to the bucket array at the hash index.
        if (bucketArray[hash] == null) {
            // No collision so far.
            bucketArray[hash] = entry;
        } else {
            // Collision detected.
            Node current = bucketArray[hash];
            while (current.next != null) {
                // check if the key already exists
                if (current.getKey().equals(entry.getKey())) {
                    // update the value if key exists.
                    current.setValue(entry.getValue());
                    return;
                }
                current = current.next;
            }

            // When the code gets here current.next == null
            // add the new node as the next one
            current.next = entry;
        }
    }

    /**
     * Returns the value that is mapped to the given key.
     *
     * @param key
     * @return
     */
    public String get(String key) {
        // Get the hash
        int hash = Math.abs(key.hashCode() % BUCKET_ARRAY_SIZE);

        // Search for key in Linked List
        Node node = bucketArray[hash];

        // Traverse Linked List
        while (node != null) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
            node = node.getNext();
        }

        // Not found? return null
        return null;
    }
}
