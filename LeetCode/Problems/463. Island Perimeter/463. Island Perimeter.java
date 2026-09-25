1// DFS Approach :
2class Solution {
3    public int islandPerimeter(int[][] grid) {
4    for(int i = 0; i < grid.length; i++){
5        for(int j = 0; j < grid[0].length; j++){
6            if(grid[i][j] == 1){
7               return dfs(grid, i, j);
8            }
9        }
10    }    
11    return 0;
12    }
13    private int dfs(int[][] grid, int row, int col){
14        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length){
15            return 1;
16        }
17        if(grid[row][col] == 0){
18            return 1;
19        }
20        if(grid[row][col] == -1){
21            return 0;
22        }
23        grid[row][col] = -1;
24        int perimeter = 0;
25        perimeter += dfs(grid, row-1, col);
26        perimeter += dfs(grid, row+1, col);
27        perimeter += dfs(grid, row, col-1);
28        perimeter += dfs(grid, row, col+1);
29        return perimeter;
30    }
31}