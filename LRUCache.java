class LRUCache {

    private Map<Integer, Node> cache;
    private int capacity;

    private Node left; //head
    private Node right; //tail

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();

        //left = LRU , right = most recent
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            remove(cache.get(key)); //remove the key node from left 
            insert(cache.get(key)); //insert it to the right, which means recently used
            return cache.get(key).val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        cache.put(key, new Node(key, value));
        insert(cache.get(key)); //insert the key to the right cuz it's used

        if (cache.size() > capacity) {
            // remove from the list and delte the LRU from the hashmap
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    // remove node from list
    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    // insert node at right
    // cuz the node is recently used
    public void insert(Node node) {
        Node prev = this.right.prev;
        Node next = this.right;

        prev.next = node;
        next.prev = node;

        node.next = next;
        node.prev = prev;
    }

    private class Node {

        private int key;
        private int val;

        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
