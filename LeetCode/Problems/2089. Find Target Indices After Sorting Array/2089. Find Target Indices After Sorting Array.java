1class Solution {
2    public List<Integer> targetIndices(int[] nums, int target) {
3    Arrays.sort(nums);
4    List<Integer> res = new ArrayList<>();
5    int low = 0;
6    int high = nums.length-1;
7    while(low <= high){
8        int mid = low + (high-low)/2;
9        if(nums[mid] < target){
10            low = mid+1;
11        }
12        else{
13            high = mid-1;
14        }
15    }
16    int first = low;
17    while(first < nums.length && nums[first] == target){
18        res.add(first);
19        first++;
20    }
21    return res;    
22    }
23}
24