class LRUCache {
    HashMap<Integer, DLLNode> hash = new HashMap<>();
    DLL dll=new DLL();
    int capacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        DLLNode node = hash.get(key);
        if (node != null) {
            dll.detach(node);
            dll.addLast(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        DLLNode node = hash.get(key);
        if (node != null) {
            node.val = value;
            dll.detach(node);
        } else {
            if (hash.size() == capacity) {
                hash.remove(dll.head.next.key);
                dll.removeFirst();
            }
            node = new DLLNode(key, value);
            hash.put(key, node);

        }
        dll.addLast(node);

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

}


class DLL{
    public DLLNode head=new DLLNode(-1, -1);
    public DLLNode tail=new DLLNode(-1, -1);

    public DLL(){
        head.next=tail;
        tail.prev=head;
    }

    public void addLast(DLLNode node){
        node.prev=tail.prev;
        node.prev.next=node;
        tail.prev=node;
        node.next=tail;
    }

    public void removeFirst(){
        head.next = head.next.next;
        head.next.prev = head;
    }

    public void detach(DLLNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */