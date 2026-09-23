1// DFS Approach :
2// class Solution {
3//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
4//     int original = image[sr][sc];
5//     if(image[sr][sc] == color){
6//         return image;
7//     }    
8//     dfs(image, sr, sc, original, color);
9//     return image;
10//     }
11//     private void dfs(int[][] image, int row, int col, int original, int color){
12//      if(row < 0 || col < 0 || row >= image.length || col >= image[0].length){
13//         return;
14//      }   
15//      if(image[row][col] != original){
16//         return;
17//      }
18//      image[row][col] = color;
19//      dfs(image, row-1, col, original, color);
20//      dfs(image, row+1, col, original, color);
21//      dfs(image, row, col-1, original, color);
22//      dfs(image, row, col+1, original, color);
23     
24//     }
25// }
26
27// BFS Approach :
28class Solution {
29    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
30    int original = image[sr][sc];
31    if(image[sr][sc] == color){
32        return image;
33    }
34    Queue<int[]> q = new LinkedList<>();
35    q.offer(new int[]{sr, sc});
36    image[sr][sc] = color;
37    int[][] dir = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};
38    while(!q.isEmpty()){
39        int []cell = q.poll();
40        int r = cell[0];
41        int c = cell[1];
42        for(int d[] : dir){
43            int nr = r + d[0];
44            int nc = c + d[1];
45            if(nr >= 0 && nc >= 0 && nr < image.length && nc < image[0].length && image[nr][nc] == original){
46                image[nr][nc] = color;
47                q.offer(new int[]{nr, nc});
48            }
49        }
50    }
51    return image;
52    }
53}