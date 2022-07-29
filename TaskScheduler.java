class Solution {
    
    public int leastInterval(char[] tasks, int n) {
        
        HashMap<Character, Integer> freq = new HashMap<>();
        for(char c : tasks) freq.put(c, freq.getOrDefault(c, 0)+1);
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        for(char key : freq.keySet()) maxHeap.offer(freq.get(key));
        
        int time = 0;
        //q is task's waitlist for waiting during each idle time. 
        //A task is being polled when its idleTime is equal to current time.
        Queue<int[]> q = new LinkedList<>(); //pairs of count, idleTime
        while(!maxHeap.isEmpty() || !q.isEmpty()){
            
            time ++;
            //there are no more tasks to be processed
            //then update the time as the idleTime of the next waiting task  
            if(maxHeap.isEmpty()) time = q.peek()[1]; 
            else{
                int cnt = maxHeap.poll() - 1;  //decrease count of the task
                //assign idleTime to time + n(input)
                //so, the next burst could be done at time + n seconds
                if(cnt > 0) q.offer(new int[]{cnt, time + n}); 
                                                
            }
            if(!q.isEmpty() && q.peek()[1] == time){ //waitlist is not empty. 
                //and the idle time of the first in the queue 
                //is equal to the current time
                //it means the task can be precessed 
                //and this alg is processing the task in order by task's frequency
                maxHeap.offer(q.poll()[0]);
            }
        }
        
        return time;
    }
}
