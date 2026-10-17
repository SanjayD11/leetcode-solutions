1//Union Find Approach :
2class Solution {
3    int parent[];
4    public int[] findRedundantConnection(int[][] edges) {
5    int n = edges.length;
6    parent = new int[n+1];
7    for(int i = 1; i <= n; i++){
8        parent[i] = i;
9    }
10    for(int edge[] : edges){
11        int a = edge[0];
12        int b = edge[1];
13        int pa = findP(a);
14        int pb = findP(b);
15        if(pa == pb){
16            return edge;
17        }
18        parent[pa] = pb;
19    }
20    return new int[0];
21    }
22    private int findP(int x){
23        if(parent[x] != x){
24            parent[x] = findP(parent[x]);
25        }
26        return parent[x];
27    }
28}
29// Find use panni rendu nodes oda representative kandupidikkrom
30// Different representative na rendu groups um separate ah irukku
31// Appo parent update panni rendu groups ah merge pannrom
32// Same representative na rendu nodes um already connected
33// Andha edge add panna cycle varum, so edge ah return pannrom
34
35// DFS Approach :
36// class Solution {
37//     public int[] findRedundantConnection(int[][] edges) {
38//         int n = edges.length;
39//         List<List<Integer>> graph = new ArrayList<>();
40//         for (int i = 0; i <= n; i++) {
41//             graph.add(new ArrayList<>());
42//         }
43//         for (int[] edge : edges) {
44//             int a = edge[0], b = edge[1];
45//             boolean[] visited = new boolean[n + 1];
46//             if (dfs(a, b, graph, visited)) {
47//                 return edge;
48//             }
49//             graph.get(a).add(b);
50//             graph.get(b).add(a);
51//         }
52//      return new int[0];
53//     }
54//     private boolean dfs(int node, int target,
55//                         List<List<Integer>> graph, boolean[] visited) {
56//         if (node == target) return true;
57//         visited[node] = true;
58//         for (int next : graph.get(node)) {
59//             if (!visited[next] && dfs(next, target, graph, visited)) {
60//                 return true;
61//             }
62//         }
63//         return false;
64//     }
65// }
66
67// BFS Approach :
68// class Solution {
69//     public int[] findRedundantConnection(int[][] edges) {
70//         int n = edges.length;
71//         List<List<Integer>> graph = new ArrayList<>();
72//         for (int i = 0; i <= n; i++) {
73//             graph.add(new ArrayList<>());
74//         }
75//         for (int[] edge : edges) {
76//             int a = edge[0], b = edge[1];
77//             if (bfs(a, b, graph, n)) {
78//                 return edge;
79//             }
80//             graph.get(a).add(b);
81//             graph.get(b).add(a);
82//         }
83//         return new int[0];
84//     }
85//     private boolean bfs(int start, int target,
86//                         List<List<Integer>> graph, int n) {
87//         boolean[] visited = new boolean[n + 1];
88//         Queue<Integer> q = new LinkedList<>();
89//         q.offer(start);
90//         visited[start] = true;
91//         while (!q.isEmpty()) {
92//             int node = q.poll();
93//             if (node == target) return true;
94//             for (int next : graph.get(node)) {
95//                 if (!visited[next]) {
96//                     visited[next] = true;
97//                     q.offer(next);
98//                 }
99//             }
100//         }
101//         return false;
102//     }
103// }