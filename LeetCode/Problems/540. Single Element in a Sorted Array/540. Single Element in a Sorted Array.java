1class Solution {
2    public int singleNonDuplicate(int[] nums) {
3        int low = 0;
4        int high = nums.length - 1;
5        while (low < high) {
6            int mid = low + (high - low) / 2;
7            //Make mid even so that it always points
8            // to the first element of a pair
9            if (mid % 2 == 1) {
10                mid--;
11            }
12            // Pair is correct
13            if (nums[mid] == nums[mid + 1]) {
14                // Single element is on the right
15                low = mid + 2;
16            }
17            // Pair is broken
18            else {
19                // Single element is on the left (including mid)
20                high = mid;
21            }
22        }
23        return nums[low];
24    }
25}
26
27// Using XOR Method:
28// class Solution {
29//     public int singleNonDuplicate(int[] nums) {
30
31//         int xor = 0;
32
33//         for (int num : nums) {
34//             xor ^= num;
35//         }
36
37//         return xor;
38//     }
39// }
40// a ^ a = 0 -> Ore number 2 thadava vandha cancel aagidum.
41// a ^ 0 = a -> 0 XOR panna value change aagadhu.
42// XOR ku order mukkiyam illa (a ^ b = b ^ a).
43// Grouping um mukkiyam illa ((a ^ b) ^ c = a ^ (b ^ c)), so duplicates ah serthu cancel pannalaam.
44// DSA-la duplicate elements remove panna XOR use pannuvom and kadaisila single/unique element mattum remaining irukkum.