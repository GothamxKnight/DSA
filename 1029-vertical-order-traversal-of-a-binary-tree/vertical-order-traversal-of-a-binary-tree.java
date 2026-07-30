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
    public class node{
        TreeNode root;
        int level;
        node(TreeNode root,int level){
            this.root=root;
            this.level=level;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        TreeMap<Integer,List<Integer>> map=new TreeMap<>();
        Queue<node> qe=new ArrayDeque<>();
        qe.add(new node(root,0));
        while(!qe.isEmpty()){
            int n=qe.size();
            TreeMap<Integer,List<Integer>> temp_map=new TreeMap<>();
            for(int i=0;i<n;i++){
                node temp=qe.poll();
                temp_map.putIfAbsent(temp.level,new ArrayList<>());
                temp_map.get(temp.level).add(temp.root.val);
                if(temp.root.left!=null){
                    qe.add(new node(temp.root.left,temp.level-1));
                }
                if(temp.root.right!=null){
                    qe.add(new node(temp.root.right,temp.level+1));
                }
            }
            for(Map.Entry<Integer,List<Integer>> mp:temp_map.entrySet()){
                map.putIfAbsent(mp.getKey(),new ArrayList<>());
                List<Integer> temp=new ArrayList<>(mp.getValue());
                Collections.sort(temp);
                for(Integer a:temp){
                    map.get(mp.getKey()).add(a);
                }
            }
        }
        res=new ArrayList<>(map.values());
        return res;
    }
}