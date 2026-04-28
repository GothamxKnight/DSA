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
    public int maxPathSum(TreeNode root) {
        int []res=new int[1];
        res[0]=Integer.MIN_VALUE;
        int val=PathSum(root,res);
        return res[0];
    }
    static int PathSum(TreeNode root,int []max){
        if(root==null)return 0;
        int left=PathSum(root.left,max);
        int right=PathSum(root.right,max);
        max[0]=Math.max(max[0],root.val);
        max[0]=Math.max(max[0],root.val+left+right);
        int pathsum=Math.max(left,right)+root.val;
        if(pathsum<0)return 0;
        return pathsum;
    }
}