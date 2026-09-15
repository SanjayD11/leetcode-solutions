1class Solution {
2    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
3    Arrays.sort(products);
4    List<List<String>> ans = new ArrayList<>();
5    String prefix = ;
6    for(char c : searchWord.toCharArray()){
7        prefix += c;
8        int start = lowerBound(products, prefix);
9        List<String> list = new ArrayList<>();
10        for(int i = start; i < Math.min(start+3, products.length); i++){
11            if(products[i].startsWith(prefix)){
12                list.add(products[i]);
13            }
14            else{
15                break;
16            }
17        }
18        ans.add(list);
19    }
20    return ans;
21    }
22    private int lowerBound(String[] products, String prefix){
23        int low = 0;
24        int high = products.length-1;
25        int ans = 0;
26        while(low <= high){
27            int mid = low + (high-low)/2;
28            if(products[mid].compareTo(prefix) >= 0){
29                ans = mid;
30                high = mid-1;
31            }    
32            else{
33                low = mid+1;
34            }
35        }
36        return ans;
37    }
38}