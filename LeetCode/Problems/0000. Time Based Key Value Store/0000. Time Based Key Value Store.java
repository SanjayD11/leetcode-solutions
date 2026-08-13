1class TimeMap {
2    class Pair{
3        int time;
4        String value;
5    Pair(int time, String value){
6            this.time = time;
7            this.value = value;
8        }
9    }
10    HashMap<String, ArrayList<Pair>> map;
11    public TimeMap() {
12        map = new HashMap<>();
13    }
14    
15    public void set(String key, String value, int timestamp) {
16        if(!map.containsKey(key)){
17            map.put(key, new ArrayList<>());
18        }
19        map.get(key).add(new Pair(timestamp, value));
20    }
21     
22    public String get(String key, int timestamp) {
23        if(!map.containsKey(key)){
24            return ;
25        }
26        ArrayList<Pair> list = map.get(key);
27        int left = 0;
28        int right = list.size()-1;
29        String ans = ;
30        while(left <= right){
31            int mid = left+(right-left)/2;
32            if(list.get(mid).time <= timestamp){
33                ans = list.get(mid).value;
34                left = mid+1;
35            }
36            else{
37                right = mid-1;
38            }
39        }
40        return ans; 
41    }
42}
43
44/**
45 * Your TimeMap object will be instantiated and called as such:
46 * TimeMap obj = new TimeMap();
47 * obj.set(key,value,timestamp);
48 * String param_2 = obj.get(key,timestamp);
49 */