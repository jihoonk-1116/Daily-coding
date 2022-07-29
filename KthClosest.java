class Solution{
   // QuickSelect
    /*
    Avg Time: O(N)
    Worst Time: O(N^2)
    */
    public int[][] kClosest(int[][] points, int K) {
        quickSort(points, K, 0, points.length - 1);
        return Arrays.copyOf(points, K);
    }
    
    public void quickSort(int[][] points, int K, int lo, int hi) {
        
        if (lo >= hi) return;
        
        int pivotInd = lo + (hi - lo) / 2;
        int pivot = dist(points[pivotInd][0], points[pivotInd][1]);
        swap(points, pivotInd, hi);
     
        int s = lo;
        for (int i = lo; i < hi; i++) {
            if (points[i][0] * points[i][0] + points[i][1] * points[i][1] < pivot) {
                swap(points, i, s);
                s++;
            }
        }
        swap(points, hi, s);
        
        if (s == K) return;
        else if (s < K) quickSort(points, K, s + 1, hi);
        else quickSort(points, K, lo, s - 1);
    }
    
    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
    
    private int dist(int x, int y){
        return x * x + y * y;
    }
}

// class Solution {
//     public int[][] kClosest(int[][] points, int k) {

//         int[][] res = new int[k][2];
//         PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> ((a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1])));
        
//         for(int [] p : points) pq.offer(p);
//         for(int i=0;i<k;i++) res[i] = pq.poll();
//         return res;
//     }
// }


// class Point implements Comparable<Point>{
    
//     int x;
//     int y;
    
//     public Point(int x, int y){
//         this.x = x;
//         this.y = y;
//     }
    
//     @Override
//     public int compareTo(Point p){
//         return (this.x*this.x + this.y*this.y) - (p.x*p.x + p.y*p.y);
//     }
    
// }

// class Solution {
//     public int[][] kClosest(int[][] points, int k) {
//         // x y 
//         int[][] res = new int[k][2];
//         // min heap -> smaller value is closer to the origin 
//         PriorityQueue<Point> pq = new PriorityQueue<>();
        
//         for(int i=0;i<points.length;i++){
            
//             int x = points[i][0];
//             int y = points[i][1];
            
//             Point p = new Point(x,y);
            
//             pq.offer(p);
//         }
        
//         for(int i=0;i<k;i++){
            
//             Point curPoint = pq.poll();
            
//             int[] point = new int[2];
//             point[0] = curPoint.x;
//             point[1] = curPoint.y;
            
//             res[i] = point;
//         }
        
//         // return k points
//         return res;
//     }
// }
