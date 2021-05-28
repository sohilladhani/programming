/* https://binarysearch.com/problems/Selling-Products */

import java.util.*;

class Solution {
    class Pair implements Comparable<Pair> {
        int id;
        int freq;
        Pair(int id, int freq) {
            this.id = id;
            this.freq = freq;
        }
        @Override
        public int compareTo(Pair other) {
            return this.freq - other.freq;
        }
    }
    public int solve(int[] items, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        for (int i = 0; i < items.length; i++) {
            map.put(items[i], new Integer(map.getOrDefault(items[i], 0) + 1));
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.offer(new Pair(entry.getKey(), entry.getValue()));
        }
        while (n > 0) {
            Pair pair = minHeap.peek();
            if (n >= pair.freq) {
                n = n - pair.freq;
                minHeap.poll();
            } else {
                pair.freq = pair.freq - n;
                n = pair.freq - n;
            }
        }
        return minHeap.size();
    }
}
