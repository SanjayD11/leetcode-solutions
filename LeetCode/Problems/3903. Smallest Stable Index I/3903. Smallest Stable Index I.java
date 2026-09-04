1class Solution {
2    public int firstStableIndex(int[] nums, int k) {
3    int n = nums.length;
4    int[] prefixMax = new int[n];
5    int[] suffixMin = new int[n];
6    prefixMax[0] = nums[0];
7    for(int i = 1; i < n; i++){
8        prefixMax[i] = Math.max(prefixMax[i-1], nums[i]);
9    }
10    suffixMin[n-1] = nums[n-1];
11    for(int i = n-2; i >= 0; i--){
12        suffixMin[i] = Math.min(suffixMin[i+1], nums[i]);
13    }
14    int instabilityScore = 0;
15    for(int i = 0; i < n; i++){
16        instabilityScore = prefixMax[i] - suffixMin[i];
17        if(instabilityScore <= k){
18           return i;
19        }
20    }
21    return -1;
22    }
23}