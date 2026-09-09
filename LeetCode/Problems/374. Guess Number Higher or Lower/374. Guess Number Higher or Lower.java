1/** 
2 * Forward declaration of guess API.
3 * @param  num   your guess
4 * @return 	     -1 if num is higher than the picked number
5 *			      1 if num is lower than the picked number
6 *               otherwise return 0
7 * int guess(int num);
8 */
9
10public class Solution extends GuessGame {
11    public int guessNumber(int n) {
12    int low = 1;
13    int high = n;
14    int ans;
15    while(low <= high){
16        int mid = low+(high-low)/2;
17        ans = guess(mid);
18        if(ans == 0){
19            return mid; // since avanga guarenteed that they picked a num from 1 to n, mid always gets returned at some point, so..
20        }
21        else if(ans == -1){
22            high = mid-1;
23        }
24        else{
25            low = mid+1;
26        }
27    }
28    return 0;// this is like a dummy returnn cuz it never executes
29    }
30}