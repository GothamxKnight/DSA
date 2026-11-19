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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        String[] sourcePath = { "" };
        dfs(root, startValue, new StringBuilder(), sourcePath);
        String s = sourcePath[0];
        String[] destPath = { "" };
        dfs(root, destValue, new StringBuilder(), destPath);
        String t = destPath[0];
        int i = 0;
        while (i < s.length() && i < t.length()) {
            if (s.charAt(i) != t.charAt(i))
                break;
            i++;
        }
        StringBuilder res = new StringBuilder();
        for (int j = 0; j < s.length()-i; j++) {
            res.append('U');
        }
        while (i < t.length()) {
            res.append(t.charAt(i++));
        }
        return res.toString();
    }

    public boolean dfs(TreeNode node, int targetValue, StringBuilder path, String[] res) {
        if (node == null)
            return false;
        if (node.val == targetValue) {
            res[0] = path.toString();
            return true;
        }
        path.append('L');
        if (dfs(node.left, targetValue, path, res))
            return true;
        path.deleteCharAt(path.length() - 1);
        path.append('R');
        if (dfs(node.right, targetValue, path, res))
            return true;
        path.deleteCharAt(path.length() - 1);
        return false;
    }
}