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
    public void recoverTree(TreeNode root) {
        List<TreeNode> list=new ArrayList<>();
        inorder(root,list);
        List<Integer>val=new ArrayList<>();
        for(TreeNode temp:list){
            val.add(temp.val);
        }
        Collections.sort(val);
        for(int i=0;i<list.size();i++){
            list.get(i).val=val.get(i);
        }
    }
    static void inorder(TreeNode root,List<TreeNode> list){
        if(root==null)return ;
        inorder(root.left,list);
        list.add(root);
        inorder(root.right,list);
    }
}