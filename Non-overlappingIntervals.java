class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        
        //not overlapping :  e[i] <= s[i+1] 
        //overlapping : e[i] > s[i+1] 
        //count the overlapping case
        int res = 0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i-1][1] > intervals[i][0]){     //if adjacent intervals are overlapped, 
                if(intervals[i-1][1] < intervals[i][1]){ //choose an interval that has longer range
                    intervals[i] = intervals[i-1];       //to replace another interval that has shorter range
                }
                res++;
                
            }
        }
        return res;
    }
}
