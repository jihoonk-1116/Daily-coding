class SurroundedRegions {
    public void solve(char[][] board) {
        //dfs when o is found
        //if the dfs does not reach out to the boarder 
        //then no need to change 
        //ow change 
        //keep the path? -> list -> when a dfs is done, check 
        //how reaching boarder can be checked
        //using flag? -> if flag is true -> means that the path is surrounded
        
        //a list for storing path
        //flag - global 
        
        //== optimized approach
        //reverse thinking
        //capture unsurrounded region first with dfs 
        //search only boarder side regions
        int ROWS = board.length, COLS = board[0].length;
        
        for(int r=0;r<ROWS;r++){
            if(board[r][0] == 'O'){ //left side
                dfs(board, r, 0);
            }
            if(board[r][COLS-1] == 'O'){ //right side
                dfs(board, r, COLS-1);
            }
            for(int c=0;c<COLS;c++){
                if(board[0][c] == 'O'){ //top side
                    dfs(board, 0, c);
                }
                if(board[ROWS-1][c] == 'O'){ //bottom side
                    dfs(board, ROWS-1, c);
                }
            }
        }

        //capture surrounded region using for loop
        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                if(board[r][c] == 'O') board[r][c] = 'X'; 
            }
        }
        //upcapture unsurrounded region with for loop
         for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                if(board[r][c] == 'T') board[r][c] = 'O'; 
            }
        }
        
    }

    
    private void dfs(char[][] board, int r, int c){
        
        if(r<0 || c<0 || r == board.length || c == board[0].length){
            return;
        }
        if(board[r][c] == 'X' || board[r][c] == 'T') return;
        
  
        board[r][c] = 'T';
        
        dfs(board, r+1,c);
        dfs(board, r-1,c);
        dfs(board, r,c+1);
        dfs(board, r,c-1);
        
    }
}
