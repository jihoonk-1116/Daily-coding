class Solution {
    
    static class Car implements Comparable<Car> {
        
        int pos;
        int speed;
        
        public Car(int p, int s){
            this.pos = p;
            this.speed = s;
        }
        
        @Override
        public int compareTo(Car c){
          //need pos arr in desending order 
            return c.pos - this.pos;
        }
        
    }
   
    public int carFleet(int target, int[] position, int[] speed) {
    
        PriorityQueue<Car> pq = new PriorityQueue<>();
        
        for(int i=0;i<position.length;i++){
            pq.offer(new Car(position[i], speed[i]));    
        }
        
        double prevRemainingTime = 0;
        int fleets = 0;
        
        //if the top's ramaining time is less than the current one 
        //then the two cars is gonna be fleet
        //cuz though the top's one is more far from dest than the current
        //but the top would be arrived to the dest more faster or same rather than cur
        //cuz the top has faster speed
        while(!pq.isEmpty()){
            Car curCar = pq.poll();
            double curRemainingTime = (double)((target - curCar.pos) / (double) curCar.speed);
            if(curRemainingTime > prevRemainingTime){
                fleets ++ ;
                prevRemainingTime = curRemainingTime;
            }
            
        }
        return fleets;
    }
}
