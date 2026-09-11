1class Solution {
2    public boolean searchMatrix(int[][] matrix, int target) {
3        int m = matrix.length;
4        int n = matrix[0].length;
5        int low = 0;
6        int high = (m * n) - 1;
7        while (low <= high){
8            int mid = low + (high - low)/2;
9            int curr =  matrix[mid / n][mid % n];
10            if(curr == target)  return true;
11            else if(curr < target)  low = mid + 1;
12            else    high = mid - 1;  
13        }
14        return false;
15    }
16}