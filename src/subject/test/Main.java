package subject.test;

/**
 * @author Jarvis
 */
public class Main {
    //p：终点->回到起点
    //q：
    //p->l1:2->3->4->5->
    //q->l2:3->4->5->
    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        //l1:1->2->^
        ListNode l1 = new ListNode(1);
        //l2:3->^
        ListNode l2 = new ListNode(3);
        System.out.println(hasSameNode(l1,l2));
    }
    public static boolean hasSameNode(ListNode l1,ListNode l2){
        //l1或l2为空，则无交点
        if(l1==null||l2==null){
            return false;
        }
        ListNode p = l1;
        ListNode q = l2;

        while(q!=p){
            if(q==null&&p==null){
                break;
            }
            p = p!=null?p.next:l2;
            q = q!=null?q.next:l1;
        }
        return q!=null;
    }
}
