1class Solution {
2    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
19    int order[] = new int[numCourses];
20    while(!q.isEmpty()){
21        int course = q.poll();
22        order[count++] = course;
23        for(int next : graph.get(course)){
24            indegree[next]--;
25            if(indegree[next] == 0){
26                q.offer(next);
27            }
28        }
29    }
30    return count == numCourses ? order : new int[0];
31// Graph create pannrom
32// Zero indegree ah queue la add pannrom
33// Course complete panni count++ pannrom
34// Indegree zero na queue la add pannrom    
35    }
36}