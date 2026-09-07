1// Stack Approach :
2class Solution {
3    public int[] dailyTemperatures(int[] temperatures) {
4    int n = temperatures.length;
5    int ans[] = new int[n];
6    Stack<Integer> st = new Stack<>();
7    for(int i = 0; i < n; i++){
8        while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
9            int prevIndex = st.pop();
10            ans[prevIndex] = i - prevIndex;
11        }
12        st.push(i);
13    }
14    return ans;
15    }
16}
17
18// BruteForce Solution (TLE) :
19// class Solution {
20//     public int[] dailyTemperatures(int[] temperatures) {
21//     int n = temperatures.length;
22//     int ans[] = new int[n];
23//     for(int i = 0; i < n-1; i++){
24//         int count = 0;
25//         for(int j = i+1; j < n; j++){
26//             count++;
27//             if(temperatures[j] > temperatures[i]){
28//                 ans[i] = count;
29//                 break;
30//             }
31//         }
32//     }    
33//     return ans;
34//     }
35// }