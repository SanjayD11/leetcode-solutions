1// Stack Approach using Indices : 
2class Solution {
3    public int longestValidParentheses(String s) {
4    Stack<Integer> st = new Stack<>();
5    st.push(-1);
6    int max = 0;
7    for(int i = 0; i < s.length(); i++){
8        char c = s.charAt(i);
9        if(c == '('){
10            st.push(i);
11        }
12        else{
13            st.pop();
14            if(st.isEmpty()){
15                st.push(i);
16            }
17            else{
18                int len = i - st.peek();
19                max = Math.max(max, len);
20            }
21        }
22    }    
23    return max;
24    }
25}
26
27//Brute Force Approach :
28// class Solution {
29//     public int longestValidParentheses(String s) {
30//         int max = 0;
31
32//         for (int i = 0; i < s.length(); i++) {
33//             for (int j = i + 2; j <= s.length(); j += 2) { // only even lengths
34//                 if (isValid(s.substring(i, j))) {
35//                     max = Math.max(max, j - i);
36//                 }
37//             }
38//         }
39
40//         return max;
41//     }
42
43//     boolean isValid(String str) {
44//         Stack<Character> st = new Stack<>();
45
46//         for (char c : str.toCharArray()) {
47//             if (c == '(') st.push(c);
48//             else {
49//                 if (st.isEmpty()) return false;
50//                 st.pop();
51//             }
52//         }
53
54//         return st.isEmpty();
55//     }
56// }
57
58
59// OPEN/CLOSE Counter method :
60// class Solution {
61//     public int longestValidParentheses(String s) {
62//         int open = 0, close = 0, max = 0;
63
64//         for (int i = 0; i < s.length(); i++) {
65//             char c = s.charAt(i);
66
67//             if (c == '(') open++;
68//             else close++;
69
70//             if (open == close) {
71//                 max = Math.max(max, open + close);
72//             } else if (close > open) {
73//                 open = close = 0;
74//             }
75//         }
76
77//         open = close = 0;
78
79//         for (int i = s.length() - 1; i >= 0; i--) {
80//             char c = s.charAt(i);
81
82//             if (c == '(') open++;
83//             else close++;
84
85//             if (open == close) {
86//                 max = Math.max(max, open + close);
87//             } else if (open > close) {
88//                 open = close = 0;
89//             }
90//         }
91
92//         return max;
93//     }
94// }