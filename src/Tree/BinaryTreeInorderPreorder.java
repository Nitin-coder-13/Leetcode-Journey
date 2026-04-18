package Tree;

public class BinaryTreeInroderPreorder {
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return CreateTree(preorder, inorder, 0, inorder.length - 1, 0, preorder.length - 1);
        }

        // ilow,ihigh=inorder ka low and high
        // plow,phigh=preorder ka low and high
        public TreeNode CreateTree(int[] pre, int[] in, int ilow, int ihigh, int plow, int phi) {
            if (ilow > ihigh || plow > phi) {
                return null;
            }
            TreeNode node = new TreeNode(pre[plow]);
            int idx = search(in, ilow, ihigh, pre[plow]);
            // nel=net element
            int nel = idx - ilow; // for creating left subtree and righ subtree
            node.left = CreateTree(pre, in, ilow, idx - 1, plow + 1, plow + nel);
            node.right = CreateTree(pre, in, idx + 1, ihigh, plow + nel + 1, phi);
            return node;


        }

        public int search(int[] in, int si, int ei, int item) {
            for (int i = si; i <= ei; i++) {
                if (in[i] == item) {
                    return i;
                }
            }
            return 0;
        }
    }

}
