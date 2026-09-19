1class Solution {
2    public int hIndex(int[] citations) {
3    int n = citations.length;
4    int low = 0;
5    int high = n-1;
6    int ans = 0;
7    while(low <= high){
8        int mid = low+(high-low)/2;
9        int papers = n - mid;
10        if(citations[mid] >= papers){
11            ans = papers;
12            high = mid-1;
13        }
14        else{
15            low = mid+1;
16        }
17    }    
18    return ans;
19    }
20}
21
22