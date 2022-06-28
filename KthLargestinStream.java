class KthLargest {
    //4 5 8 2
    //3
    //3 -> 2 3 4 5 8 
    //5 -> 2 3 4 5 5 8
    //10 -> 2 3 4 5 5 8 10 -> 5
    //9 -> 2 3 4 5 5 8 9 10 -> 8
    //pq -> max heap
    private int k;
    private PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        //pq
        this.k = k;
        this.pq = new PriorityQueue<Integer>();
        //put all nums elements to pq
        for(int d : nums){
            pq.offer(d);
        }
        //k can be static
        while(pq.size()>k){
            pq.poll();
        }
    }
    
    public int add(int val) {
        this.pq.offer(val);
        if(pq.size() > k) pq.poll();
        
        return pq.peek();
    }
}
