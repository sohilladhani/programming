/* https://binarysearch.com/problems/Set */

import java.util.*;

class CustomSet {
    Map<Integer, Integer> map;
    public CustomSet() {
        map = new HashMap<>();
    }

    public void add(int val) {
        map.put(val, 0);
    }

    public boolean exists(int val) {
        return map.get(val) != null;
    }

    public void remove(int val) {
        map.remove(val);
    }
}
