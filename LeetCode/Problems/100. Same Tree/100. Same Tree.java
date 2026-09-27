1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16
17 // DFS Approach :
18// class Solution {
19//     public boolean isSameTree(TreeNode p, TreeNode q) {
20//         if(p == null && q == null){
21//             return true;
22//         }
23//         if(p == null || q == null){
24//             return false;
25//         }
26//         if(p.val != q.val){
27//             return false;
28//         }
29//         return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
30//     }
31// }
32
33// BFS Approach :
34class Solution {
35    public boolean isSameTree(TreeNode p, TreeNode q) {
36        Queue<TreeNode> queue = new LinkedList<>();
37        queue.offer(p);
38        queue.offer(q);
39        while(!queue.isEmpty()){
40            TreeNode first = queue.poll();
41            TreeNode second = queue.poll();
42            if(first == null && second == null){
43                continue;
44            }
45            if(first == null || second == null){
46                return false;
47            }
48            if(first.val != second.val){
49                return false;
50            }
51            queue.offer(first.left);
52            queue.offer(second.left);
53            queue.offer(first.right);
54            queue.offer(second.right);
55        }
56        return true;
57    }
58}