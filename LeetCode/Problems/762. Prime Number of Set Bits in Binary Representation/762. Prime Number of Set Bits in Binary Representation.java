1class Solution {
2    public int countPrimeSetBits(int left, int right) {
3    int ans = 0;
4    for(int i = left; i <= right; i++){
5        int bits = count(i);
6        if(isPrime(bits)){
7            ans++;
8        }
9    }
10    return ans;    
11    }
12    private int count(int num){
13        int count = 0;
14        while(num > 0){
15            count += (num & 1);
16            num >>= 1;
17        }
18        return count;
19    }
20    private boolean isPrime(int bits){
21        if(bits < 2){
22            return false;
23        }
24        for(int i = 2; i*i <= bits; i++){
25            if(bits%i == 0){
26                return false;
27            }
28        }
29        return true;
30    }
31}