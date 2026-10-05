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
16class Solution {
17    public boolean isValidBST(TreeNode root) {
18    return check(root, Long.MIN_VALUE, Long.MAX_VALUE);    
19    }
20    private boolean check(TreeNode node, long min, long max){
21        if(node == null){
22            return true;
23        }
24        if(node.val <= min || node.val >= max){
25            return false;
26        }
27        return check(node.left, min, node.val) && check(node.right, node.val, max);
28    }
29}