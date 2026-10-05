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
16 // DFS Approach :
17// class Solution {
18//     public boolean isBalanced(TreeNode root) {
19//     if(root == null){
20//         return true;
21//     }
22//     int leftDepth = findDepth(root.left);
23//     int rightDepth = findDepth(root.right);
24//     if(Math.abs(leftDepth - rightDepth) > 1){
25//         return false;
26//     }
27//     return isBalanced(root.left) && isBalanced(root.right);
28//     }
29//     private int findDepth(TreeNode node){
30//         if(node == null){
31//             return 0;
32//         }
33//         return Math.max(findDepth(node.left), findDepth(node.right))+1;
34//     }
35// }
36// BFS Approach :
37class Solution {
38    public boolean isBalanced(TreeNode root) {
39    if(root == null){
40      return true;  
41    }
42    Queue<TreeNode> q = new LinkedList<>();
43    q.offer(root);
44    while(!q.isEmpty()){
45        int size = q.size();
46        for(int i = 0; i < size; i++){
47            TreeNode node = q.poll();
48            int leftDepth = findDepth(node.left);
49            int rightDepth = findDepth(node.right);
50            if(Math.abs(leftDepth - rightDepth) > 1){
51                return false;
52            }
53            if(node.left != null){
54                q.offer(node.left);
55            }
56            if(node.right != null){
57                q.offer(node.right);
58            }
59        }
60    }
61    return true;
62    }
63    private int findDepth(TreeNode node){
64    if(node == null){
65            return 0;
66    }
67    return Math.max(findDepth(node.left), findDepth(node.right))+1;
68    }
69}