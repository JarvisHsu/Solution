package subject.datastructrue.tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jarvis
 */
class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode() {
        this.left = null;
        this.right = null;
    }
}

public class BTree {
    public TreeNode root;

    public BTree() {
        root = new TreeNode();
    }
    public void traverse() {
        List<Integer> traverse = traverse(root);
        traverse.forEach(System.out::println);
    }

    private List<Integer> traverse(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> rst = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            rst.add(root.val);
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            }
        }
        return rst;
    }

}
