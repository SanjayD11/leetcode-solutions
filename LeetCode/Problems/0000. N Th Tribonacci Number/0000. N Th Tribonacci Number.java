1class Solution {
2    public int tribonacci(int n) {
3    if(n == 0) return 0;
4    if(n == 1|| n==2) return 1; 
5    int dp[] = new int[n+1];
6    dp[0] = 0;
7    dp[1] = 1;
8    dp[2] = 1;
9    for(int i = 3; i <=n; i++){
10        dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
11    }
12    return dp[n];
13    }
14}
15
16// Space optimized:
17// class Solution {
18//     public int tribonacci(int n) {
19//         if (n == 0) return 0;
20//         if (n == 1 || n == 2) return 1;
21        
22//         int t0 = 0, t1 = 1, t2 = 1;
23        
24//         for (int i = 3; i <= n; i++) {
25//             int next = t0 + t1 + t2;
26//             t0 = t1;
27//             t1 = t2;
28//             t2 = next;
29//         }
30        
31//         return t2;
32//     }
33// }
34
35// Memoized version:
36// class Solution {
37//     // Class-level array to persist values across recursive calls
38//     private int[] memo;
39
40//     public int tribonacci(int n) {
41//         if (n == 0) return 0;
42//         if (n == 1 || n == 2) return 1;
43
44//         // Initialize the array exactly once on the very first call
45//         if (memo == null) {
46//             memo = new int[n + 1];
47//         }
48
49//         // If already calculated, return the stored value
50//         if (memo[n] != 0) return memo[n];
51
52//         // Recursive calls directly to the same function
53//         memo[n] = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
54        
55//         return memo[n];
56//     }
57// }