package subject.datastructrue.tree;


import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @author Jarvis
 */
public class BsTree {
    public TreeNode<Integer> root;

    public BsTree(int[] arr) {
        for (Integer val : arr) {
            this.root = insertBST(this.root, val);
        }
    }

    public BsTree() {

    }

    private TreeNode<Integer> insertBST(TreeNode<Integer> node, Integer data) {
        TreeNode<Integer> treeNode = new TreeNode<>(data);
        if (node == null) {
            node = treeNode;
        } else {
            if (node.val.equals(treeNode.val)) {
                return node;
            } else {
                if (node.val < treeNode.val) {
                    node.right = insertBST(node.right, treeNode.val);
                } else {
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
        switch (option) {
            case 1:
                List<Integer> traverse = traverse(this.root);
                System.out.println(Arrays.toString(traverse.toArray()));
                break;
            case 2:
                List<List<Integer>> rst = traverseLevel(this.root);
                System.out.println(Arrays.toString(rst.toArray()));
                break;
            default:
                break;
        }
    }

    /**
     * 第一种方式
     *
     * @param root
     * @return
     */
    private List<Integer> traverse(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        List<Integer> rst = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode<Integer> node = queue.poll();
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

    private List<List<Integer>> traverseLevel(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        List<List<Integer>> rst = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = queue.size() - 1; i >= 0; i--) {
                TreeNode<Integer> node = queue.poll();
                assert node != null;
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

    /**
     * 垂序遍历
     */
    private List<Location> locations;
    public void traversalVertical() {
        List<List<Integer>> lists = traversalVertical(this.root);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }

    private List<List<Integer>> traversalVertical(TreeNode<Integer> root) {
        List<List<Integer>> rst = new ArrayList<>();
        locations = new ArrayList<>();
        dfs(root,0,0);
        Collections.sort(locations);
        int prev = locations.get(0).x;
        rst.add(new ArrayList<>());
        for (Location loc : locations) {
            if(loc.x!=prev){
                prev = loc.x;
                List<Integer> temp = new ArrayList<>();
            }
            rst.get(rst.size()-1).add(loc.val);
        }
        return  rst;
    }

    /**
     * 记录当前结点位置
     */
    static class Location implements Comparable<Location> {
        private int x;
        private int y;
        private int val;

        public Location(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Location o) {
            if (this.x != o.x) {
                return Integer.compare(this.x, o.x);
            } else if (this.y != o.y) {
                return Integer.compare(this.y, o.y);
            } else {
                return Integer.compare(this.val, o.val);
            }
        }
    }

    private void dfs(TreeNode<Integer> node,int x,int y){
        if(node!=null){
            locations.add(new Location(x, y, node.val));
            dfs(node.left,x-1,y+1);
            dfs(node.right,x+1,y+1);
        }
    }

    public void traverseInorder() {
        List<Integer> list = new ArrayList<>();
        traverseInorder(this.root, list);
        list.forEach(val -> {
            System.out.print(val + " ");
        });
        System.out.println();

    }

    private void traverseInorder(TreeNode<Integer> node, List<Integer> list) {
        if (node != null) {
            traverseInorder(node.left, list);
            list.add(node.val);
            traverseInorder(node.right, list);
        }
    }
}
