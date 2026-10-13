1class Solution {
2    int m, n;
3    public List<List<Integer>> pacificAtlantic(int[][] heights) {
4     m = heights.length;
5     n = heights[0].length;
6     boolean[][] pacific = new boolean[m][n];
7     boolean[][] atlantic = new boolean[m][n];
8     for(int c = 0; c < n; c++){
9        dfs(heights, 0, c, pacific);
10        dfs(heights, m-1, c, atlantic);
11     } 
12     for(int r = 0; r < m; r++){
13        dfs(heights, r, 0, pacific);
14        dfs(heights, r, n-1, atlantic);
15     }
16     List<List<Integer>> res = new ArrayList<>();
17     for(int i = 0; i < m; i++){
18        for(int j = 0; j < n; j++){
19        if(pacific[i][j] && atlantic[i][j]){
20            res.add(Arrays.asList(i,j));
21        }
22     }
23    }
24    return res;
25    }
26    private void dfs(int[][] heights, int r, int c, boolean visited[][]){
27        if(visited[r][c]){
28            return;
29        }
30        visited[r][c] = true;
31        int dir[][] = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
32        for(int i = 0; i < 4; i++){
33            int nr = r + dir[i][0];
34            int nc = c + dir[i][1];
35            if(nr >= 0 && nr < m && nc >= 0 && nc < n && heights[nr][nc] >= heights[r][c]){
36                dfs(heights, nr, nc, visited);
37            }
38        }
39    }
40}