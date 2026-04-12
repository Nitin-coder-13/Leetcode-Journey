package Tree;

public class DiameterofBinaryTree {
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

        class Solution {
            public int diameterOfBinaryTree(TreeNode root) {
                if (root == null) {
                    return 0;
                }
                int left_diameter = diameterOfBinaryTree(root.left);
                int right_diameter = diameterOfBinaryTree(root.right);
                int self_diameter = ht(root.left) + ht(root.right) + 2;
                return Math.max(Math.max(left_diameter, right_diameter), self_diameter);
            }

            public int ht(TreeNode root) {
                if (root == null) {
                    return -1;
                }
                int left = ht(root.left);
                int right = ht(root.right);
                return Math.max(left, right) + 1;
            }
        }
    }
}
