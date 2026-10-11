1class Solution {
2    public boolean canFinish(int numCourses, int[][] prerequisites) {
3    List<List<Integer>> graph = new ArrayList<>();
4    int indegree[] = new int[numCourses];
5    for(int i = 0; i < numCourses; i++){
6        graph.add(new ArrayList<>());
7    }    
8    for(int[] p: prerequisites){
9        graph.get(p[1]).add(p[0]);
10        indegree[p[0]]++;
11    }
12    Queue<Integer> q = new LinkedList<>();
13    int count = 0;
14    for(int i = 0; i < numCourses; i++){
15        if(indegree[i] == 0){
16            q.offer(i);
17        }
18    }
19    while(!q.isEmpty()){
20        int course = q.poll();
21        count++;
22        for(int next : graph.get(course)){
23            indegree[next]--;
24            if(indegree[next] == 0){
25                q.offer(next);
26            }
27        }
28    }
29    return count == numCourses;
30    }
31}