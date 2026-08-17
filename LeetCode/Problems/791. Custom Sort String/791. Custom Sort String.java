1class Solution {
2    public String customSortString(String order, String s) {
3    StringBuilder sb = new StringBuilder();
4    HashMap<Character, Integer> map = new HashMap<>();
5    int pos = 0;
6    for(char c : s.toCharArray()){
7        map.put(c, map.getOrDefault(c, 0)+1);
8    }
9    for(char c : order.toCharArray()){
10        if(map.containsKey(c)){
11            while(map.get(c) > 0){
12                sb.append(c);
13                map.put(c, map.get(c)-1);
14            }
15        }
16    }
17    for(char c : map.keySet()){
18        while(map.get(c) > 0){
19            sb.append(c);
20            map.put(c, map.get(c)-1);       
21        }
22    }
23    return sb.toString();
24    }
25}