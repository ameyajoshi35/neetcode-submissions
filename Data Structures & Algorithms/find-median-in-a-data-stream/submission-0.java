class MedianFinder {
    
    private Queue<Integer> minHeap = new PriorityQueue();
    private Queue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        
        if(minHeap.isEmpty()) {
            System.out.println("added to min");
            minHeap.offer(num);
        } else if(!minHeap.isEmpty() && num < minHeap.peek()) {
            System.out.println("added to max");
            maxHeap.offer(num);
        } else {
            System.out.println("added to min else");
            minHeap.offer(num);
        }

        int minSize = minHeap.size();
        int maxSize = maxHeap.size();
         System.out.println(minSize+"---"+maxSize+" for-"+num);

        int total = minSize + maxSize;
        int balance = total%2;
        

        if(minSize > maxSize) {

            while(!minHeap.isEmpty() && (minSize - maxSize != balance)) {
                System.out.println("polling minHeap");

                  maxHeap.offer(minHeap.poll());
                  minSize = minHeap.size();
                  maxSize = maxHeap.size();
            }
        } else {

            while(!maxHeap.isEmpty() && maxSize - minSize != balance) {

                  minHeap.offer(maxHeap.poll());
                  minSize = minHeap.size();
                  maxSize = maxHeap.size();
            }

        }
    
    }
    
    public double findMedian() {
          
        int minSize = minHeap.size();
        int maxSize = maxHeap.size();
       

        int total = minSize + maxSize;
        
        if(minSize == maxSize && minSize >= 1) {
            double m = maxHeap.peek();
            double n = minHeap.peek();
            System.out.println(m+""+n);
            return (m+n)/2.0d;
        } else if (minSize > maxSize && minSize >= 1) {
            return (double)minHeap.peek();
        } else if(maxSize >= 1){
            return (double)maxHeap.peek();
        }
        return 0.0d;
        
    }
}
