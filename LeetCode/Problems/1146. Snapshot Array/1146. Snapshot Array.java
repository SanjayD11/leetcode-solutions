1class SnapshotArray {
2    ArrayList<int[]>[] history;
3    int snapId;
4    public SnapshotArray(int length) {
5        history = new ArrayList[length];
6        for(int i = 0; i < length; i++){
7            history[i] = new ArrayList<>();
8            history[i].add(new int[]{0, 0});
9        }
10        snapId = 0;
11    }
12    
13    public void set(int index, int val) {
14        history[index].add(new int[]{snapId, val});
15    }
16    
17    public int snap() {
18        return snapId++;
19    }
20    
21    public int get(int index, int snap_id) {
22        ArrayList<int[]> list = history[index];
23        int left = 0;
24        int right = list.size()-1;
25        int ans = 0;
26        while(left <= right){
27            int mid = left+(right-left)/2;
28            if(list.get(mid)[0] <= snap_id){
29                ans = list.get(mid)[1];
30                left = mid+1;
31            }
32            else{
33                right = mid-1;
34            }
35        }
36        return ans;
37    }
38}
39
40/**
41 * Your SnapshotArray object will be instantiated and called as such:
42 * SnapshotArray obj = new SnapshotArray(length);
43 * obj.set(index,val);
44 * int param_2 = obj.snap();
45 * int param_3 = obj.get(index,snap_id);
46 */