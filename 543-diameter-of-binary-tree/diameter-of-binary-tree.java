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
    public int diameterOfBinaryTree(TreeNode root) {
        int max[]={0};
        int temp=maxdepth(root,max);
        return max[0];
    }
    static int maxdepth(TreeNode root,int[]max){
        if(root==null)return 0;
        int left=0,right=0;
        if(root.left!=null)left=maxdepth(root.left,max)+1;
        if(root.right!=null)right=maxdepth(root.right,max)+1;
        max[0]=Math.max(max[0],left+right);
        return Math.max(left,right);
    }
}