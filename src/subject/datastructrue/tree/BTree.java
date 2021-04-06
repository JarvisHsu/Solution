package subject.datastructrue.tree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @author Jarvis
 */
class TreeNode {
    public Integer val;
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

    public BTree(int[] arr) {
        for(Integer val:arr){
            this.root = insertBST(this.root,val);
        }
    }
    public BTree() {

    }
    private TreeNode insertBST(TreeNode node,Integer data){
        TreeNode treeNode = new TreeNode(data);
        if(node==null){
            node = treeNode;
        }else{
            if(node.val.equals(treeNode.val)){
                return node;
            }else{
                if(node.val<treeNode.val){
                    node.right = insertBST(node.right,treeNode.val);
                }else{
                    node.left = insertBST(node.left, treeNode.val);
                }
            }
        }
        return node;
    }

    /**
     * 层序遍历
     */
    public void traverse(int option) {
        switch (option){
            case 1:List<Integer> traverse = traverse(this.root);
                System.out.println(Arrays.toString(traverse.toArray()));break;
            case 2:
                List<List<Integer>> rst = traverseLevel(this.root);
                System.out.println(Arrays.toString(rst.toArray()));
                break;
            default:;break;
        }
    }

    /**
     * 第一种方式
     * @param root
     * @return
     */
    private List<Integer> traverse(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> rst = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            rst.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }

        }
        return rst;
    }
    private List<List<Integer>> traverseLevel(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> rst = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = queue.size()-1; i >=0; i--) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            rst.add(list);
        }
        return rst;
    }

    public void traverseInorder(){
        List<Integer> list = new ArrayList<>();
        traverseInorder(this.root,list);
        list.forEach(val->{
            System.out.print(val+" ");
        });
        System.out.println();

    }
    private void traverseInorder(TreeNode node,List<Integer> list){
        if(node!=null){
            traverseInorder(node.left,list);
            list.add(node.val);
            traverseInorder(node.right,list);
        }
    }
}
