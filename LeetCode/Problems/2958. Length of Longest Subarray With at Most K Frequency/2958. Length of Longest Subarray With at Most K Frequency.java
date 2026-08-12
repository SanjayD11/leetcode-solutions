1class Solution {
2    public int maxSubarrayLength(int[] nums, int k) {
3    int n = nums.length;
4    HashMap<Integer, Integer> map = new HashMap<>();
5    int left = 0;
6    int ans = Integer.MIN_VALUE;
7    for(int right = 0; right < n; right++){
8        map.put(nums[right], map.getOrDefault(nums[right], 0)+1);
9        while(map.get(nums[right]) > k){
10            map.put(nums[left], map.get(nums[left])-1);
11            left++;
12        }
13        ans = Math.max(ans, right - left + 1);
14    }
15    return ans;
16    }
17}