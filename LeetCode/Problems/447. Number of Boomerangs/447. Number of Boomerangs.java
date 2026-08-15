1class Solution {
2    public int numberOfBoomerangs(int[][] points) {
3    int ans = 0;
4    for(int i = 0; i < points.length; i++){
5        HashMap<Integer, Integer> map = new HashMap<>();
6        for(int j = 0; j < points.length; j++){
7            if(i == j){
8                continue;
9            }
10            int dx = points[i][0] - points[j][0];
11            int dy = points[i][1] - points[j][1];
12            int distance = dx*dx + dy*dy;
13            map.put(distance, map.getOrDefault(distance, 0)+1);    
14        }
15        for(int count : map.values()){
16            ans += count*(count-1);
17        }
18    }
19    return ans;
20    }
21}