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
17    int preIndex = 0;
18    HashMap<Integer, Integer> map = new HashMap<>();
19    public TreeNode buildTree(int[] preorder, int[] inorder) {
20        for(int i = 0; i < inorder.length; i++){
21            map.put(inorder[i], i);
22        }
23        return build(preorder, 0, inorder.length-1);
24    }
25    private TreeNode build(int[] preorder, int left, int right){
26        if(left > right){
27            return null;
28        }
29        int val = preorder[preIndex++];
30        TreeNode root = new TreeNode(val);
31        int mid = map.get(val);
32        root.left = build(preorder, left, mid-1);
33        root.right = build(preorder, mid+1, right);
34        return root;
35    }
36}