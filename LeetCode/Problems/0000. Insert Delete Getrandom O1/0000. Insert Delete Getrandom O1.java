1 class RandomizedSet {
2    private final HashMap<Integer, Integer> map;
3    private final ArrayList<Integer> list;
4    private Random rand;
5    public RandomizedSet() {
6      map = new HashMap<>();
7      list = new ArrayList<>();
8      rand = new Random();
9    }
10    
11    public boolean insert(int val) {
12        if(map.containsKey(val)){
13            return false;
14        }
15        list.add(val);
16        map.put(val, list.size()-1);
17        return true;
18    }
19    
20    public boolean remove(int val) {
21    if(!map.containsKey(val)){
22        return false;
23    }
24    int remIdx = map.get(val);
25    int lastVal = list.get(list.size()-1);
26    list.set(remIdx, lastVal);
27    map.put(lastVal, remIdx);
28    list.remove(list.size()-1);
29    map.remove(val); 
30    return true;       
31    }
32    
33    public int getRandom() {
34    int idx = rand.nextInt(list.size());
35    return list.get(idx);  
36    }
37}
38
39/**
40 * Your RandomizedSet object will be instantiated and called as such:
41 * RandomizedSet obj = new RandomizedSet();
42 * boolean param_1 = obj.insert(val);
43 * boolean param_2 = obj.remove(val);
44 * int param_3 = obj.getRandom();
45 */