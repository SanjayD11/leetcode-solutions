1class Solution {
2    public int minSpeedOnTime(int[] dist, double hour) {
3    int low = 1;
4    int high = 10000000;
5    int ans = -1;
6    while(low <= high){
7        int mid = low+(high-low)/2;
8        if(canArrive(dist, hour, mid)){
9            ans = mid;
10            high = mid-1;
11        }
12        else{
13            low = mid+1;
14        }
15    }    
16    return ans;
17    }
18    private boolean canArrive(int[] dist, double hour, int speed){
19        double totalTime = 0.0;
20        for(int i = 0; i < dist.length-1; i++){
21            totalTime += Math.ceil((double)dist[i]/speed);// convert to double before int div, so that it round offs to next int (adds waiting time automatically)
22        }
23
24        //ceil div can also done as  (dist[i]+speed-1)/speed as well
25        totalTime += (double)dist[dist.length-1]/speed;
26        return totalTime <= hour;
27    }
28    }
29
30
31    // Binary Search speed mela panrom to find minimum valid speed.
32// Mid speed ku total travel time (waiting included) calculate panrom.
33// Time <= hour na smaller speed try panrom, illa na speed increase panrom.