1class Solution {
2    public String toString(int num){
3    StringBuilder bin = new StringBuilder();
4    if(num == 0){
5        return 0;
6    }
7    while(num > 0){
8        bin.append(num%2);
9        num /= 2;
10    }
11    return bin.reverse().toString();       
12    }
13    public String convertDateToBinary(String date) {
14        String[] parts = date.split(-);
15        int year = Integer.parseInt(parts[0]);
16        int month = Integer.parseInt(parts[1]);
17        int day = Integer.parseInt(parts[2]);
18        return toString(year)+-+toString(month)+-+toString(day);
19    }
20
21}