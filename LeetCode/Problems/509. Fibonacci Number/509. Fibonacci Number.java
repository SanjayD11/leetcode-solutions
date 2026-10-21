1class Solution {
2    public int fib(int n) {
3    if(n == 0){
4        return 0;
5    }
6    int a = 0;
7    int b = 1;
8    int c = a+b;
9    int i = 1;
10    while(i < n){
11        c = a+b;
12        a = b;
13        b = c;
14        i++;
15    }    
16    return c;
17    }
18}