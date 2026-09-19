1class Solution {
2    public int hIndex(int[] citations) {
3    int n = citations.length;
4    int low = 0;
5    int high = n;
6    int ans = 0;
7    while(low <= high){
8        int count = 0;
9        int mid = low+(high-low)/2;
10        for(int citation : citations){
11            if(citation >= mid){
12                count++;
13            }
14        }
15        if(count >= mid){
16            ans = mid;
17            low = mid+1;
18        }
19        else{
20            high = mid-1;
21        }
22    }    
23    return ans;
24    }
25}