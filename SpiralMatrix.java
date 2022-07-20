class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rows = matrix.length;
        int columns = matrix[0].length;
        int top = 0;
        int left = 0;
        int right = columns - 1;
        int bottom = rows - 1;

        while (res.size() < rows * columns) {
            
            //move right
            for(int col=left;col<=right;col++){
                res.add(matrix[top][col]);
            }
            
            //move downwards
            for(int row=top+1;row<=bottom;row++){
                res.add(matrix[row][right]);
            }

            //if it's on different row
            if(top != bottom){
                //move right to left
                for(int col=right-1;col>=left;col--){
                    res.add(matrix[bottom][col]);
                }   
            }
            
            //if it's on different column
            if(left != right){
                //move upwards
                for(int row=bottom-1;row>top;row--){
                    res.add(matrix[row][left]);
                }
            }
                
            left++;
            right--;
            top++;
            bottom--;
        }

        return res;
    }
}
