class MedianFinder {
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;
    public MedianFinder() {
        max=new PriorityQueue<>(Collections.reverseOrder());
        min=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        max.add(num);
        min.add(max.poll());
        if(max.size()<min.size()){
            max.add(min.poll());
        }
    }
    
    public double findMedian() {
        if(max.size()==min.size()){
            return (double)(max.peek()+min.peek())/2;
        }
        return max.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */