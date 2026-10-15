1//Iterative DFS (Using Stack) :
2class Solution {
3    public int findCircleNum(int[][] isConnected) {
4        // Total cities count
5        int n = isConnected.length;
6        // Endha city visit pannom nu track panna
7        boolean[] visited = new boolean[n];
8        // Province count
9        int provinces = 0;
10        // Ella cities-um iterate pannrom
11        for (int i = 0; i < n; i++) {
12            // Indha city innum visit aagala na
13            // pudhu province start aaguthu
14            if (!visited[i]) {
15                // DFS-ku stack use pannrom
16                Stack<Integer> stack = new Stack<>();
17                // Starting city push pannrom
18                stack.push(i);
19                // Stack empty aagara vara continue pannrom
20                while (!stack.isEmpty()) {
21                    // Top city eduthu pop pannrom
22                    int current = stack.pop();
23                    // Already visit pannalana process pannrom
24                    if (!visited[current]) {
25                        // Current city visited nu mark pannrom
26                        visited[current] = true;
27                        // Current city oda neighbours check pannrom
28                        for (int j = 0; j < n; j++) {
29                            // Connected ah irundhu & visit pannalana..
30                            // stackla push pannrom
31                            if (isConnected[current][j] == 1 && !visited[j]) {
32                                stack.push(j);
33                            }
34                        }
35                    }
36                }
37                // Oru connected component complete
38                // so province count increase pannrom
39                provinces++;
40            }
41        }
42        return provinces;
43    }
44}
45//Recursive DFS :
46// class Solution {
47//     public int findCircleNum(int[][] isConnected) {
48//         // Total number of cities
49//         int n = isConnected.length;
50//         // City visit pannoma illa nu check panna
51//         boolean[] visited = new boolean[n];
52//         // Province count
53//         int provinces = 0;
54//         // Ella cities-um traverse pannrom
55//         for (int i = 0; i < n; i++) {
56//             // Visit pannalana new province start
57//             if (!visited[i]) {
58//                 // DFS call pannrom
59//                 dfs(i, isConnected, visited);
60//                 // Oru province full explore pannitom
61//                 provinces++;
62//             }
63//         }
64//         return provinces;
65//     }
66//     // Recursive DFS function
67//     private void dfs(int city, int[][] isConnected, boolean[] visited) {
68//         // Current city visited nu mark pannrom
69//         visited[city] = true;
70//         // Current city oda ella neighbours-um check pannrom
71//         for (int j = 0; j < isConnected.length; j++) {
72//             // Connection irundha & visit pannalana
73//             // recursive DFS call pannrom
74//             if (isConnected[city][j] == 1 && !visited[j]) {
75//                 dfs(j, isConnected, visited);
76//             }
77//         }
78//     }
79// }