1// Binary Search Approach :
2class Solution {
3    public int hIndex(int[] citations) {
4    int n = citations.length;
5    int low = 0;
6    int high = n;
7    int ans = 0; 
8    while(low <= high){
9        int count = 0;
10        int mid = low + (high-low)/2;
11        for(int citation : citations){
12            if(citation >= mid){
13                count++;
14            }
15        }
16        if(count >= mid){
17            ans = mid;
18            low = mid+1;
19        }
20        else{
21            high = mid-1;
22        }
23    }    
24    return ans;
25    }
26}
27// Binary search on possible H-index (0 to n).
28// If count >= mid, store mid in ans and search for a bigger H-index.
29// Otherwise search for a smaller H-index.
30
31// Sorting Approach :
32// class Solution {
33//     public int hIndex(int[] citations) {
34//         int n = citations.length;
35//         Arrays.sort(citations);
36//         for(int i = 0; i < n; i++){
37//             int papers = n-i;
38//             if(citations[i] >= papers){
39//                 return papers;
40//             }
41//         }
42//         return 0;
43//     }
44// }
45
46// Sort citations in ascending order.
47// papers = n - i gives remaining papers from current index.
48// If citations[i] >= papers, papers is the maximum H-index.