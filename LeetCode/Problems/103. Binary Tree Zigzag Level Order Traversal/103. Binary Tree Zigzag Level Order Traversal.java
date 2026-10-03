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
17    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
18    List<List<Integer>> ans = new ArrayList<>();
19    if(root == null){
20        return ans;
21    }    
22    Queue<TreeNode> q = new LinkedList<>();
23    q.offer(root);
24    boolean leftToRight = true;
25    while(!q.isEmpty()){
26        int size = q.size();
27        List<Integer> zzlevel = new ArrayList<>();
28        for(int i = 0; i < size; i++){
29            TreeNode node = q.poll();
30            if(leftToRight){
31                zzlevel.addLast(node.val);
32            }
33            else{
34                zzlevel.addFirst(node.val);
35            }
36            if(node.left != null){
37                q.offer(node.left);
38            }
39            if(node.right != null){
40                q.offer(node.right);
41            }
42        }
43        leftToRight = !leftToRight;
44        ans.add(zzlevel);
45    }
46    return ans;
47    }
48}