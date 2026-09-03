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
    public List<TreeNode> generateTrees(int n) {
        return build(1,n);
    }
    static List<TreeNode> build(int start,int end){
        List<TreeNode> alltrees=new ArrayList<>();

        if(start>end){
            alltrees.add(null);
            return alltrees;
        }

        for(int i=start;i<=end;i++){
            List<TreeNode> lefttree=build(start,i-1);
            List<TreeNode> righttree=build(i+1,end);
            for(TreeNode left:lefttree){
                for(TreeNode right:righttree){
                    TreeNode root=new TreeNode(i);
                    root.left=left;
                    root.right=right;
                    alltrees.add(root);
                }
            }
        }
        return alltrees;
    }
}