class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //unique solution
        //it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station.
        int gasSum = Arrays.stream(gas).sum();
        int costSum = Arrays.stream(cost).sum();
        
        if(gasSum < costSum) return -1;
        
        int start = 0, fuel = 0;
        //find the unique possible starting point
        for(int i=0;i<gas.length;i++){
            if(gas[i] + fuel < cost[i]){
                //cannot be an answer
                start = i + 1;
                fuel = 0;
            }
            else {
                fuel += (gas[i] - cost[i]); 
            }
        }
        
        return start;
        
    }
}
