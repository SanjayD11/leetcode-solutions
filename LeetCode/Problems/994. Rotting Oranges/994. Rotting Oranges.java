1class Solution {
2    public int orangesRotting(int[][] grid) {
3       int m = grid.length;
4       int n = grid[0].length;
5       Queue<int[]> q = new LinkedList<>();
6       int[][] dirs = {
7        {1,0},{-1,0},{0,1},{0,-1}
8       };
9        int fresh = 0;
10        int mins = 0;
11        for(int r = 0; r < m; r++){
12            for(int c = 0; c < n; c++){
13                if(grid[r][c] == 1){
14                    fresh++;
15                }
16                else if(grid[r][c] == 2){
17                    q.offer(new int[]{r, c});
18                }   
19            }
20        }
21        while(!q.isEmpty() && fresh > 0){
22            int size = q.size();
23            for(int i = 0; i < size; i++){
24                int[] orange = q.poll();
25                int row = orange[0];
26                int col = orange[1];
27            for(int[] dir : dirs){
28                int nr = row + dir[0];
29                int nc = col + dir[1];
30                if(nr >=0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1){
31                    grid[nr][nc] = 2;
32                    fresh--;
33                    q.offer(new int[]{nr, nc});
34                }
35            }
36        }
37        mins++;
38    }
39    return (fresh == 0) ? mins : -1;
40    }
41}