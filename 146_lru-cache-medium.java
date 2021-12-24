import java.io.*;
import java.util.*;

/*
1) 0.75 is load factor, that decides when to increase the HashMap capacity.
2) Linkedhashmap supports two modes, access mode and order mode, that 'true' is for access modes ,for more, you can also read in official docs.
*/

class LRUCache {
    HashMap<Integer,Integer> cache;
    public LRUCache(int capacity) {
        cache = new LinkedHashMap<>(capacity, 0.75f, true){  
            protected boolean removeEldestEntry(Map.Entry eldest)
            {
                return size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        cache.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
