1class Solution {
2    public boolean exist(char[][] board, String word) {
3        int rows = board.length;
4        int cols = board[0].length;
5        for (int i = 0; i < rows; i++) {
6            for (int j = 0; j < cols; j++) {
7                if (board[i][j] == word.charAt(0) && helper(board, word, i, j, 0)) {
8                    return true;
9                }
10            }
11        }
12        return false;
13    }
14
15    private boolean helper(char[][] board, String word, int i, int j, int count) {
16        if (count == word.length()) {
17            return true;
18        }
19
20        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(count)) {
21            return false;
22        }
23
24        char temp = board[i][j];
25        board[i][j] = ' ';
26        boolean found = helper(board, word, i + 1, j, count + 1)
27                     || helper(board, word, i - 1, j, count + 1)
28                     || helper(board, word, i, j + 1, count + 1)
29                     || helper(board, word, i, j - 1, count + 1);
30        
31        board[i][j] = temp;
32        return found;
33    }
34}