package subject.datastructrue.tree;

/**
 * @author Jarvis
 * 验证二叉搜索树
 * 二叉搜索树的定义：
 *  0、一棵空树
 *  1、左子树不为空，则左子树上所有结点值均小于它的根节点值
 *  2、右子树不空，则右子树上所有结点的值均大于或等于它的根结点的值；
 *  3、左右子树分别为二叉搜索树
 */
public class ISBST {
    public static void main(String[] args) {
        BsTree bsTree = new BsTree(new int[]{3, 2, 5, 8, 4, 7, 6, 9, 0, 1});
        bsTree.traversalVertical();
        System.out.println(verifyBST(bsTree.root));
        System.out.println(verifyBST(null));
    }
    public static boolean verifyBST(TreeNode<Integer> root){
        return isBST(root);
    }

    private static boolean isBST(TreeNode<Integer> node) {
        if (node == null) {
            return true;
        }
        if (node.left != null && node.left.val >= node.val) {
            return false;
        }
        if (node.right != null && node.right.val < node.val) {
            return false;
        }
        return isBST(node.left) && isBST(node.right);
    }
}
