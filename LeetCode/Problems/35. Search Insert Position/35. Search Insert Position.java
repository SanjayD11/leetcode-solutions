1class Solution {
2    public int searchInsert(int[] nums, int target) {
3        int i;  
4      for(i = 0;i<nums.length;i++){
5        if(nums[i] >= target){
6            return i;
7        }
8      }
9      return nums.length;
10    }  
11    
12}
13
14// Binary Search Approach :
15// class Solution {
16//     public int searchInsert(int[] nums, int target) {
17//         int left = 0;
18//         int right = nums.length - 1;
19//         while (left <= right) {
20//             int mid = left + (right - left)/2;
21//             if (nums[mid] == target) {
22//                 return mid;
23//             } else if (nums[mid] < target) {
24//                 left = mid + 1;
25//             } else {
26//                 right = mid - 1;
27//             }
28//         }
29//         return left;
30//     }
31// }