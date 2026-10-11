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
17    int count = 0;
18    int ans = 0;
19    public int kthSmallest(TreeNode root, int k) {
20    dfs(root, k);
21    return ans;
22    }
23    private void dfs(TreeNode node, int k){
24        if(node == null){
25            return;
26        }
27        dfs(node.left, k);
28        count++;
29        if(count == k){
30            ans = node.val;
31            return;
32        }
33        dfs(node.right, k);
34    }
35}