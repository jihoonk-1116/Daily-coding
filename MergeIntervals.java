class Solution {
    public int[][] merge(int[][] intervals) {
        //merge condition
        //1. an interval's start should be less than another interval's start
        //2. the interval's end should be grater than another interval's end or opposite
        //1,3 2,6 -> 1,6
        //1,4 2,3 -> 1,4
        //if intervals array is sorted, then much easier to find overlapped intervals
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> res = new ArrayList<>();
        //1,6 2,4 3,6
        int[] mergedInterval = new int[2];
        //merge case 
        //skip case - interval[i][1] < interval[i+1][0] -> cannot merge
        
        for(int i=0;i<intervals.length;i++){
            //1. if 22 line was not invoked, then mergedInterval reached out to the end. so add it
            //2. even if the mergedInterval didnt, the last interval is still needed to be added
            if(i+1 == intervals.length) {
                res.add(intervals[i]);
                break;
            }
            
            if(intervals[i][1] < intervals[i+1][0]){
                res.add(new int[]{intervals[i][0], intervals[i][1]});
            } 
            else{
                mergedInterval[0] = intervals[i][0];
                mergedInterval[1] = Math.max(intervals[i][1], intervals[i+1][1]);
                intervals[i+1] = mergedInterval;
            }
        }
        
     
        
        return res.toArray(new int[0][0]);
    }
}
