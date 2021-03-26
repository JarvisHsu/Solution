package subject.datastructrue.LRU;

import java.util.Hashtable;

/**
 * @author Jarvis
 * 模拟双链表+HashMap实现一个LRU缓存
 */
public class LRUCache {
    //实现双链表
    static class Node {
        public int key, val;
        public Node next, prev;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    //插入到头
    private void addToHead(Node node) {
        Node after = head.next;
        node.next = after;
        node.prev = head;

        head.next = node;
        after.prev = node;
    }

    //删除结点
    private void removeNode(Node node) {
        if (head.next != tail) {
            Node before = node.prev;
            Node after = node.next;
            before.next = after;
            after.prev = before;
        }
    }

    //移动结点到头部
    private void moveToHead(Node node) {
        if (head.next != tail) {
            removeNode(node);
            addToHead(node);
        }
    }
    //弹出尾结点 不判空，原因：调用时链不可能为空
    private Node popTail(){
        Node node = tail.prev;
        removeNode(node);
        return node;
    }

    //实现具体缓存
    private final int capacity;
    private int size;
    private final Hashtable<Integer, Node> cache;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new Hashtable<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int val) {
        Node node = cache.get(key);
        if (node == null) {
            node = new Node(key, val);
            cache.put(key,node);
            addToHead(node);
            size++;
            if(size>capacity){
                System.out.println("缓存调整");
                cache.remove(popTail().key);
                size--;
            }
        } else {
            node.val = val;
            moveToHead(node);
        }
    }


    public static void main(String[] args) {
        LRUCache obj = new LRUCache(10);
        for (int i = 0; i < 15; i++) {
            obj.put(i+1,20-i);
            System.out.printf("key:%5d,value:%d\n",i,obj.get(i));
        }
        obj.put(3,100);
        System.out.println();
        for (int i = 0; i < 15; i++) {
            System.out.printf("key:%5d,value:%d\n",i,obj.get(i));
        }
    }

}
