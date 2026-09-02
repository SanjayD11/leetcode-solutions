1class Solution {
2    public int addDigits(int num) {
3    while(num >= 10){
4        int sum = 0;
5        while(num > 0){
6            sum += num%10;
7            num /= 10;
8        }
9        num = sum;
10    }
11    return num;
12    }
13}