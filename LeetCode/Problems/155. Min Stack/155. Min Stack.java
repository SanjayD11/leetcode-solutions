1class MinStack {
2    private Stack<Integer> st;
3    private Stack<Integer> minSt;
4    public MinStack() {
5    st = new Stack<>();
6    minSt = new Stack<>();
7    }    
8    public void push(int value) {
9        st.push(value);
10        if(minSt.isEmpty()){
11            minSt.push(value);
12        }
13        else{
14            minSt.push(Math.min(value, minSt.peek()));
15        }
16    }
17    public void pop() {
18        st.pop();
19        minSt.pop();
20    }
21    
22    public int top() {
23        return st.peek();
24    }
25    public int getMin() {
26        return minSt.peek();
27    }
28}
29
30/**
31 * Your MinStack object will be instantiated and called as such:
32 * MinStack obj = new MinStack();
33 * obj.push(value);
34 * obj.pop();
35 * int param_3 = obj.top();
36 * int param_4 = obj.getMin();
37 */