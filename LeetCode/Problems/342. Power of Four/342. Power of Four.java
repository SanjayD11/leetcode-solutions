1class Solution {
2    public boolean isPowerOfFour(int n) {
3        return n > 0 && ((n&(n-1))==0) && n%3 == 1;
4    }
5}
6
7// Using Loop :
8// class Solution {
9//     public boolean isPowerOfFour(int n) {
10//     if(n <= 0){
11//         return false;
12//     }
13//     while(n%4==0){
14//         n/=4;
15//     }
16//     return n==1;
17//     }
18// }
19
20// Using Recursion :
21// class Solution {
22//     public boolean isPowerOfFour(int n) {
23//     if(n <= 0){
24//         return false;
25//     }
26//     if(n==1){
27//         return true;
28//     }
29//     if(n%4!=0){
30//         return false;
31//     }
32//     return isPowerOfTwo(n/4);
33//     }
34// }