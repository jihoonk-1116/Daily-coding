class Solution {
    public int lastStoneWeight(int[] stones) {
        //choose two stones 
        //y is greater than or equal to x
        //x == y -> both is eliminated
        //y > x -> y - x -> and offer to ds
        
        //pq
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> (b-a));
        //put all stones to pq
        for(int s : stones) pq.offer(s);
        //do while qp.size() > 1
        while(pq.size() > 1){
            //poll twice
            int s1 = pq.poll();
            int s2 = pq.poll();
  
            //if x == y then next
            if(s1 == s2) continue;
            if(s1 > s2) pq.offer(s1-s2);
            //else, x < y then offer y - x
        }
        
        if(pq.peek() == null) return 0;
        return pq.peek();
        
    }
}
/*
   public int lastStoneWeight(int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> b - a);
        for (int a : A) pq.offer(a);
        
        while (pq.size() > 1) pq.offer(pq.poll() - pq.poll());
        
        return pq.poll();
    }
*/
