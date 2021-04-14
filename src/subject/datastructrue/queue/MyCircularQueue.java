package subject.datastructrue.queue;

import java.util.LinkedList;

/**
 * @author Jarvis
 * 循环队列设计
 */
public class MyCircularQueue {
    LinkedList<Integer> queue;
    private final int len;

    /**
     * @param k 构造器，设置队列长度为 k 。
     */
    public MyCircularQueue(int k) {
        this.queue = new LinkedList<>();
        this.len = k;
    }

    /**
     * @param value 需要插入的元素
     * @return 向循环队列插入一个元素。如果成功插入则返回真。
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        return queue.offer(value);
    }

    /**
     * @return 从循环队列中删除一个元素。如果成功删除则返回真。
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        Integer integer = queue.pollFirst();
        return integer != null;
    }

    /**
     * @return 从队首获取元素。如果队列为空，返回 -1
     */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        Integer peek = queue.getFirst();
        if (peek == null) {

            return -1;
        }
        return peek;
    }

    /**
     * @return 获取队尾元素。如果队列为空，返回 -1 。
     */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        Integer peek = queue.getLast();
        if (peek == null) {
            return -1;
        }
        return peek;
    }

    /**
     * @return 检查循环队列是否为空。
     */
    public boolean isEmpty() {
        return queue.size() == 0;
    }

    /**
     * @return 检查循环队列是否已满。
     */
    public boolean isFull() {
        return queue.size() == len;
    }

    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(10);
    }
}
