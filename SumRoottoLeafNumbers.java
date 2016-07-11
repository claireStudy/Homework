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
    int sum;
    public Solution() {
        sum = 0;
    }
    public int sumNumbers(TreeNode root) {
        if (root != null) {
            helper(root, 0);
        }
        return sum;
    }
    
    private void helper(TreeNode root, int number) {
        if (root.left == null && root.right == null) {
            System.out.println(root.val);
            number = number * 10 + root.val;
            sum += number;
            System.out.println(sum);
            return;
        }
        if (root.left != null) {
            int digit = root.val;
            int newNumber = number * 10 + digit;
            helper(root.left, newNumber);
        } 
        if (root.right != null) {
            int digit = root.val;
            number = number * 10 + digit;
            helper(root.right, number);
        }
    }
}