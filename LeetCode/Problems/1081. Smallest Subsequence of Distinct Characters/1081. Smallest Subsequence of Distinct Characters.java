1class Solution {
2    public String smallestSubsequence(String s) {
3        boolean[] used = new boolean[26];
4        int[] lastIndex = new int[26];
5        Stack<Character> stack = new Stack<>();
6        // Store the LAST position of every character
7        for (int i = 0; i < s.length(); i++) {
8            char ch = s.charAt(i);
9            lastIndex[ch - 'a'] = i;
10        }
11        for (int i = 0; i < s.length(); i++) {
12            char current = s.charAt(i);
13            if (used[current - 'a']) {
14                continue;
15            }
16            while (!stack.isEmpty()
17                    && stack.peek() > current
18                    && lastIndex[stack.peek() - 'a'] > i) {
19                char removed = stack.pop();
20                used[removed - 'a'] = false;
21            }
22            stack.push(current);
23            used[current - 'a'] = true;
24        }
25        StringBuilder answer = new StringBuilder();
26        for (char ch : stack) {
27            answer.append(ch);
28        }
29        return answer.toString();
30    }
31}
32// Easy HashMap and HashSet Approach :
33// class Solution {
34//     public String smallestSubsequence(String s) {
35//     HashMap<Character, Integer> map = new HashMap<>();
36//     HashSet<Character> used = new HashSet<>();
37//     Stack<Character> stack = new Stack<>();
38//     for(char c : s.toCharArray()){
39//         map.put(c, map.getOrDefault(c, 0)+1);
40//     }    
41
42//     for(char c : s.toCharArray()){
43//         map.put(c, map.get(c)-1);
44//         if(used.contains(c)){
45//             continue;
46//         }
47//         while(!stack.isEmpty() && c < stack.peek() && map.get(stack.peek()) > 0){
48//             char removed = stack.pop();
49//             used.remove(removed);
50//         }
51//         stack.add(c);
52//         used.add(c);
53//     }
54//     StringBuilder sb = new StringBuilder();
55//     for(char c : stack){
56//         sb.append(c);
57//     }
58//     return sb.toString();
59//     }
60// }