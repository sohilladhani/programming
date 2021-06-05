/* https://binarysearch.com/problems/Rate-Limiter */

import java.util.*;

class RateLimiter {
    int expire;
    Map<Integer, Integer> map;
    public RateLimiter(int expire) {
        this.expire = expire;
        map = new HashMap<>();
    }

    public boolean limit(int uid, int timestamp) {
        if (map.get(uid) != null) {
            if (timestamp - map.get(uid) < expire) {
                return true;
            }
        }
        map.put(uid, timestamp);
        return false;
    }
}
