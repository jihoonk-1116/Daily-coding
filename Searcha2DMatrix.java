class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //bst at column first 
        //then bst at row level
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int top = 0, bot = rows-1;
        int row = 0;
        
        while(top <= bot){
            
            row = (top+bot) /2;
            
            if(target > matrix[row][cols-1]) top = row + 1;
            else if(target < matrix[row][0]) bot = row - 1;
            else
                break;
        }
        
        if(top > bot) return false;
        
        int lt = 0, rt = cols - 1;
        
        while(lt <= rt){
            
            int col = (lt + rt) /2;
            
            if(matrix[row][col] == target) return true;
            else if(target < matrix[row][col]) rt = col -1;
            else lt = col + 1;
        }
        
        return false;
        
    }
}
