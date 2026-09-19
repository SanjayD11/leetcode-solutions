1class Solution {
2    public List<Integer> selfDividingNumbers(int left, int right) {
3    List<Integer> ans = new ArrayList<>();
4    for(int i = left; i <= right; i++){
5        int org = i;
6        if(canDivide(org)){
7            ans.add(org);
8        }
9        else{
10            continue;
11        }
12    }    
13    return ans;
14    }
15private boolean canDivide(int num){
16    int org = num;
17    while(num > 0){
18        int dig = num%10;
19        if(dig == 0 || org%dig != 0){
20            return false;
21        }
22        num/=10;
23        }
24        return true;
25    }
26}