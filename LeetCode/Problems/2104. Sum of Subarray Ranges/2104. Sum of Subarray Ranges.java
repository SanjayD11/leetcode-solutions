1class Solution {
2    public long subArrayRanges(int[] nums) {
3        return subArrayRangeMax(nums) - subArrayRangeMin(nums);
4    }
5    private long subArrayRangeMin(int[] nums){
6    int n = nums.length;
7    Stack<Integer> st = new Stack<>();
8    int[] prevSmaller = new int[n];
9    int[] nextSmaller = new int[n];
10    for(int i = 0; i < n; i++){
11        while(!st.isEmpty() && nums[st.peek()] > nums[i]){
12            st.pop();
13        }
14        prevSmaller[i] = st.isEmpty() ? -1 : st.peek();
15        st.push(i);
16    }
17    st.clear();
18    for(int i = n-1; i >= 0; i--){
19        while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
20            st.pop();
21        }
22        nextSmaller[i] = st.isEmpty() ? n : st.peek();
23        st.push(i);
24    }
25    long sum = 0;
26    for(int i = 0; i < n; i++){
27        int leftCount = i - prevSmaller[i];
28        int rightCount = nextSmaller[i] - i;
29        sum = sum + (long)nums[i]*leftCount*rightCount;
30    }
31    return sum;
32    }
33    private long subArrayRangeMax(int[] nums){
34    int n = nums.length;
35    Stack<Integer> st = new Stack<>();
36    int[] prevGreater = new int[n];
37    int[] nextGreater = new int[n];
38    for(int i = 0; i < n; i++){
39        while(!st.isEmpty() && nums[st.peek()] < nums[i]){
40            st.pop();
41        }
42        prevGreater[i] = st.isEmpty() ? -1 : st.peek();
43        st.push(i);
44    }
45    st.clear();
46    for(int i = n-1; i >= 0; i--){
47        while(!st.isEmpty() && nums[st.peek()] <= nums[i]){
48            st.pop();
49        }
50        nextGreater[i] = st.isEmpty() ? n : st.peek();
51        st.push(i);
52    }
53    long sum = 0;
54    for(int i = 0; i < n; i++){
55        int leftCount = i - prevGreater[i];
56        int rightCount = nextGreater[i] - i;
57        sum = sum+ (long)nums[i]*leftCount*rightCount;
58    }
59    return sum;
60    }
61}
62
63/*
64Previous Greater and Next Greater index decreasing stack use panni find panrom.
65Current value vida smaller or equal values stack la irukka vida maatom.
66Left count = i - prevGreater, Right count = nextGreater - i calculate panrom.
67Current element maximum ah irukkura subarrays contribution add panrom.
68*/