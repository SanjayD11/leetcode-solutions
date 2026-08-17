1class Solution {
2    public String mostCommonWord(String paragraph, String[] banned) {
3    paragraph = paragraph.toLowerCase().replaceAll([^a-z],  );
4    HashSet<String> set = new HashSet<>();
5    for(String ban : banned){
6        set.add(ban);
7    }    
8    HashMap<String, Integer> map = new HashMap<>();
9    String words[] = paragraph.split( );
10    for(String word : words){
11        if(word.length() == 0){
12            continue;
13        }
14        if(!set.contains(word)){
15            map.put(word, map.getOrDefault(word, 0)+1);
16        }
17    }
18    int maxCount = 0;
19    String res = ;
20    for(String word : map.keySet()){
21        if(map.get(word) > maxCount){
22            maxCount = map.get(word);
23            res = word;
24        }
25    }
26    return res;
27    }
28}