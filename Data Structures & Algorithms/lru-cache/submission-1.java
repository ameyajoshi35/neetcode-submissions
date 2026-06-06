class LRUCache {

    class Node{
         int key;
         int val;
         Node next;
         Node prev;

         Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
         }
    }

    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        this.map = new HashMap();
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;

    }
    
    public int get(int key) {

        if(map.get(key) == null) return -1;

        Node n = map.get(key);
        removeNode(n);
        moveToHead(n);

        return n.val;
    }
    
    public void put(int key, int value) {
        
        
        Node node = null;
        if(map.get(key)!=null) {
            Node existingNode = map.get(key);
            existingNode.val = value;
            node = existingNode;
            removeNode(node);
            moveToHead(node);
        } else{
            if(map.size() == capacity) {
                Node lru = this.tail.prev;
                deleteTail(lru);
                System.out.println(lru.key);
                map.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            node = newNode;
            map.put(key, newNode);
            moveToHead(node);

        }
        
        
        
    }

    private void deleteTail(Node lru) {

        
        Node prev = lru.prev;
        prev.next = this.tail;
        this.tail.prev = prev;
        lru = null;

    }

    public void removeNode(Node node) {
        Node nNext = node.next;
        Node nPrev = node.prev;
        nPrev.next = nNext;
        nNext.prev = nPrev;
    }

    private void moveToHead(Node node) {
        
        Node next = this.head.next;
        this.head.next = node;
        next.prev = node;
        node.prev = this.head;
        node.next = next;

    }
}
