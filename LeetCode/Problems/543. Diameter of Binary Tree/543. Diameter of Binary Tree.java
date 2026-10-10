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
17class Solution {
18    int dia = 0;
19    public int diameterOfBinaryTree(TreeNode root) {
20    dfs(root);
21    return dia;    
22    }
23    private int dfs(TreeNode node){
24        if(node == null){
25            return 0;
26        }
27        int leftHeight = dfs(node.left);
28        int rightHeight = dfs(node.right);
29        dia = Math.max(dia, leftHeight + rightHeight);
30        return Math.max(leftHeight, rightHeight)+1;
31    }
32}