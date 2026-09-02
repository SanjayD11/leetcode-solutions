1class Solution {
2    public int sumSubarrayMins(int[] arr) {
3    int modulo = 1000000007;
4    int n = arr.length;
5    int[] prevSmall = new int[n];
6    int[] nextSmall = new int[n];
7    Stack<Integer> st = new Stack<>();
8    for(int i = 0; i < n; i++){
9        while(!st.isEmpty() && arr[st.peek()] > arr[i]){
10            st.pop();
11        }
12        prevSmall[i] = st.isEmpty() ? -1 : st.peek();
13        st.push(i);
14    }
15    st.clear();
16    for(int i = n-1; i >= 0; i--){
17        while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
18            st.pop();
19        }
20        nextSmall[i] = st.isEmpty() ? n : st.peek();
21        st.push(i);
22    }
23    long sum = 0;
24    for(int i = 0; i < n; i++){
25        int leftSubMinCount = i - prevSmall[i];
26        int rightSubMinCount = nextSmall[i] - i;
27        sum = (sum+(long)arr[i]*leftSubMinCount*rightSubMinCount)%modulo;
28    }
29    return (int)sum;
30    }
31}