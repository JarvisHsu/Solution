package subject.datastructrue.list;

import java.util.LinkedList;

/**
 * @author Jarvis
 */
public class LinkedListTest {
    public static void main(String[] args) {
        //底层：双链表
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        for (Integer num : list) {
            System.out.printf("%d ", num);
        }
        System.out.println();
    }
}
