package Tree;

public class BalancedBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public boolean isBalanced(TreeNode root) {
            return Balanced(root);
        }

        public boolean Balanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            boolean left = Balanced(root.left);
            boolean right = Balanced(root.right);
            boolean self_balanced = Math.abs(height(root.left) - height(root.right)) <= 1;
            return left && right && self_balanced;
        }

        public int height(TreeNode root) {
            if (root == null) {
                return -1;
            }
            int left = height(root.left);
            int right = height(root.right);
            return Math.max(left, right) + 1;
        }
    }
}
