package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
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
            public List<Integer> rightSideView(TreeNode root) {
                return rightSideView2(root, 0);
            }

            // with queue
            public List<Integer> rightSideView2(TreeNode root, int digits) {
                List<Integer> l1 = new ArrayList<>();
                if (root == null) {
                    return l1;
                }
                Queue<TreeNode> q = new LinkedList<>();
                q.add(root);
                while (!q.isEmpty()) {
                    int levelsize = q.size();
                    for (int i = 0; i < levelsize; i++) {
                        TreeNode nn = q.remove();
                        if (i == levelsize - 1) {
                            l1.add(nn.val);
                        }
                        if (nn.left != null) {
                            q.add(nn.left);
                        }
                        if (nn.right != null) {
                            q.add(nn.right);
                        }
                    }
                }
                return l1;

            }


        }

        class Solution2 {
            int visited=-1;

            public List<Integer> rightSideView(TreeNode root) {
                List<Integer> l1 = new ArrayList<>();
                view(root, 0, l1);
                return l1;
            }

            public void view(TreeNode root, int current, List<Integer> res) {
                if(root==null){
                    return;
                }
                if(current>visited){
                    res.add(root.val);
                    visited=current;
                }
                view(root.right, current+1, res); 
                view(root.left, current+1, res);

            }

        }
    }
}