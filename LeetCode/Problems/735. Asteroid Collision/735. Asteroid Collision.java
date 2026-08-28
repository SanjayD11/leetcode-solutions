1class Solution {
2    public int[] asteroidCollision(int[] asteroids) {
3        Stack <Integer> safeStack = new Stack<>(); 
4        for(int asteroid : asteroids){
5        boolean alive = true;
6        while(alive && asteroid < 0 && safeStack.size() > 0 && safeStack.peek() > 0){
7            if( Math.abs(asteroid) > safeStack.peek()){
8                safeStack.pop();
9            }
10            else if(Math.abs(asteroid) == safeStack.peek()){
11                safeStack.pop();
12                alive = false;
13            }
14            else{
15                alive = false;
16            }
17        }
18        if(alive){
19            safeStack.push(asteroid);
20        }
21        }
22        return safeStack.stream().mapToInt(i -> i).toArray();
23    //     int[] result = new int[safeStack.size()];
24    // for (int i = 0; i < result.length; i++) {
25    //     result[i] = safeStack.get(i);
26    // }
27    // return result;
28    }
29    }
30