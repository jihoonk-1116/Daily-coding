public class Solution {
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    public void wallsAndGates(int[][] rooms) {
        //add all gates to a queue
        //then bfs
        //check visiting, and -1
        //no need to compare cur dist and prev dist
        //cuz the dist that was already marked comes from nearest gate
        //cuz bfs is using
        // write your code here
        Queue<Integer[]> q = new LinkedList<>();
        int ROWS = rooms.length, COLS = rooms[0].length;
        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                if(rooms[r][c] == 0) q.offer(new Integer[]{r,c});
            }
        }
        int dist = 1;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){

            int size = q.size();

            for(int i=0;i<size;i++){

                Integer[] cur = q.poll();

                for(int d=0;d<4;d++){

                    int nr = cur[0] + dirs[d][0];
                    int nc = cur[1] + dirs[d][1];

                    if(nr < 0 || nc < 0 || nr == ROWS || nc == COLS || rooms[nr][nc] == -1){
                        continue;
                    }
                    if(rooms[nr][nc] != 2147483647) continue;

                    q.offer(new Integer[]{nr,nc});
                    rooms[nr][nc] = dist;
                }
            }
            dist ++;
        }

    }
}
