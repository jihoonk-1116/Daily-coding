class Solution {
    
    static class Point implements Comparable<Point>{
        
        int p;
        int w;
        
        public Point(int p, int w){
            this.p = p;
            this.w = w;
        }
        
        @Override
        public int compareTo(Point o){
            return this.w - o.w;
        }
    }
    
    public int minCostConnectPoints(int[][] points) {
        //iterate points
        //find mst 
        //need to sort? by what? 
        
        int n = points.length;
        ArrayList<List<Point>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<Point>());
        
        for(int i=0;i<n;i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            for(int j=i+1;j<n;j++){
                
                int x2 = points[j][0];
                int y2 = points[j][1];
                
                int weight = Math.abs(x1-x2) + Math.abs(y1-y2);
                
                adj.get(i).add(new Point(j,weight));
                adj.get(j).add(new Point(i,weight));
            }
        }
        
        int res = 0;
        HashSet<Integer> visit = new HashSet<>();
        PriorityQueue<Point> minHeap = new PriorityQueue<>();
        minHeap.offer(new Point(0,0));
        
        while(visit.size() < n){
            Point cur = minHeap.poll();
            if(visit.contains(cur.p)) continue;
     
            res += cur.w;
            visit.add(cur.p);

            for(Point np : adj.get(cur.p)){
                if(!visit.contains(np.p)){
                    minHeap.offer(np);
                }
            }
        }
        
        return res;
    }
}
