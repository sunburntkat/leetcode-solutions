class LFUCache {

    public FreqNode head = new FreqNode(-1);
    public FreqNode tail = new FreqNode(-1);
    HashMap<Integer, DataNode> dataMap = new HashMap<>();
    int capacity = 0;

    public LFUCache(int capacity) {
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        DataNode dataNode = dataMap.get(key);
        if (dataNode == null)
            return -1;
        reposition(dataNode);
        return dataNode.val;
    }

    public void put(int key, int value) {
        DataNode dataNode = dataMap.get(key);
        if (dataNode != null) {
            dataNode.val = value;
            reposition(dataNode);
        } else {
            if (dataMap.size() == capacity) {
                int oldKey=head.next.head.next.key;
                if (head.next.head.next.next == head.next.tail) {
                    removeFreqNode(head.next);
                } else {
                    DataNode innerHead = head.next.head;
                    innerHead.next=innerHead.next.next;
                    innerHead.next.prev=innerHead;
                }
                dataMap.remove(oldKey);

            }
            FreqNode newFreqNode=head.next;
            if (newFreqNode.freq != 1) {
                newFreqNode = new FreqNode(1);
                addFreqAfter(head, newFreqNode);
            }
            dataNode = new DataNode(key, value, newFreqNode);
            addDataLast(newFreqNode.tail, dataNode);
            dataMap.put(key, dataNode);
        }
    }

    public void reposition(DataNode dataNode) {
        FreqNode freqNode = dataNode.freqNode;
        int freq = freqNode.freq;
        if (freqNode.head.next.next == freqNode.tail) {
            removeFreqNode(freqNode);
            freqNode=freqNode.prev;
        }
        removeDataNode(dataNode);
        FreqNode newFreqNode = freqNode.next;
        if (freqNode.next.freq != freq + 1) {
            newFreqNode = new FreqNode(freq + 1);
            addFreqAfter(freqNode, newFreqNode);
        }
        dataNode.freqNode=newFreqNode;
        addDataLast(newFreqNode.tail, dataNode);

    }

    public void removeFreqNode(FreqNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void removeDataNode(DataNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addDataLast(DataNode tail, DataNode node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        tail.prev = node;
        node.next = tail;
    }

    public void addFreqAfter(FreqNode prev, FreqNode node) {
        node.next = prev.next;
        node.prev = prev;
        prev.next = node;
        node.next.prev = node;

    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


class FreqNode {
    public int freq;
    public FreqNode prev, next;

    public DataNode head = new DataNode(-1, -1, this);
    public DataNode tail = new DataNode(-1, -1, this);

    public FreqNode(int freq) {
        this.head.next = tail;
        this.tail.prev = head;
        this.freq = freq;
    }
}

class DataNode {
    public int key;
    public int val;
    public FreqNode freqNode;
    public DataNode prev, next;

    public DataNode(int key, int val, FreqNode freqNode) {
        this.key = key;
        this.val = val;
        this.freqNode = freqNode;
    }

}
