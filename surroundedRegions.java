public class Solution {
    // first check the border of the matrix. change 'O' and its adjacent 'O' neighbor to '#'
    // Then, change 'O' to 'X'
    // change '#' to 'O'
    public void solve(char[][] board) {
       if (board == null || board.length == 0) {
           return;
       }
       int row = board.length, col = board[0].length;
       
       // check the begin and end for a row
       for (int i = 0; i < row; i++) {
           check(board, i, 0, row, col);
           if (col > 1) {
               check(board, i, col - 1, row, col);
           }
       }
       // check the top and bottom for a col
       for (int j = 1; j < col; j++) {
           check(board, 0, j, row, col);
           if (row > 1) {
               check(board, row - 1, j, row, col);
           }
       }
       
       // change 'O' to 'X' and change '#' to 'O'
       for (int i = 0; i < row; i++) {
           for (int j = 0; j < col; j++) {
               if (board[i][j] == 'O') {
                   board[i][j] = 'X';
               }
               if (board[i][j] == '#') {
                   board[i][j] = 'O';
               }
           }
       }
    }
    private void check(char[][] board, int i, int j, int row, int col) {
          if (board[i][j] == 'O') {
               board[i][j] = '#';
               if (i > 1) {
                   check (board, i - 1, j, row, col);
               }
               if (j > 1) {
                   check (board, i, j - 1, row, col);
               }
               if (i + 1 < row) {
                   check(board, i + 1, j, row, col);
               }
               if (j + 1 < col) {
                   check(board, i, j + 1, row, col);
               }
           }
     }
        
 }
