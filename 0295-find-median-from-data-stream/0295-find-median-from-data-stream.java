class MedianFinder {
    Queue<Integer> maxHeap;
    Queue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> {
        return Integer.compare(b, a);
    });
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() && minHeap.isEmpty()){
            maxHeap.offer(num);
        } else if (maxHeap.isEmpty()){
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else if (minHeap.isEmpty()){
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else if (num <= maxHeap.peek()) {
            maxHeap.offer(num);
            if(maxHeap.size() > minHeap.size() + 1){
                minHeap.offer(maxHeap.poll());
            }
        } else if (num >= minHeap.peek()) {
            minHeap.offer(num);
            if(minHeap.size() > maxHeap.size() + 1){
                maxHeap.offer(minHeap.poll());
            }
        } else if (num > maxHeap.peek() && num < minHeap.peek()){
            if(minHeap.size() > maxHeap.size()){
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
        }
    }
    
    public double findMedian() {
        if(maxHeap.isEmpty() && minHeap.isEmpty()){
            return 0;
        }
        if(maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        } else if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else {
            return (double)(maxHeap.peek() + minHeap.peek()) / 2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */