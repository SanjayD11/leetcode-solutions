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
16 // BFS Approach :
17// class Solution {
18//     public TreeNode invertTree(TreeNode root) {
19//     if(root == null){
20//         return null;
21//     }
22//     Queue<TreeNode> q = new LinkedList<>();
23//     q.offer(root);
24//     while(!q.isEmpty()){
25//         int size = q.size();
26//         for(int i = 0; i < size; i++){
27//             TreeNode node = q.poll();
28//             TreeNode temp = node.left;
29//             node.left = node.right;
30//             node.right = temp;
31//             if(node.left != null){
32//                 q.offer(node.left);
33//             }
34//             if(node.right != null){
35//                 q.offer(node.right);
36//             }
37//         }
38//     }
39//     return root;
40//     }
41// }
42// DFS Approach :
43// class Solution {
44//     public TreeNode invertTree(TreeNode root) {
45//         if (root == null) {
46//             return null;
47//         }
48//         TreeNode temp = root.left;
49//         root.left = root.right;
50//         root.right = temp;
51//         invertTree(root.left);
52//         invertTree(root.right);
53//         return root;
54//     }
55// }
56class Solution {
57    public TreeNode invertTree(TreeNode root) {
58    if(root == null){
59        return null;
60    }
61    Deque<TreeNode> stack = new ArrayDeque<>();
62    stack.push(root);
63    while(!stack.isEmpty()){
64        int size = stack.size();
65        for(int i = 0; i < size; i++){
66            TreeNode node = stack.pop();
67            TreeNode temp = node.left;
68            node.left = node.right;
69            node.right = temp;
70            if(node.left != null){
71                stack.push(node.left);
72            }
73            if(node.right != null){
74                stack.push(node.right);
75            }
76        }
77    }
78    return root;
79    }
80}