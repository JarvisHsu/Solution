package subject.datastructrue.tree;

/**
 * @author Jarvis
 */
public class TreeNode<T> {
        public T val;
        public TreeNode<T> left;
        public TreeNode<T> right;

        public TreeNode(T val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        public TreeNode() {
            this.left = null;
            this.right = null;
        }
    }

