/* https://binarysearch.com/problems/K-Unique-String */

import java.util.*;

class Solution {
    class Pair implements Comparable<Pair> {
        char c;
        int freq;
        Pair(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
        @Override
        public int compareTo(Pair other) {
            return this.freq - other.freq;
        }
    }
    public int solve(String s, int k) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;

        for (char c : s.toCharArray()) {
            map.put(c, new Integer(map.getOrDefault(c, 0) + 1));
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            minHeap.offer(new Pair(entry.getKey(), entry.getValue()));
        }
        while (minHeap.size() > k) {
            ans += minHeap.poll().freq;
        }
        return ans;
    }
}
