1class Solution {
2    public int sumCounts(List<Integer> nums) {
3    int n = nums.size();
4    int ans = 0;
5    for(int i = 0; i < n; i++){
6        HashSet<Integer> set = new HashSet<>();
7        for(int j = i; j < n; j++){
8            set.add(nums.get(j));
9            int distinct = set.size();
10            ans += distinct*distinct;
11        }
12    }    
13    return ans;
14    }
15}