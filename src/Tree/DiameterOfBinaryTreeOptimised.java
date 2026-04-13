package Tree;

public class DiameterOfBinaryTreeOptimised {
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
                return diameter(root).diameter;
            }

            public Diapair diameter(TreeNode root) {
                if (root == null) {
                    return new Diapair();
                }
                Diapair ldp = diameter(root.left);
                Diapair rdp = diameter(root.right);
                Diapair sdp = new Diapair();
                int sd = ldp.height + rdp.height + 2;
                sdp.diameter = Math.max(sd, Math.max(ldp.diameter, rdp.diameter));
                sdp.height = Math.max(ldp.height, rdp.height) + 1;
                return sdp;
            }

            class Diapair {
                int diameter = 0;
                int height = -1;
            }


        }
    }
}
