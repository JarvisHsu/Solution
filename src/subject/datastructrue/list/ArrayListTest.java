package subject.datastructrue.list;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Jarvis
 */
public class ArrayListTest {
    public static void main(String[] args) {
        //初始空间DEFAULT_CAPACITY=10
        ArrayList<Integer> list = new ArrayList<>();
        //ArrayList最大空间MAXCAPACITY = Integer.MAX_VALUE-8;（最大空间可以达到MAXVALUE）
        //减8因为有的虚拟机在数组中保留一个header words(头词?)
        //但是一般由于机器限制，在未达到最大空间之前，就会报OutOfMemoryError错误
        for (int i = 0; i < 500; i++) {
            list.add(i);
            //扩容机制：在每次add调用时会判是否达到当前最大空间，然后调用grow()
            //将当前空间长度（上次扩容后的大小）oldCapacity+(oldCapacity>>1)经过计算得到新的数组空间
        }
        System.out.println(list.size()+","+ Arrays.toString(list.toArray()));





    }
}
