class LRUCache {
    HashMap<Integer, DLLNode> hash = new HashMap<>();
    DLLNode head = new DLLNode(-1, -1);
    DLLNode tail = head;
    int size = 0;
    int capacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        DLLNode node = hash.get(key);
        if (node != null) {
            if (node != tail) {
                node.detach();
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        DLLNode node = hash.get(key);
        if (node != null) {
            node.val = value;
            if (node != tail) {
                node.detach();
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
        } else {
            if (size == capacity) {
                hash.remove(head.next.key);
                if (tail == head.next)
                    tail = head;
                head.next = head.next.next;
                if (capacity != 1) {
                    head.next.prev = head;
                }
                size--;
            }
            DLLNode newNode = new DLLNode(key, value);
            hash.put(key, newNode);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size++;
        }

    }
}

class DLLNode {
    public int key;
    public int val;
    public DLLNode next;
    public DLLNode prev;

    public DLLNode(int key, int val) {
        this.key = key;
        this.val = val;
    }

    public void detach() {
        next.prev = prev;
        prev.next = next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */