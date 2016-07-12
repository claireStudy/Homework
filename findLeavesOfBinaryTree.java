
/* using traversal*/
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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<Integer>();
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        Set<TreeNode> parentList = new HashSet<>();
        List<TreeNode> listNode = new ArrayList<>(); // hold leaf node
        while (dummy.left != null) {
            helper(root, list, listNode, dummy, parentList);
            result.add(list);
            deleteLeaf(root, parentList, listNode);
            list = new ArrayList<>(); 
            listNode = new ArrayList<>();
        }
        return result;
    }
    private void helper(TreeNode root, List<Integer> list, List<TreeNode> listNode, TreeNode parent, Set<TreeNode> parentList) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
            listNode.add(root);
            parentList.add(parent);
            return;
        }
        helper(root.left, list, listNode, root, parentList);
        helper(root.right, list, listNode, root, parentList);
        
        return;
    }
    private void deleteLeaf(TreeNode root, Set<TreeNode> parentList, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        // if parentList only contains dummy node, then remove root.
        if (parentList.size() == 1) {
            for (TreeNode n : parentList) { 
                if (n.left == root) {
                    n.left = null;
                }
            }
        }
        if (parentList.contains(root)) {
            if (root.left != null && list.contains(root.left)) {
                 root.left = null;
            }
            if (root.right != null && list.contains(root.right)) {
                root.right = null;
            }
            parentList.remove(root);
        }
        deleteLeaf(root.left, parentList, list);
        deleteLeaf(root.right, parentList, list);
    }
}