1class Solution {
2    public boolean isValid(String s) {
3        Stack <Character> st = new Stack <>();
4        for(char c : s.toCharArray()){
5           
6            if( (c=='('||c=='{'||c=='[')){
7                st.push(c);
8            }
9            else if(c==')'){
10                if(!st.isEmpty() && st.peek()=='('){
11                    st.pop();
12                }
13                else 
14                    return false;
15            }
16                else if(c=='}'){
17                if(!st.isEmpty() && st.peek()=='{'){
18                    st.pop();
19                }
20                else {
21                    return false;
22                }
23                }
24            else if(c==']'){
25                if(!st.isEmpty() && st.peek()=='['){
26                    st.pop();
27                }
28                else 
29                    return false;
30            }
31        }
32       return st.isEmpty();
33    }
34}
35
36    