1class Solution {
2    public boolean checkDivisibility(int n) {
3    int org = n;
4    int sum = 0;
5    int prod = 1;
6    while(n > 0){
7        int dig = n%10;
8        sum += dig;
9        prod *= dig;
10        n/=10;
11    }
12    if(org%(sum + prod) == 0){
13        return true;
14    }
15    return false;
16    }
17}