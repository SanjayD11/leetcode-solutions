1class Solution {
2    public boolean isValid(String s) {
3        Stack <Character> st = new Stack <>();
4        for (int i = 0; i< s.length();i++) {
5            char c = s.charAt(i);
6           
7            if( (c=='('||c=='{'||c=='[')){
8                st.push(c);
9            }
10            else if(c==')'){
11                if(!st.isEmpty() && st.peek()=='('){
12                    st.pop();
13                }
14                else 
15                    return false;
16            }
17                else if(c=='}'){
18                if(!st.isEmpty() && st.peek()=='{'){
19                    st.pop();
20                }
21                else {
22                    return false;
23                }
24                }
25            else if(c==']'){
26                if(!st.isEmpty() && st.peek()=='['){
27                    st.pop();
28                }
29                else 
30                    return false;
31            }
32        }
33       return st.isEmpty();
34    }
35}
36
37    