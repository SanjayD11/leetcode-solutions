1// Using Bit Manipulation :
2class Solution {
3    public boolean isPowerOfTwo(int n) {
4    return n>0 && (n&(n-1)) == 0;
5    }
6}
7
8// // Using Loop:
9// class Solution {
10//     public boolean isPowerOfTwo(int n) {
11//         if (n <= 0) {
12//             return false;
13//         }
14//         while (n % 2 == 0) {
15//             n /= 2;
16//         }
17//         return n == 1;
18//     }
19// }
20
21// // Using recursion:
22// class Solution {
23//     public boolean isPowerOfTwo(int n) {
24//         if (n <= 0) {
25//             return false;
26//         }
27//         if (n == 1) {
28//             return true;    
29//         }
30//         if (n % 2 != 0) {
31//             return false;
32//         }
33//         return isPowerOfTwo(n / 2);
34//     }
35// }
36