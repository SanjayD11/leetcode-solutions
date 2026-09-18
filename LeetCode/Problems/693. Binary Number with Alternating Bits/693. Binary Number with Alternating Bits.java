1// Basic Approach :
2// Basic Approach (No binary conversion)
3class Solution {
4    public boolean hasAlternatingBits(int n) {
5        int prev = n % 2;
6        n /= 2;
7        while (n > 0) {
8            int curr = n % 2;
9            if (curr == prev) {
10                return false;
11            }
12            prev = curr;
13            n /= 2;
14        }
15        return true;
16    }
17}
18// Bit Manipulation Appproach :
19// class Solution {
20//     public boolean hasAlternatingBits(int n) {
21//     int x = n ^ (n>>1); // n and n>>1(right shifting bit by 1), xor panna all bits as 1 kudukum
22//     return (x&(x+1))==0;
23//     }
24// }