1class Solution {
2    public String makeGood(String s) {
3    StringBuilder sb = new StringBuilder();
4    Stack<Character> st = new Stack<>();
5    for(char c : s.toCharArray()){
6        if(!st.isEmpty() && st.peek() != c && Character.toLowerCase(st.peek()) == Character.toLowerCase(c)){
7            st.pop();
8        }
9        else{
10            st.push(c);
11        }
12    }
13    for(char c : st){
14        sb.append(c);
15    }
16    return sb.toString();
17    }
18    }