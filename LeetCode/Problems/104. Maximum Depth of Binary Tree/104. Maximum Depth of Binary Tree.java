1/**
2* Definition for a binary tree node.
3* public class TreeNode {
4*     int val;
5*     TreeNode left;
6*     TreeNode right;
7*     TreeNode() {}
8*     TreeNode(int val) { this.val = val; }
9*     TreeNode(int val, TreeNode left, TreeNode right) {
10*         this.val = val;
11*         this.left = left;
12*         this.right = right;
13*     }
14* }
15*/
16
17// DFS solution Ask the left and right subtrees for their depths and return the larger one plus one(current node) :
18class Solution {
19public int maxDepth(TreeNode root) {
20    if (root == null) {
21        return 0;
22    }
23    if (root.left == null && root.right == null) {
24        return 1;
25    }
26    if (root.left == null) {
27        return maxDepth(root.right) + 1;
28    }
29    if (root.right == null) {
30        return maxDepth(root.left) + 1;
31    }
32    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
33}
34}
35// class Solution {
36//     public int maxDepth(TreeNode root) {
37//        if(root == null){
38//         return 0;
39//        }
40//        int leftDepth = maxDepth(root.left);
41//        int rightDepth = maxDepth(root.right);
42
43//        return Math.max(leftDepth, rightDepth)+1;
44
45// }
46// }
47// BFS approach: Count how many levels exist in the tree using a queue :
48// class Solution {
49//     public int maxDepth(TreeNode root) {
50//         if (root == null)
51//             return 0;
52//         Queue<TreeNode> queue = new LinkedList<>();
53//         queue.offer(root);
54//         int depth = 0;
55//         while (!queue.isEmpty()) {
56//             int size = queue.size();
57//             // Process one complete level
58//             for (int i = 0; i < size; i++) {
59//                 TreeNode current = queue.poll();
60//                 if (current.left != null)
61//                     queue.offer(current.left);
62//                 if (current.right != null)
63//                     queue.offer(current.right);
64//             }
65//             depth++;
66//         }
67//         return depth;
68//     }
69// }