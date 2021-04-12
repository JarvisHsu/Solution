package subject.datastructrue.tree;

/**
 * @author Jarvis
 * 验证镜像树
 */
public class ISMT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        boolean b = verifyMirrorTree(root);
        System.out.println(b);
    }
    public static boolean verifyMirrorTree(TreeNode root){
        if(root==null){
            return true;
        }
        return isMT(root.left,root.right);
    }

    private static boolean isMT(TreeNode node1,TreeNode node2) {
        if(node1==null&&node2==null){
            return true;
        }
        if(node1==null||node2==null||!node1.val.equals(node2.val)){
            return false;
        }
        return isMT(node1.left,node2.right)&&isMT(node1.right,node2.left);
    }
}
