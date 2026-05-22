class MedianFinder {
    PriorityQueue<Integer> pqLeft = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    PriorityQueue<Integer> pqRight = new PriorityQueue<>();
    int size = 0;
    int nextVal = 0;

    public MedianFinder() {

    }

    public void addNum(int num) {
        if(size==0){
            pqLeft.add(num);
            size++;
            return;
        }
        if (size % 2 == 0) {
            if (num > pqRight.peek()) {
                pqLeft.add(pqRight.poll());
                pqRight.add(num);
            } else {
                pqLeft.add(num);
            }
        } else {
            if (num < pqLeft.peek()) {
                pqRight.add(pqLeft.poll());
                pqLeft.add(num);
            } else {
                pqRight.add(num);
            }
        }
        size++;
    }

    public double findMedian() {
        if (size % 2 == 0) {
            return (pqLeft.peek() + pqRight.peek()) / 2f;
        } else {
            return pqLeft.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */