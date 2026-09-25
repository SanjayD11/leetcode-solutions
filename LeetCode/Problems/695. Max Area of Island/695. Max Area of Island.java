1// DFS Approach :
2// class Solution {
3//     public int maxAreaOfIsland(int[][] grid) {
4//     int maxArea = 0;
5//     int rows = grid.length;
6//     int cols = grid[0].length;
7//     for(int i = 0; i < rows; i++){
8//         for(int j = 0; j < cols; j++){
9//             if(grid[i][j] == 1){
10//                int area = dfs(grid, i, j);
11//                maxArea = Math.max(maxArea, area);
12//             }
13//         }
14//     }
15//     return maxArea;
16//     }
17//     private int dfs(int[][] grid, int row, int col){
18//         if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length){
19//             return 0;
20//         }
21//         if(grid[row][col] == 0){
22//             return 0;
23//         }
24//         grid[row][col] = 0;
25//         int area = 1;
26//         area += dfs(grid, row-1, col);
27//         area += dfs(grid, row+1, col);
28//         area += dfs(grid, row, col-1);
29//         area += dfs(grid, row, col+1);
30//         return area;
31//     }
32// }
33
34
35// BFS Approach :
36class Solution {
37    public int maxAreaOfIsland(int[][] grid) {
38    int maxArea = 0;
39    int rows = grid.length;
40    int cols = grid[0].length;
41    for(int i = 0; i < rows; i++){
42        for(int j = 0; j < cols; j++){
43            if(grid[i][j] == 1){
44                int area = bfs(grid, i, j);
45                maxArea = Math.max(maxArea, area);
46            }
47        }
48    }
49    return maxArea;
50    }
51    private int bfs(int[][] grid, int row, int col){
52        Queue<int[]> q = new LinkedList<>();
53        q.offer(new int[]{row, col});
54        grid[row][col] = 0;
55        int area = 1;
56        int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
57        while(!q.isEmpty()){
58            int curr[] = q.poll();
59            int r = curr[0];
60            int c = curr[1];
61            for(int d[] : dir){
62                int nr = r + d[0];
63                int nc = c + d[1];
64                if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1){
65                    grid[nr][nc] = 0;
66                    area++;
67                    q.offer(new int[]{nr, nc});
68                }
69            }
70        } 
71        return area;
72    }
73}