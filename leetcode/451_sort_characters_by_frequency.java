/* Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.

Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
*/
import java.util.*;

class FrequencySort {
    
    class Pair implements Comparable<Pair> {
        int letterIndex;
        int frequency;
        public Pair(int letterIndex, int frequency) {
            this.letterIndex = letterIndex;
            this.frequency = frequency;
        }
        
        @Override
        public int compareTo(Pair other) {
            return this.frequency - other.frequency;
        }
        
    }
    public String frequencySort(String s) {
        PriorityQueue<Pair> maxHeap = new
            PriorityQueue<>(Comparator.reverseOrder());
        int[] freqs = new int[128];
        StringBuilder ans = new StringBuilder("");
        for(int i = 0; i < s.length(); i++) {
            freqs[(int) s.charAt(i)]++;
        }
        
        for(int i = 0; i < freqs.length; i++) {
            if(freqs[i] > 0) {
                maxHeap.add(new Pair(i, freqs[i]));
            }
        }
        while(!maxHeap.isEmpty()) {
            for(int i = 0; i < maxHeap.peek().frequency; i++) {
                ans.append((char) maxHeap.peek().letterIndex);
            }
            maxHeap.poll();
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String str = "tree";
        System.out.println(new FrequencySort().frequencySort(str));
    }
}
