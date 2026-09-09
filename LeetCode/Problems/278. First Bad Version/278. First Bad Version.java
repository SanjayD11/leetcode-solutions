1/* The isBadVersion API is defined in the parent class VersionControl.
2      boolean isBadVersion(int version); */
3
4
5// Boundary Binary Search Approach :
6public class Solution extends VersionControl {
7    public int firstBadVersion(int n) {
8    int left = 1;
9    int right = n;
10    while(left < right){
11        int mid = left + (right-left)/2;
12        if(isBadVersion(mid)){
13            right = mid;
14        }
15        else{
16            left = mid+1;
17        }
18    }    
19    return left;
20    }
21}
22
23//Binary Search is perfect whenever we need to find a boundary.
24// First True. Last False. First Greater. Minimum Valid Answer.