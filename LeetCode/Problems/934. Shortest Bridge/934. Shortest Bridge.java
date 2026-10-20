1class Solution {
2    int n;
3    int dir[][] = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
4    Queue<int[]> q = new LinkedList<>();
5    public int shortestBridge(int[][] grid) {
6        n = grid.length;
7        boolean found = false;
8        for(int i = 0; i < n && !found; i++){
9            for(int j = 0; j < n && !found; j++){
10                if(grid[i][j] == 1){
11                    dfs(grid, i, j);
12                    found = true;
13                }
14            }
15            }
16            int steps = 0;
17            while(!q.isEmpty()){
18                int size = q.size();
19                for(int i = 0; i < size; i++){
20                    int[] cell = q.poll();
21                    int r = cell[0];
22                    int c = cell[1];
23                    for(int d[] : dir){
24                      int nr = r + d[0];
25                      int nc = c + d[1];
26                        if(nr < 0 || nr >= n || nc < 0 || nc >= n){
27                            continue;
28                        }
29                        if(grid[nr][nc] == 1){
30                            return steps;
31                        }
32                        if(grid[nr][nc] == 0){
33                            grid[nr][nc] = 2;
34                            q.offer(new int[]{nr, nc});
35                        }
36                    }
37                }
38                steps++;
39            }
40            return steps;
41    }
42    private void dfs(int[][] grid, int r, int c){
43        if(r < 0 || c < 0 || r >= n || c >= n || grid[r][c] != 1){
44            return;
45        }
46        grid[r][c] = 2;
47        q.offer(new int[]{r, c});
48        for(int[] d : dir){
49            dfs(grid, r + d[0], c + d[1]);
50        }
51    }
52}