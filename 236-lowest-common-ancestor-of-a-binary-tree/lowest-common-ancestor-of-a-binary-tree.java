/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode>path1=new ArrayList<>();
        List<TreeNode>path2=new ArrayList<>();
        boolean a=findpath(root,p,path1);
        boolean b=findpath(root,q,path2);
        for(int i=path1.size()-1;i>=0;i--){
            TreeNode anc=path1.get(i);
            for(int j=path2.size()-1;j>=0;j--){
                if(anc==path2.get(j))return anc;
            }
        }
        return null;
    }
    static boolean findpath(TreeNode root,TreeNode target,List<TreeNode> path){
        if(root==null)return false;
        path.add(root);
        if(target==root)return true;
        if(findpath(root.left,target,path)||findpath(root.right,target,path))return true;
        path.remove(path.size()-1);
        return false;
    }
}