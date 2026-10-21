1class Solution {
2    public int rob(int[] nums) {
3        if(nums.length == 1){
4            return nums[0];
5        }
6        nums[1] = Math.max(nums[1], nums[0]);
7        for(int i = 2; i < nums.length; i++){
8            nums[i] = Math.max(nums[i-1], nums[i-2]+nums[i]);
9        }
10        return nums[nums.length-1];
11    }
12}