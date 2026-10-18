1class Solution {
2    List<List<String>> result;
3    public List<List<String>> solveNQueens(int n) {
4    result = new ArrayList<>();
5    char[][] board = new char[n][n];
6    for(int i = 0; i < n; i++){
7        for(int j = 0; j < n; j++){
8            board[i][j] = '.';
9        }
10    } 
11       List<int[]> queens = new ArrayList<>(); // positions
12       dfs(board, 0, queens);
13       return result;
14    }
15    public void dfs(char[][] board, int r, List<int[]> queens){
16        if(queens.size() == board.length){
17            List<String> rows = new ArrayList<>();
18            for(char[] row : board){
19                rows.add(new String(row));
20            }
21        result.add(rows);
22        return;
23        }
24        for(int c = 0; c < board.length; c++){
25            if(canPlaceQueen(r, c, queens)){
26                board[r][c] = 'Q';
27                queens.add(new int[]{r,c});
28                dfs(board, r+1, queens);
29                board[r][c] = '.';
30                queens.remove(queens.size()-1);
31            }
32        }
33    }
34    private boolean canPlaceQueen(int row, int col, List<int[]> queens){
35        for(int q[] : queens){
36        int dx = Math.abs(row - q[0]);
37        int dy = Math.abs(col - q[1]);
38        if(dx == 0 || dy == 0 || dx == dy){
39            return false;
40        }
41    }
42        return true;
43
44    }
45}