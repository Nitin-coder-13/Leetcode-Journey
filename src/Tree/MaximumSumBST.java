package Tree;

public class MaximumSumBST {
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
        public int maxSumBST(TreeNode root) {
            return validBST(root).ans;
        }

        public BSTPair validBST(TreeNode root) {
            if (root == null) {
                return new BSTPair();
            }
            BSTPair lbstp = validBST(root.left);
            BSTPair rbstp = validBST(root.right);
            BSTPair sbstp = new BSTPair();
            sbstp.min = Math.min(root.val, Math.min(lbstp.min, rbstp.min));
            sbstp.max = Math.max(root.val, Math.max(lbstp.max, rbstp.max));
            sbstp.isBST = lbstp.isBST && rbstp.isBST && root.val > lbstp.max && root.val < rbstp.min;
            sbstp.sum = lbstp.sum + rbstp.sum + root.val;
            if (sbstp.isBST) {
                sbstp.ans = Math.max(sbstp.sum, Math.max(lbstp.ans, rbstp.ans));
            } else {
                sbstp.ans = Math.max(lbstp.ans, rbstp.ans);
            }
            return sbstp;
        }
    }

    class BSTPair {
        boolean isBST = true;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        int sum = 0;// sum of whole tree
        int ans = 0; // bst portion

    }
}

