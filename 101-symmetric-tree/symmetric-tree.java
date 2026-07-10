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
class node{
    TreeNode root;
    int level;
    node(TreeNode root,int level){
        this.root=root;
        this.level=level;
    }
}
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root.left==null && root.right==null)return true;
        List<node>list=new ArrayList<>();
        inorder(root,list,0);
        if(ispalindrome(list))return true;
        return false;
    }
    static void inorder(TreeNode root,List<node> list,int level){
        if(root==null)return ;
        inorder(root.left,list,level-1);
        list.add(new node(root,level));
        inorder(root.right,list,level+1);
    }
    static boolean ispalindrome(List<node> list){
        int i=0,j=list.size()-1;
        while(i<j){
            if(list.get(i).root.val!=list.get(j).root.val || list.get(i).level!=-1*list.get(j).level)return false;
            i++;
            j--;
        }
        return true;
    }
}