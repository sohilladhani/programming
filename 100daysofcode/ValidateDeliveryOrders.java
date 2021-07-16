/* https://binarysearch.com/problems/Validate-Delivery-Orders */

import java.util.*;

class Solution {
    public boolean solve(String[] orders) {
        if(orders.length < 2) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < orders.length; i++) {
            String order = orders[i];
            int orderId = Integer.parseInt(order.substring(1, order.length()));
            if(order.charAt(0) == 'P') {
                if(map.get(orderId) != null) return false;
                map.put(orderId, 1);
            } else {
                if(map.get(orderId) == null) return false;
                map.put(orderId, 0);
            }
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() == 1) return false;
        }

        return true;
    }
}
