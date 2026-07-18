class MinStack {
    Deque<int[]> s = new ArrayDeque<>();

    public MinStack() {
        s.push(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE});
    }

    public void push(int value) {
        s.push(new int[]{value, Math.min(value, s.peek()[1])});
    }

    public void pop() {
        s.pop();
    }

    public int top() {
        return s.peek()[0];
    }

    public int getMin() {
        return s.peek()[1];
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