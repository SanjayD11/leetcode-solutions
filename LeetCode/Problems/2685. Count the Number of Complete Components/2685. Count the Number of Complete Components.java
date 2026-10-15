1// BFS Approach :
2class Solution {
3    public int countCompleteComponents(int n, int[][] edges) {
4    List<List<Integer>> graph = new ArrayList<>();
5    for(int i = 0; i < n; i++){
6        graph.add(new ArrayList<>());
7    }
8    boolean[] visited = new boolean[n];
9    int ans = 0;
10    for(int e[] : edges){
11        graph.get(e[0]).add(e[1]);
12        graph.get(e[1]).add(e[0]);
13    } 
14    for(int i = 0; i < n; i++){
15        if(visited[i]){
16            continue;
17        }
18        Queue<Integer> q = new LinkedList<>();
19        q.offer(i);
20        visited[i] = true;
21        int nodes = 0;
22        int degSum = 0;
23        while(!q.isEmpty()){
24        int curr = q.poll();
25        nodes++;
26        degSum += graph.get(curr).size();
27        for(int next : graph.get(curr)){
28            if(!visited[next]){
29                q.offer(next);
30                visited[next] = true;
31            }
32        }
33        }
34        int actualEdges = degSum/2;
35        int requiredEdges = nodes*(nodes-1)/2;
36        if(actualEdges == requiredEdges){
37            ans++;
38        }
39    }
40    return ans;
41    }
42}
43// Edges use panni adjacency list create pannrom
44// Visited illa na BFS start panni component nodes find pannrom
45// Nodes count and degree sum calculate pannrom
46// Degree sum / 2 actual edges; nodes * (nodes - 1) / 2 required edges
47// Rendu edges count equal na complete component count increase pannrom
48
49// DFS Approach :
50// class Solution {
51//     public int countCompleteComponents(int n, int[][] edges) {
52//         List<List<Integer>> graph = new ArrayList<>();
53//         for (int i = 0; i < n; i++) {
54//             graph.add(new ArrayList<>());
55//         }
56//         for (int[] e : edges) {
57//             graph.get(e[0]).add(e[1]);
58//             graph.get(e[1]).add(e[0]);
59//         }
60//         boolean[] visited = new boolean[n];
61//         int ans = 0;
62//         for (int i = 0; i < n; i++) {
63//             if (!visited[i]) {
64//                 List<Integer> component = new ArrayList<>();
65//                 dfs(i, graph, visited, component);
66//                 int degreeSum = 0;
67//                 for (int node : component) {
68//                     degreeSum += graph.get(node).size();
69//                 }
70//                 int nodes = component.size();
71//                 int actualEdges = degreeSum / 2;
72//                 int requiredEdges = nodes * (nodes - 1) / 2;
73//                 if (actualEdges == requiredEdges) {
74//                     ans++;
75//                 }
76//             }
77//         }
78//         return ans;
79//     }
80//     private void dfs(int node, List<List<Integer>> graph,
81//                      boolean[] visited, List<Integer> component) {
82//         visited[node] = true;
83//         component.add(node);
84//         for (int next : graph.get(node)) {
85//             if (!visited[next]) {
86//                 dfs(next, graph, visited, component);
87//             }
88//         }
89//     }
90// }
91// Edges use panni adjacency list create pannrom
92// Visited illa na DFS call panni component nodes collect pannrom
93// Component la irukkura ovvoru node oda degree sum calculate pannrom
94// Actual edges = degreeSum / 2; required edges = nodes * (nodes - 1) / 2
95// Rendu equal na complete component count increase pannrom