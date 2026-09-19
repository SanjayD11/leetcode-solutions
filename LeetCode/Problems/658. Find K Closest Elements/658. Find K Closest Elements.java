1// Sliding Window Approach :
2// class Solution {
3//     public List<Integer> findClosestElements(int[] arr, int k, int x) {
4//     int n = arr.length;
5//     int left = 0;
6//     int right = n-1;
7//     while(right-left+1 > k){
8//         if(Math.abs(arr[left]-x) > Math.abs(arr[right]-x)){
9//             left++;
10//         }
11//         else{
12//             right--;
13//         }
14//     }
15//     List<Integer> ans = new ArrayList<>();
16//     for(int i = left; i <= right; i++){
17//         ans.add(arr[i]);
18//     }
19//     return ans;
20//     }
21// }
22
23//Boundary Binary Search on window :
24class Solution {
25    public List<Integer> findClosestElements(int[] arr, int k, int x) {
26    int n = arr.length;
27    int low = 0;
28    int high = n-k;
29    while(low < high){
30        int mid = low + (high-low)/2;
31        if(x-arr[mid] > arr[mid+k]-x){
32            low = mid+1;
33        }
34        else{
35            high = mid;
36        }
37    }
38    List<Integer> ans = new ArrayList<>();
39    for(int i = low; i < low+k; i++){
40        ans.add(arr[i]);
41    }
42    return ans;
43    }
44}