1class Solution {
2    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
3        Map<String, Map<String, Double>> graph = new HashMap<>();
4        for(int i = 0; i < equations.size(); i++){
5            String varA = equations.get(i).get(0);
6            String varB = equations.get(i).get(1);
7            double value =  values[i];
8            graph.putIfAbsent(varA, new HashMap<>());
9            graph.putIfAbsent(varB, new HashMap<>());
10            graph.get(varA).put(varB, value);
11            graph.get(varB).put(varA, 1.0/value);
12        }
13        double[] ans = new double[queries.size()];
14    for(int i = 0; i < queries.size(); i++){
15        String source = queries.get(i).get(0);
16        String dest = queries.get(i).get(1);
17        ans[i] = dfs(source, dest, graph, new HashSet<>(), 1.0);
18    }
19    return ans;
20
21}
22public double dfs(String current,String target, Map<String, Map<String, Double>> graph, Set<String> visited,double productSoFar) {
23    // current variable graph la illa na answer kandupidikka mudiyadhu
24    if (!graph.containsKey(current)) {
25        return -1.0;
26    }
27    // target variable reach aagiduchuna current product answer
28    if (current.equals(target)) {
29        return productSoFar;
30    }
31    visited.add(current);
32    // current node oda ella neighbours um traverse panrom, Map.Entry means map la irukka oru key-value pair ah represent pannura object
33    for (Map.Entry<String, Double> entry :
34            graph.get(current).entrySet()) {
35        String next = entry.getKey();
36        double weight = entry.getValue();
37        if (visited.contains(next)) {
38            continue;
39        }
40        // for next node, productSoFar oda current edge weight multiply pannu
41        double result = dfs(
42                next,
43                target,
44                graph,
45                visited,
46                productSoFar * weight
47        );
48        if (result != -1.0) {
49            return result;
50        }
51    }
52    // entha path layum target reach aagala
53    return -1.0;
54}
55}