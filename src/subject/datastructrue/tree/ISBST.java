package subject.datastructrue.tree;

/**
 * @author Jarvis
 * 验证二叉搜索树
 */
public class ISBST {
    public static void main(String[] args) {

        //System.out.println(isBST());
    }
    public boolean isBST(TreeNode root){
        if(root==null){
            return true;
        }
        if(root.left!=null&&root.left.val>= root.val){
            return false;
        }
        if(root.right!=null&&root.right.val<= root.val){
            return false;
        }
        return isBST(root.left) && isBST(root.right);
    }
}
