package Tree;

public class InsertIntoBinarySearchTree {
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
            public TreeNode insertIntoBST(TreeNode root, int val) {
                return insertIntoBst_(root, val);
            }

            public TreeNode insertIntoBst_(TreeNode root, int val) {
                if (root == null) {
                    return new TreeNode(val);
                }

                if (root.val < val) {
                    root.right = insertIntoBst_(root.right, val);
                } else {
                    root.left = insertIntoBst_(root.left, val);
                }
                return root;
            }

        }
    }
}