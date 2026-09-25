1// DFS Approach :
2// class Solution {
3//     public int numIslands(char[][] grid) {
4//     int islands = 0;
5//     int rows = grid.length;
6//     int cols = grid[0].length;
7//     for(int i = 0; i < rows; i++){
8//         for(int j = 0; j < cols; j++){
9//             if(grid[i][j] == '1'){
10//                 islands++;
11//                 dfs(grid, i, j);
12//             }
13//         }
14//     }
15//     return islands;
16//     }
17//     private void dfs(char[][] grid, int row, int col){
18//         if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length){
19//             return;
20//         }
21//         if(grid[row][col] == '0'){
22//             return;
23//         }
24//         grid[row][col] = '0';
25//         dfs(grid, row-1, col);
26//         dfs(grid, row+1, col);
27//         dfs(grid, row, col-1);
28//         dfs(grid, row, col+1);
29//     }
30// }
31
32// BFS Approach :
33class Solution {
34    public int numIslands(char[][] grid) {
35    int islands = 0;
36    int rows = grid.length;
37    int cols = grid[0].length;
38    for(int i = 0; i < rows; i++){
39        for(int j = 0; j < cols; j++){
40            if(grid[i][j] == '1'){
41                islands++;
42                bfs(grid, i, j);
43            }
44        }
45    }
46    return islands;
47    }
48    private void bfs(char[][] grid, int row, int col){
49        Queue<int[]> q = new LinkedList<>();
50        q.offer(new int[]{row, col});
51        grid[row][col] = '0';
52        int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
53        while(!q.isEmpty()){
54            int curr[] = q.poll();
55            int r = curr[0];
56            int c = curr[1];
57            for(int d[] : dir){
58                int nr = r + d[0];
59                int nc = c + d[1];
60                if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == '1'){
61                    grid[nr][nc] = '0';
62                    q.offer(new int[]{nr, nc});
63                }
64            }
65        } 
66    }
67}