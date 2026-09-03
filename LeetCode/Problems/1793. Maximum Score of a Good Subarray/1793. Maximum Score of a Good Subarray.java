1// Two Pointer Approach :
2class Solution {
3    public int maximumScore(int[] nums, int k) {
4    int n = nums.length;
5    int left = k;
6    int right = k;
7    int min = nums[k];
8    int ans = min;
9    while(left > 0 || right < n-1){
10        if(left == 0){
11            right++;
12        }
13        else if(right == n-1){
14            left--;
15        }
16        else if(nums[left-1] < nums[right+1]){
17            right++;
18        }
19        else{
20            left--;
21        }
22        min = Math.min(min, Math.min(nums[left], nums[right]));
23        ans = Math.max(ans, min*(right-left+1));
24    }    
25    return ans;
26    }
27}
28
29//  Monotonic Stack Approach :
30// class Solution {
31//     public int maximumScore(int[] nums, int k) {
32//         int ans = nums[k];
33//         int n = nums.length;
34//         Stack<Integer> st = new Stack<>();
35//         int prevSmaller[] = new int[n];
36//         int nextSmaller[] = new int[n];
37//         for(int i = 0; i < n; i++){
38//             while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
39//                 st.pop();
40//             }
41//             prevSmaller[i] = st.isEmpty() ? -1 : st.peek();
42//             st.push(i);
43//         }
44//         st.clear();
45//         for(int i = n-1; i >= 0; i--){
46//             while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
47//                 st.pop();
48//             }
49//             nextSmaller[i] = st.isEmpty() ? n : st.peek();
50//             st.push(i);
51//         }
52//         for(int i = 0; i < n; i++){
53//             int l = prevSmaller[i]+1;
54//             int r = nextSmaller[i]-1;
55//             if(l <= k && k <= r){
56//                 int width = r-l+1;
57//                 int score = nums[i]*width;
58//                 ans = Math.max(ans, score);
59//             }
60//         }
61//         return ans;
62//     }
63// }