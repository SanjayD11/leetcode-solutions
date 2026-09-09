1class Solution {
2    public int mySqrt(int x) {
3        long low = 0;
4        long high = x;
5        long ans = 0;
6        while (low <= high) {
7            long mid = low + (high - low) / 2;
8            if ( mid * mid == x) {
9                return (int)mid;
10            }
11            
12            if ( mid * mid < x) {
13                ans = mid;
14                low = mid + 1;
15            }
16            else {
17                high = mid - 1;
18            }
19        }
20        return (int)ans;
21    }
22}