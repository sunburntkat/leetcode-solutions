class MinStack {
    Stack<Node> s = new Stack<>();

    public MinStack() {
        s.push(new Node(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    public void push(int value) {
        s.push(new Node(value, Math.min(value, getMin())));
    }

    public void pop() {
        s.pop();
    }

    public int top() {
        return s.peek().val;
    }

    public int getMin() {
        return s.peek().min;
    }
}

class Node {
    public int val;
    public int min;

    public Node(int val, int min) {
        this.val = val;
        this.min = min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */