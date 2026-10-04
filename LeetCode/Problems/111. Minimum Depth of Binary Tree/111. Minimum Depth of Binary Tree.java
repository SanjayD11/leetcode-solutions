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
18//     public int minDepth(TreeNode root) {
19//         if(root == null){
20//             return 0;
21//         }
22//         if(root.left == null && root.right == null){
23//             return 1;
24//         }
25//         if(root.left == null){
26//             return minDepth(root.right)+1;
27//         }
28//         if(root.right == null){
29//             return minDepth(root.left)+1;
30//         }
31//         return Math.min(minDepth(root.left), minDepth(root.right))+1;
32//     }
33// }
34
35// BFS Approach :
36class Solution {
37    public int minDepth(TreeNode root) {
38    if(root == null){
39      return 0;  
40    }
41    Queue<TreeNode> q = new LinkedList<>();
42    q.offer(root);
43    int depth = 1;
44    while(!q.isEmpty()){
45        int size = q.size();
46        for(int i = 0; i < size; i++){
47            TreeNode node = q.poll();
48            if(node.left == null && node.right == null){
49                return depth;
50            }
51            if(node.left != null){
52                q.offer(node.left);
53            }
54            if(node.right != null){
55                q.offer(node.right);
56            }
57        }
58        depth++;
59    }
60    return depth;
61    }
62}