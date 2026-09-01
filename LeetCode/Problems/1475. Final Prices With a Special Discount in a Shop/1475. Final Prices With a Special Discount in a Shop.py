1class Solution {
2    public int[] finalPrices(int[] prices) {
3    int n = prices.length;
4    int ans[] = new int[n];
5    for(int i = 0; i < n; i++){
6        ans[i] = prices[i];
7        for(int j = i+1; j < n; j++){
8            if(prices[j] <= prices[i]){
9                ans[i] = prices[i]-prices[j];
10                break;
11            }
12        }
13    }   
14    return ans;
15    }
16}
17
18// Stack Approach :
19// class Solution {
20//     public int[] finalPrices(int[] prices) {
21//         int n = prices.length;
22//         int[] ans = prices.clone();
23//         Stack<Integer> st = new Stack<>();
24
25//         for (int i = 0; i < n; i++) {
26
27//             while (!st.isEmpty() && prices[st.peek()] >= prices[i]) {
28//                 int idx = st.pop();
29//                 ans[idx] = prices[idx] - prices[i];
30//             }
31
32//             st.push(i);
33//         }
34
35//         return ans;
36//     }
37// }