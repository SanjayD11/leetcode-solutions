1//DFS Approach
2class Solution {
3    public int minReorder(int n, int[][] connections) {
4        List<List<int[]>> graph = new ArrayList<>();
5        for (int i = 0; i < n; i++) {
6            graph.add(new ArrayList<>());
7        }
8        for (int[] edge : connections) {
9            int from = edge[0];
10            int to = edge[1];
11            graph.get(from).add(new int[]{to, 1});
12            graph.get(to).add(new int[]{from, 0});
13        }
14
15        boolean[] visited = new boolean[n];
16        return dfs(0, graph, visited);
17    }
18
19    public int dfs(int node, List<List<int[]>> graph, boolean[] visited) {
20        visited[node] = true;
21        int changes = 0;
22
23        for (int[] neighbour : graph.get(node)) {
24            int next = neighbour[0];
25            int cost = neighbour[1];
26
27            if (!visited[next]) {
28                changes += cost;
29                changes += dfs(next, graph, visited);
30            }
31        }
32        return changes;
33    }
34}
35//BFS Approach
36// class Solution {
37//     public int minReorder(int n, int[][] connections) {
38//         List<List<int[]>> graph = new ArrayList<>();
39//         for (int i = 0; i < n; i++) {
40//             graph.add(new ArrayList<>());
41//         }
42//         for (int[] edge : connections) {
43//             int from = edge[0];
44//             int to = edge[1];
45//             graph.get(from).add(new int[]{to, 1});
46//             graph.get(to).add(new int[]{from, 0});
47//         }
48//         Queue<Integer> queue = new LinkedList<>();
49//         boolean[] visited = new boolean[n];
50//         queue.offer(0);
51//         visited[0] = true;
52//         int changes = 0;
53//         while (!queue.isEmpty()) {
54//             int node = queue.poll();
55//             for (int[] neighbor : graph.get(node)) {
56//                 int next = neighbor[0];
57//                 int cost = neighbor[1];
58//                 if (!visited[next]) {
59//                     visited[next] = true;
60//                     changes += cost;
61//                     queue.offer(next);
62//                 }
63//             }
64//         }
65//         return changes;
66//     }
67// }
68// Traverses only unvisited nodes to ensure we always move outward from node 0 (parent -> child).
69// This guarantees each road is counted exactly once and ignores the reverse edge back to the parent.