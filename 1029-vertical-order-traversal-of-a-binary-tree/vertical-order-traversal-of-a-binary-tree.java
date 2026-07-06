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
public class node {
    TreeNode root;
    int level;

    node(int level) {
        this.level = level;
    }

    node(TreeNode root, int level) {
        this.root = root;
        this.level = level;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        node Root = new node(root, 0);
        Queue<node> q = new ArrayDeque<>();
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        q.add(Root);
        while (!q.isEmpty()) {
            int size = q.size();
            TreeMap<Integer, List<Integer>> rowmap = new TreeMap<>();
            for (int i = 0; i < size; i++) {
                node temp = q.poll();
                rowmap.putIfAbsent(temp.level, new ArrayList<>());
                rowmap.get(temp.level).add(temp.root.val);
                if (temp.root.left != null) {
                    q.add(new node(temp.root.left, temp.level - 1));
                }
                if (temp.root.right != null) {
                    q.add(new node(temp.root.right, temp.level + 1));
                }
            }
            for (Map.Entry<Integer,List<Integer>> temp : rowmap.entrySet()) {
                Collections.sort(temp.getValue());
                map.putIfAbsent(temp.getKey(),new ArrayList<>());
                for(Integer a:temp.getValue()){
                    map.get(temp.getKey()).add(a);
                }
            }
        }
        List<List<Integer>> list=new ArrayList<>(map.values());
        return list;
    }
}