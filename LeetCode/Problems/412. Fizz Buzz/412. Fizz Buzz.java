1class Solution {
2    public List<String> fizzBuzz(int n) {
3    List<String> ans = new ArrayList<>();
4    for(int i = 1; i <= n; i++){
5        if(i%3 == 0 && i%5 == 0){
6            ans.add(FizzBuzz);
7        }
8        else if(i%3 == 0){
9            ans.add(Fizz);
10        }
11        else if(i%5 == 0){
12            ans.add(Buzz);
13        }
14        else{
15            ans.add(String.valueOf(i));
16        }
17    }
18    return ans;
19    }
20}