1class Solution {
2    public int calculate(String s) {
3    int n = s.length();
4    Stack<Integer> st = new Stack<>();
5    int num = 0;
6    char sign = '+';
7    for(int i = 0; i < n; i++){
8        char c = s.charAt(i);
9        if(Character.isDigit(c)){
10            num = num*10 + c-'0';
11        }
12        if(!Character.isDigit(c) && c !=' ' || i == n-1){
13            if(sign == '+'){
14                st.push(num);
15            }
16            else if(sign == '-'){
17                st.push(-num);
18            }
19            else if(sign == '*'){
20                st.push(st.pop()*num);
21            }
22            else if(sign == '/'){
23                st.push(st.pop()/num);
24            }
25            sign = c;
26            num = 0;
27        }
28    }  
29    int ans = 0;  
30    while(!st.isEmpty()){
31        ans += st.pop();
32    }
33    return ans;
34    }
35}