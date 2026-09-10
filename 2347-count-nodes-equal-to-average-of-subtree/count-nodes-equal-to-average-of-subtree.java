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
    public int averageOfSubtree(TreeNode root) {
        if(root==null)return 0;
        int []res={0};
        
        int sum[]=postorder(root,res);
        return res[0];
    }
    static int[] postorder(TreeNode root,int[]res){
        if(root.left==null && root.right==null){
            res[0]++;
            return new int[]{root.val,1};
        }
        int[] left=new int[2];
        int []right=new int[2];
        if(root.left!=null){
            left=postorder(root.left,res);
        }
        if(root.right!=null){
            right=postorder(root.right,res);
        }
        int sum=left[0]+right[0]+root.val;
        int n=left[1]+right[1]+1;
        int avg=sum/n;
        if(avg==root.val){
            res[0]++;
        }
        return new int[]{sum,n};
    }
}