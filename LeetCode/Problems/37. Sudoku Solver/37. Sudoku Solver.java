1class Solution {
2    public void solveSudoku(char[][] board) {
3        if (board == null || board.length == 0) {
4            return;
5        }
6        solve(board);
7    }
8    public boolean solve(char[][] board) {
9        for (int i = 0; i < board.length; i++) {
10            for (int j = 0; j < board[0].length; j++) {
11                if (board[i][j] == '.') {
12                    for (char c = '1'; c <= '9'; c++) {
13                        if (isValid(board, i, j, c)) {
14                            board[i][j] = c;
15                            if (solve(board)) {
16                                return true;
17                            }
18                            board[i][j] = '.';
19                        }
20                    }
21                    // Tried all numbers but edhumae work aagala means...
22                    return false;
23                }
24            }
25        }
26        // empty cells aeh illa 
27        return true;
28    }
29    private boolean isValid(char[][] board, int row, int col, char c) {
30        int nr = 3 * (row / 3);// normalize panna row
31        int nc = 3 * (col / 3);// normalize panna column, nr and nc are current 3*3 BOX starting pos
32        for (int i = 0; i < 9; i++) {
33            if (board[i][col] == c) {
34                return false;
35            }
36            if (board[row][i] == c) {
37                return false;
38            }
39            if (board[nr + i / 3][nc + i % 3] == c) { // from 0 to 8 of the current box we traverse and check
40                return false;
41            }
42        }
43        return true;
44    }
45}
46// Also try Valid Sudoku(prob. 36)