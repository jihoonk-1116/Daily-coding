class MaxAreaOfIsland {
    
    int maxArea = 0;
    int curArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        
        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[0].length;col++){
                if(grid[row][col] == 1) {
                    islandArea(grid,row,col);
                    curArea = 0;
                }
                
            }
        }
        return maxArea; 
    }
    
    public void islandArea(int[][] grid, int r, int c){
        
        curArea ++;
        grid[r][c] = 0;
       
        if(r+1 < grid.length && c < grid[0].length && grid[r+1][c] == 1){
            islandArea(grid, r+1, c);
        }
        if(r < grid.length && c+1 < grid[0].length && grid[r][c+1] == 1){
            islandArea(grid, r, c+1);
        }
        if(r-1 >= 0 && c < grid[0].length && grid[r-1][c] == 1){
            islandArea(grid, r-1, c);
        }
        if(r < grid.length && c-1 >= 0 && grid[r][c-1] == 1){
            islandArea(grid, r, c-1);
        }
        
        maxArea = Math.max(maxArea, curArea);
        
    }
}
