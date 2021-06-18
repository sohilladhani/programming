/* https://binarysearch.com/problems/Least-Recently-Used-Cache */

import java.util.*;

class LRUCache {
    Map<Integer, Integer> map;
    public LRUCache(int capacity) {
        map = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void set(int key, int val) {
        map.put(key, val);
    }
}
