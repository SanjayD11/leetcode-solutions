1class Solution {
2    public int findKthLargest(int[] nums, int k) {
3        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
4        for(int num : nums){
5            minHeap.offer(num);
6            if(minHeap.size() > k){
7                minHeap.poll();
8            }
9        }
10        return minHeap.peek();
11    }
12}