/* https://binarysearch.com/problems/Sort-by-Frequency-and-Value */

import java.util.*;

class Solution {
    class Pair implements Comparable<Pair> {
        int num; int freq;
        Pair(int num, int freq) {
            this.num = num; this.freq = freq;
        }
        @Override
        public int compareTo(Pair other) {
            if(this.freq - other.freq == 0) return this.num - other.num;
            return this.freq - other.freq;
        }
    }
    public int[] solve(int[] nums) {
        int[] ans = new int[nums.length];
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, new Integer(map.getOrDefault(num, 0) + 1));
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            maxHeap.offer(new Pair(entry.getKey(), entry.getValue()));
        }

        int idx = 0;
        while(!maxHeap.isEmpty()) {
            Pair pair = maxHeap.poll();
            while(pair.freq > 0) {
                ans[idx++] = pair.num;
                pair.freq--;
            }
        }
        return ans;
    }
}
