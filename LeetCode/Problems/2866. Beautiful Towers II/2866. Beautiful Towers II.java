1class Solution {
2    public long maximumSumOfHeights(List<Integer> maxHeights) {
3    int n = maxHeights.size();
4    long left[] = new long[n];
5    long right[] = new long[n];
6    Stack<Integer> st = new Stack<>();
7    for(int i = 0; i < n; i++){
8        while(!st.isEmpty() && maxHeights.get(st.peek()) > maxHeights.get(i)){
9            st.pop();
10        }
11        if(st.isEmpty()){
12            left[i] = (long)(i+1)*maxHeights.get(i);
13        }
14        else{
15            int prev = st.peek();
16            left[i] = left[prev]+ (long)(i-prev)*maxHeights.get(i);
17        }
18        st.push(i);
19    }    
20    st.clear();
21    for(int i = n-1; i >= 0; i--){
22        while(!st.isEmpty() && maxHeights.get(st.peek()) > maxHeights.get(i)){
23            st.pop();
24        }
25        if(st.isEmpty()){
26            right[i] = (long)(n-i)*maxHeights.get(i);
27        }
28        else{
29            int next = st.peek();
30            right[i] = right[next]+ (long)(next-i)*maxHeights.get(i);
31        }
32        st.push(i);
33    }
34    long ans = 0;
35    for(int i = 0; i < n; i++){
36        ans = Math.max(ans, (left[i]+right[i])-maxHeights.get(i));
37    }
38    return ans;    
39    }
40}