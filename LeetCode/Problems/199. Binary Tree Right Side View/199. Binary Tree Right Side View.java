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
17    public List<Integer> rightSideView(TreeNode root) {
18        List<Integer> rightView = new ArrayList<Integer>();
19        if(root == null){
20            return rightView;
21        }
22        Queue<TreeNode> q = new LinkedList<>();
23        q.offer(root);
24        while(!q.isEmpty()){
25            int size = q.size();
26            for(int i = 0; i < size ; i++){
27                TreeNode node = q.poll();
28                if(i == size-1){
29                    rightView.add(node.val);
30                }
31                if(node.left != null){
32                    q.offer(node.left);
33                }
34                if(node.right != null){
35                    q.offer(node.right);
36                }
37            }
38
39        }
40            return rightView;
41}
42}
43// DFS Approach :
44// class Solution {
45//     public List<Integer> rightSideView(TreeNode root) {
46
47//         List<Integer> rightView = new ArrayList<>();
48
49//         dfs(root, 0, rightView);
50
51//         return rightView;
52//     }
53//     private void dfs(TreeNode node, int depth, List<Integer> rightView) {
54//         if (node == null) {
55//             return;
56//         }
57//         if (depth == rightView.size()) {
58//             rightView.add(node.val);
59//         }
60//         dfs(node.right, depth + 1, rightView);
61//         dfs(node.left, depth + 1, rightView);
62//     }
63// }
64/*Right child ah first traverse pannuvom.
65Oru depth ku first varra node ah add pannuvom.
66Idhu dhaan right side view ah give pannum.*/
67