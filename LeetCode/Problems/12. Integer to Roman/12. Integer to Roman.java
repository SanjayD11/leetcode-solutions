1import java.util.*;
2
3class Solution {
4    public String intToRoman(int num) {
5
6 HashMap<Integer, String> map = new HashMap<>();
7        map.put(1000, M);
8        map.put(900, CM);
9        map.put(500, D);
10        map.put(400, CD);
11        map.put(100, C);
12        map.put(90, XC);
13        map.put(50, L);
14        map.put(40, XL);
15        map.put(10, X);
16        map.put(9, IX);
17        map.put(5, V);
18        map.put(4, IV);
19        map.put(1, I);
20
21        int[] values = {
22            1000, 900, 500, 400,
23            100, 90, 50, 40,
24            10, 9, 5, 4, 1
25        };
26
27        StringBuilder result = new StringBuilder();
28for (int i = 0 ; i < values.length;i++){
29    while(num>=values[i]){
30        result.append(map.get(values[i]));
31        num-=values[i];
32    }
33}
34        return result.toString();
35    }
36}
37