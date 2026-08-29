1class Solution {
2    public boolean validateStackSequences(int[] pushed, int[] popped) {
3    Stack<Integer> st = new Stack<>();
4    int i = 0;
5    for(int num : pushed){
6        st.push(num);
7        while(!st.isEmpty() && st.peek() == popped[i]){
8            st.pop();
9            i++;
10    }
11    }
12    return st.isEmpty();
13    }
14}