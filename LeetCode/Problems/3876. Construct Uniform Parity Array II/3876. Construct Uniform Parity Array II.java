1class Solution {
2    public boolean uniformArray(int[] nums1) {
3    boolean hasOdd = false;
4    int smallestOdd = Integer.MAX_VALUE;
5    for(int num : nums1){
6        if(num%2!=0){
7            hasOdd = true;
8            smallestOdd = Math.min(smallestOdd, num);
9        }
10    }
11    if(!hasOdd){
12        return true;
13    }
14    for(int num : nums1){
15        if(num%2==0 && num <= smallestOdd){
16            return false;
17        }
18    }
19    return true;
20    }
21}