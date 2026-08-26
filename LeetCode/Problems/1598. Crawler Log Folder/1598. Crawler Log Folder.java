1class Solution {
2    public int minOperations(String[] logs) {
3    Stack<String> st = new Stack<>();
4    for(String log : logs){
5        if(log.equals(../)){
6           if(!st.isEmpty()){
7            st.pop();
8           }
9        }
10        else if(log.equals(./)){
11            continue;
12        }
13        else{
14            st.push(log);
15        }
16    }
17    return st.size();
18    }
19}