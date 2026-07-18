class StockSpanner {
    Stack<Node> s = new Stack<>();
    int index = -1;

    public StockSpanner() {
        s.push(new Node(Integer.MAX_VALUE, index));
    }

    public int next(int price) {
        index++;
        while (s.peek().val <= price) {
            s.pop();
        }
        int span = index - s.peek().index;
        s.push(new Node(price, index));
        return span;
    }
}

class Node {
    public int val;
    public int index;

    public Node(int val, int index) {
        this.val = val;
        this.index = index;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */