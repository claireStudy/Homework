/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left != 0 && right != 0) {
            return Math.min(left, right) + 1;
        } else if (left != 0 && right == 0) {
            return left + 1;
        } else if (left == 0 && right != 0) {
            return right + 1;
        } 
        return 1; // if left == 0 && right == 0, then return 1 (root).
    }
}