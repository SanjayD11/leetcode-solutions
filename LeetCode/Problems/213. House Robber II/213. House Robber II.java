1class Solution {
2    public int rob(int[] nums) {
3    int n = nums.length;
4    if(nums.length == 1){
5        return nums[0];
6    }
7    return Math.max(rob(nums, 0, n-2), rob(nums, 1, n-1));
8    }
9    private int rob(int[] nums, int start, int end){
10        int prev2 = 0;
11        int prev1 = 0;
12        for(int i = start; i <= end; i++){
13            int curr = Math.max(prev1, prev2+nums[i]);
14            prev2 = prev1;
15            prev1 = curr;
16        }
17        return prev1;
18    }
19}