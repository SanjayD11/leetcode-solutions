1// DFS Approach :
2// class Solution {
3//     public void solve(char[][] board) {
4//         int rows = board.length;
5//         int cols = board[0].length;
6//         for(int i = 0; i < rows; i++){
7//             if(board[i][0] == 'O'){
8//                 dfs(board, i, 0);
9//             }
10//             if(board[i][cols-1] == 'O'){
11//                 dfs(board, i, cols-1);
12//             }
13//         }
14//         for(int j = 0; j < cols; j++){
15//             if(board[0][j] == 'O'){
16//                 dfs(board, 0, j);
17//             }
18//             if(board[rows-1][j] == 'O'){
19//                 dfs(board, rows-1, j);
20//             }
21//         }
22        
23//         for(int i = 0; i < rows; i++){
24//             for(int j = 0; j < cols; j++){
25//                 if(board[i][j] == 'O'){
26//                     board[i][j] = 'X';
27//                 }
28//                 else if(board[i][j] == 'T'){
29//                     board[i][j] = 'O';
30//                 }
31//             }
32//         }
33//     }
34//     private void dfs(char[][] board, int row, int col){
35//         if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 'O'){
36//             return;
37//         }
38//         board[row][col] = 'T';
39//         dfs(board, row-1, col);
40//         dfs(board, row+1, col);
41//         dfs(board, row, col-1);
42//         dfs(board, row, col+1);
43//     }
44// }
45/*
46Boundary la irukkura O cells la irundhu DFS start panni safe cells ah T mark pannrom.
47Connected boundary O cells ellam T a mark panni capture aagama save pannrom.
48Remaining O cells X a maathi, T cells ah back O a convert pannrom.
49*/
50
51// BFS Approach :
52class Solution {
53    public void solve(char[][] board) {
54        int rows = board.length;
55        int cols = board[0].length;
56        Queue<int[]> q = new LinkedList<>();
57        for(int i = 0; i < rows; i++){
58            if(board[i][0] == 'O'){
59                q.offer(new int[]{i, 0});
60                board[i][0] = 'T';
61            }
62            if(board[i][cols-1] == 'O'){
63                q.offer(new int[]{i, cols-1});
64                board[i][cols-1] = 'T';
65            }
66        }
67        for(int j = 0; j < cols; j++){
68            if(board[0][j] == 'O'){
69                q.offer(new int[]{0, j});
70                board[0][j] = 'T';
71            }
72            if(board[rows-1][j] == 'O'){
73                q.offer(new int[]{rows-1, j});
74                board[rows-1][j] = 'T';            }
75        }
76        while(!q.isEmpty()){
77            int curr[] = q.poll();
78            int r = curr[0];
79            int c = curr[1];
80            int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
81            for(int d[] : dir){
82                int nr = r + d[0];
83                int nc = c + d[1];
84                if(nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length && board[nr][nc] == 'O'){
85                    board[nr][nc] = 'T';
86                    q.offer(new int[]{nr, nc});
87                }
88            }
89        }
90        for(int i = 0; i < rows; i++){
91            for(int j = 0; j < cols; j++){
92                if(board[i][j] == 'O'){
93                    board[i][j] = 'X';
94                }
95                else if(board[i][j] == 'T'){
96                    board[i][j] = 'O';
97                }
98            }
99        }
100    }
101    }