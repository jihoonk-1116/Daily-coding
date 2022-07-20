//         Do note that this is for a sqaure matrix (NxN)
//        The process is to first transpose the matrix and then reverse it
//        Taking the first example: [[1,2,3],[4,5,6],[7,8,9]]
//        After Transpose: [[1,4,7],[2,5,8],[3,6,9]]
//        After Reversal: [[7,4,1],[8,5,2],[9,6,3]]

// class Solution {
//     public void rotate(int[][] matrix) {
//         int N = matrix.length;

//         transpose(matrix, N);
//         reverse(matrix, N);
//     }

//     void transpose(int[][] matrix, int n) {
//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 int t = matrix[i][j];
//                 matrix[i][j] = matrix[j][i];
//                 matrix[j][i] = t;
//             }
//         }
//     }

//     void reverse(int[][] matrix, int n) {
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n / 2; j++) {
//                 int temp = matrix[i][j];
//                 matrix[i][j] = matrix[i][n - 1 - j];
//                 matrix[i][n - 1 - j] = temp;
//             }
//         }
//     }
// }
class Solution {
     public void rotate(int[][] matrix) {
         int l = 0, r = matrix.length-1;
         
         while(l<r){
             for(int i=0;i<r-l;i++){
                 int top = l, bottom = r;
                 
                 int topLeft = matrix[top][l+i];
                 
                 matrix[top][l+i] = matrix[bottom-i][l];
                 matrix[bottom-i][l] = matrix[bottom][r-i];
                 matrix[bottom][r-i]=matrix[top+i][r];
                 matrix[top+i][r] = topLeft;
             }
             r--;
             l++;
         }
         
     }
}

/*
1 2 3
4 5 6
7 8 9

7 4 1
8 5 2
9 6 3

first column -> first row in reverse order
second column -> second row in reverse order
third column -> third row in reverse order
*/

//rotation represents switch rows to columns and their indices at the same time
