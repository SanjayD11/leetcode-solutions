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
16// DFS Approach :
17// class Solution {
18//     public boolean isSymmetric(TreeNode root) {
19//     if(root == null){
20//         return true;
21//     }
22//     return mirror(root.left, root.right);
23//     }
24//     private boolean mirror(TreeNode left, TreeNode right){
25//     if(left == null && right == null){
26//         return true;
27//     }
28//     if(left == null || right == null){
29//         return false;
30//     }
31//     if(left.val != right.val){
32//         return false;
33//     }
34//     return mirror(left.left, right.right) && mirror(right.left, left.right);
35//     }
36// }
37
38// BFS Approach :
39class Solution {
40    public boolean isSymmetric(TreeNode root) {
41    if(root == null){
42        return true;
43    }
44    return mirror(root.left, root.right);
45    }
46    private boolean mirror(TreeNode left, TreeNode right){
47    Queue<TreeNode> q = new LinkedList<>();
48    q.offer(left);
49    q.offer(right);
50    while(!q.isEmpty()){
51        TreeNode l = q.poll();
52        TreeNode r = q.poll();
53        if(l == null && r == null){
54            continue;
55        }
56        if(l == null || r == null){
57            return false;
58        }
59        if(l.val != r.val){
60            return false;
61        }
62        q.offer(l.left);
63        q.offer(r.right);
64        q.offer(r.left);
65        q.offer(l.right);
66    }
67    return true;
68    }
69}
70