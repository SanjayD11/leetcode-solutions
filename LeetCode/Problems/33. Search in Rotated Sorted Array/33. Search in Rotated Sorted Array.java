1class Solution {
2    public int search(int[] nums, int target) {
3        if(nums.length == 0)
4            return -1;
5        if(nums.length == 1 && nums[0] == target){
6            return 0;
7        }
8        int low = 0;
9        int high = nums.length-1;
10        while(low <= high){
11            int mid = low + (high - low)/2;
12            if(nums[mid] == target)
13                return mid;
14            if(nums[low] <= nums[mid]){// endha half of the rotated array is sorted nu check pannu, this is for left sorted checking
15                if(nums[low] <= target && target <= nums[mid])
16                    high = mid - 1;
17                else
18                    low = mid + 1;
19            }
20            else {
21                if(nums[mid] <=target && target <= nums[high])
22                    low = mid + 1;
23                else
24                    high = mid - 1;
25            }
26        }
27        return -1;
28    }
29    }
30