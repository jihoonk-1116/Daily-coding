class Point implements Comparable<Point>{
    
    int x;
    int y;
    
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int compareTo(Point p){
        return (this.x*this.x + this.y*this.y) - (p.x*p.x + p.y*p.y);
    }
    
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // x y 
        int[][] res = new int[k][2];
        // min heap -> smaller value is closer to the origin 
        PriorityQueue<Point> pq = new PriorityQueue<>();
        
        for(int i=0;i<points.length;i++){
            
            int x = points[i][0];
            int y = points[i][1];
            
            Point p = new Point(x,y);
            
            pq.offer(p);
        }
        
        for(int i=0;i<k;i++){
            
            Point curPoint = pq.poll();
            
            int[] point = new int[2];
            point[0] = curPoint.x;
            point[1] = curPoint.y;
            
            res[i] = point;
        }
        
        // return k points
        return res;
    }
}
