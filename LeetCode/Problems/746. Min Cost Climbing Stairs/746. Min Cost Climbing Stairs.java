1class Solution {
2    public int minCostClimbingStairs(int[] cost) {
3        int minCost[] = new int[cost.length+1];
4        for(int i = 2; i < cost.length+1; i++){
5            minCost[i] = Math.min(cost[i-1]+minCost[i-1], cost[i-2]+minCost[i-2]);
6        }
7        return minCost[cost.length];
8    }
9}
10
11// Step i ku vara, (i-1) illa (i-2) lendhu dhaan vara mudiyum,
12// rendu vazhila edhu minimum cost oh, adha minCost[i] la save panrom.