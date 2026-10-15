1class Solution {
2    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
3        // Endha room visit pannom nu store panna
4        boolean[] visited = new boolean[rooms.size()];
5        // Room 0 la irundhu start pannu
6        dfs(0, rooms, visited);
7        // Ella rooms um visit aachaa nu check pannu
8        for (boolean room : visited) {
9            if (!room)
10                return false;
11        }
12        return true;
13    }
14    public void dfs(int room, List<List<Integer>> rooms, boolean[] visited) {
15        // Already visit pannirundha skip pannu
16        if (visited[room])
17            return;
18        // Current room visit panniten
19        visited[room] = true;
20        // Indha room la irukkura ella keys um eduthu
21        // andha room ku DFS pannu
22        for (int key : rooms.get(room)) {
23            dfs(key, rooms, visited);
24        }
25    }
26}