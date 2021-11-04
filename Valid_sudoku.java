//My answer
//Iterate each row and column
//Still true -> then check 3x3 boxes

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        //0-8 
        int curline=0;
        while(curline < 9){
            for(int i=0; i<9;i++){
                if(!map.containsKey(board[i][curline])) map.put(board[i][curline]);
                else return false;
                
            }
            for(int j=0; j<9;j++){
                if(!map.containsKey(board[j][curline])) map.put(board[j][curline]);
                else return false;
            }
            curline++;
        }
        //3x3 0-2 3-5 6-8
        map.clear();
        curline=0;
        int checkedbox = 0;
        //0+ix3  
        while(checkedbox<9){
            while(curline < 9){
                for(int i=curline;i<curline+3;i++){ //curline +2
                    for(int j =curline+(3*checkedbox%3);j<curline+3;j++){
                        if(!map.containsKey(board[i][j])) map.put(board[i][j]);
                        else return false;
                    }

                }
            curline = curline + 3;
            checkedbox++;
            }
            curline=0;
        }
        return true;
    }
}

//Suggested solution

//Solved by StefanPochmann -> https://leetcode.com/problems/valid-sudoku/discuss/15472/Short%2BSimple-Java-using-Strings


public boolean isValidSudoku(char[][] board) {
    Set seen = new HashSet();
    for (int i=0; i<9; ++i) {
        for (int j=0; j<9; ++j) {
            if (board[i][j] != '.') {
                String b = "(" + board[i][j] + ")";
                if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i/3 + b + j/3))
                    return false;
            }
        }
    }
    return true;
}


// Solved by Lorraine921 -> https://leetcode.com/problems/valid-sudoku/discuss/15450/Shared-my-concise-Java-code

public boolean isValidSudoku(char[][] board) {
    for(int i = 0; i<9; i++){
        HashSet<Character> rows = new HashSet<Character>();
        HashSet<Character> columns = new HashSet<Character>();
        HashSet<Character> cube = new HashSet<Character>();
        for (int j = 0; j < 9;j++){
            if(board[i][j]!='.' && !rows.add(board[i][j]))
                return false;
            if(board[j][i]!='.' && !columns.add(board[j][i]))
                return false;
            int RowIndex = 3*(i/3);
            int ColIndex = 3*(i%3);
            if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                return false;
        }
    }
    return true;
}
