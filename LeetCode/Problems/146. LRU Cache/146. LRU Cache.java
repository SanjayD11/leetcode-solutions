1class LRUCache {
2    class Node {
3        int key, value;
4        Node prev, next;
5        Node(int key, int value){
6            this.key = key;
7            this.value = value;
8        }
9    }
10    HashMap<Integer, Node> map;
11    Node head, tail;
12    int capacity;
13    public LRUCache(int capacity) {
14         this.capacity = capacity;
15         map = new HashMap<>();
16         head = new Node(0, 0);
17         tail = new Node(0, 0);
18         head.next = tail;
19         tail.prev = head;
20    }
21    public int get(int key) {
22     if(!map.containsKey(key)){
23        return -1;
24     }   
25     Node node = map.get(key);
26     remove(node);
27     insert(node);
28     return node.value;
29    }
30
31    public void remove(Node node){
32    node.prev.next = node.next;
33    node.next.prev = node.prev; 
34    }
35
36    public void insert(Node node){
37        node.next = head.next;
38        node.prev = head;
39        head.next.prev = node;
40        head.next = node;
41    }
42    
43    public void put(int key, int value) {
44       if(map.containsKey(key)){
45        Node node = map.get(key);
46        node.value = value;
47        remove(node);
48        insert(node);
49       } 
50       else{
51        if(map.size() == capacity){
52            Node lru = tail.prev;
53            remove(lru);
54            map.remove(lru.key);
55        }
56        Node newNode = new Node(key, value);
57        insert(newNode);
58        map.put(key, newNode);
59        }
60    }
61}
62
63/**
64 * Your LRUCache object will be instantiated and called as such:
65 * LRUCache obj = new LRUCache(capacity);
66 * int param_1 = obj.get(key);
67 * obj.put(key,value);
68 */