/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null)return new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        Deque<TreeNode> dq=new ArrayDeque<>();
        dq.addFirst(root);
        boolean left=true;
        while(!dq.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            int n=dq.size();
            for(int i=0;i<n;i++){
                if(left){
                    TreeNode node=dq.pollFirst();
                    temp.add(node.val);
                    if(node.left!=null){
                        dq.addLast(node.left);
                    }
                    if(node.right!=null){
                        dq.addLast(node.right);
                    }
                }else{
                    TreeNode node=dq.pollLast();
                    temp.add(node.val);
                    if(node.right!=null){
                        dq.addFirst(node.right);
                    }
                    if(node.left!=null){
                        dq.addFirst(node.left);
                    }
                }
            }
            left=!left;
            res.add(temp);
        }
        return res;
    }
}