1class Solution {
2    public List<String> removeInvalidParentheses(String s) {
3    List<String> ans = new ArrayList<>();
4    Queue<String> q = new LinkedList<>();
5    HashSet<String> visited = new HashSet<>();
6    q.offer(s);
7    visited.add(s);
8    boolean found = false;
9    while(!q.isEmpty()){
10        String curr = q.poll();
11        if(isValid(curr)){
12            ans.add(curr);
13            found = true;
14        }
15        if(found){
16            continue;
17        }
18        for(int i = 0; i < curr.length(); i++){
19            char c = curr.charAt(i);
20            if(c!='(' && c!=')'){
21                continue;
22            }
23            String next = curr.substring(0, i) + curr.substring(i+1);
24            if(!visited.contains(next)){
25                visited.add(next);
26                q.offer(next);
27            }
28        }
29
30    }   
31        return ans;
32    }
33    private boolean isValid(String s){
34        int balance = 0;
35        for(char c : s.toCharArray()){
36            if(c == '('){
37                balance++;
38            }
39            else if(c == ')'){
40                balance--;
41                if(balance < 0){
42                    return false;
43                }
44            }
45        }
46        return balance==0;
47    }
48}