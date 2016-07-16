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
    public void flatten(TreeNode root) {
        helper(root);
    }
    
    public TreeNode helper(TreeNode root) {
        if (root == null) {
            return root;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        // merge the left and right subtree
        root.left = null;
        // if there is only right child, append it to root
        if (left == null) {
            root.right = right;
            return root;
        }
        // Otherwise, insert left subtree between root and right subtree
        root.right = left;
        TreeNode node = left;
        while (node != null && node.right != null) {
            node = node.right;
        }
        node.right = right;
        return root;
    }
}