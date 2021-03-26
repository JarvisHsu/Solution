package subject.datastructrue.LRU;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Jarvis
 * 调用javaApi，使用LinkedHashMap
 */
public class LRUCacheTwo<K,V> extends LinkedHashMap<K,V> {
    private final int capacity;
    public LRUCacheTwo(int capacity){
        super();
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size()>capacity;
    }

    public static void main(String[] args) {
        LRUCacheTwo<Integer,Integer> cache = new LRUCacheTwo<>(10);
        for (int i = 0; i < 15; i++) {
            cache.put(i+1,20-i);
            System.out.printf("key:%5d,value:%d\n",i,cache.get(i));
        }
        cache.put(3,100);
        System.out.println();
        for (int i = 0; i < 15; i++) {
            System.out.printf("key:%5d,value:%d\n",i,cache.get(i));
        }
    }
}
