1class Solution {
2    public String removeKdigits(String num, int k) {
3    Stack<Character> st = new Stack<>();
4    for(char c : num.toCharArray()){
5        while(!st.isEmpty() && k>0 && st.peek() > c){
6            st.pop();
7            k--;
8        }
9        st.push(c);
10    } 
11    while(!st.isEmpty() && k > 0){
12        st.pop();
13        k--;
14    }
15    StringBuilder sb = new StringBuilder();
16    for(char c : st){
17        sb.append(c);
18    }
19    while(sb.length() > 0 && sb.charAt(0) == '0'){
20        sb.deleteCharAt(0);
21    }
22    return (sb.length() == 0) ? 0 : sb.toString();
23    }
24}
25
26/*
271. Monotonic Increasing Stack use pannrom to keep digits in smallest possible order.
282. Stack top > current digit and k > 0 na bigger digit ah remove (pop) pannrom.
293. Remaining digits build answer; extra k na end la remove, leading zeros skip pannrom.
30*/