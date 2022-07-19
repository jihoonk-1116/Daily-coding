class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //left find smaller value  
        //right find larger value
        
        //iteration through intervals
        
        ArrayList<int[]> res = new ArrayList<>();
        if(intervals.length == 0){
            res.add(newInterval);
            return res.toArray(new int[0][0]);
        }
        
        int pos = 0;
        for(int i=0;i<intervals.length;i++){
            //an existed interval's range is beyound the range of the new interval
            //In this case, we don't need to iterate further 
            //because there will be no more interval that suits for the new one.
            if(intervals[i][0] > newInterval[1]){
                res.add(newInterval);
                pos = i;
                if(pos < intervals.length){
                    for(int p=pos;p<intervals.length;p++){
                        res.add(intervals[p]);
                    }
                }
                return res.toArray(new int[0][0]);
            }
            //new interval's start is greater than an existed interval's end
            //the existed interval cannot include the new interval's range
            if(intervals[i][1] < newInterval[0]){
                res.add(intervals[i]);
            }
            //ow, i's interval can be merged with the new interval
            //newinterval's 's' should be min of between new's start and the interval's start
            //newinterval's 'e' should be max of between new's end and the interval's end
            else{
                newInterval = new int[]{Math.min(newInterval[0], intervals[i][0]) 
                                        , Math.max(newInterval[1], intervals[i][1])};
            }
        }
        
        
        res.add(newInterval);
    
        return res.toArray(new int[0][0]);
        
    }
}
