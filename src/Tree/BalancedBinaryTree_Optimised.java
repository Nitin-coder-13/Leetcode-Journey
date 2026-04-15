package Tree;

public class BalancedBinaryTree_Optimised {
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
            public boolean isBalanced(TreeNode root) {
                return balanced(root).isBalanced;
            }

            public BalancePair balanced(TreeNode root) {
                if (root == null) {
                    return new BalancePair();
                }
                BalancePair lbp = balanced(root.left);
                BalancePair rbp = balanced(root.right);
                BalancePair sbp = new BalancePair();
                sbp.height = Math.max(lbp.height, rbp.height) + 1;
                boolean sb = Math.abs(lbp.height - rbp.height) <= 1;
                sbp.isBalanced = lbp.isBalanced && rbp.isBalanced && sb;
                return sbp;

            }

            class BalancePair {
                boolean isBalanced = true;
                int height = -1;
            }
        }
    }
}
