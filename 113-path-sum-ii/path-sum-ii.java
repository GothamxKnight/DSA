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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null)return new ArrayList<>();
        int sum=root.val;
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        curr.add(root.val);
        sumpath(root,targetSum,sum,curr,res);
        return res;
    }
    static void sumpath(TreeNode root,int target,int sum,List<Integer> curr,List<List<Integer>> res){
        if(root.left==null && root.right==null){
            if(sum==target){
                res.add(new ArrayList<>(curr));
            }
            return ;
        }
        if(root.left!=null){
            curr.add(root.left.val);
            sumpath(root.left,target,sum+root.left.val,curr,res);
            curr.remove(curr.size()-1);
        }
        if(root.right!=null){
            curr.add(root.right.val);
            sumpath(root.right,target,sum+root.right.val,curr,res);
            curr.remove(curr.size()-1);
        }
    }
}