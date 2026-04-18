package Tree;

public class DeleteNodeInABST {
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
        public TreeNode deleteNode(TreeNode root, int key) {
            return deleteNode_(root, key);
        }

        public TreeNode deleteNode_(TreeNode root, int key) {
            if (root == null) {
                return null;
            }
            if (root.val < key) {
                root.right = deleteNode_(root.right, key);
            } else if (root.val > key) {
                root.left = deleteNode_(root.left, key);
            } else {
                // 0 or 1 child
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                } else { // for 2 child
                    int max = max_(root.left);
                    root.left = deleteNode_(root.left, max);
                    root.val = max;
                }
            }
            return root;
        }

        private int max_(TreeNode nn) {
            if (nn == null) {
                return Integer.MIN_VALUE;
            }
            int right = max_(nn.right);
            return Math.max(nn.val, right);
        }

    }
}
