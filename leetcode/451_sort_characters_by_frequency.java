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
        char letter;
        int frequency;
        public Pair(char letter, int frequency) {
            this.letter = letter;
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
        Map<Character, Integer> map = new HashMap<>();
        String ans = "";
        for(int i = 0; i < s.length(); i++) {
            int newValue = 1;
            if(map.get(s.charAt(i)) != null) {
                newValue = map.get(s.charAt(i));
                newValue++;
                map.put(s.charAt(i), newValue);
            } else {
                map.put(s.charAt(i), newValue);
            }
        }
        
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            maxHeap.add(new Pair(entry.getKey(), entry.getValue()));
        }
        while(!maxHeap.isEmpty()) {
            for(int i = 0; i < maxHeap.peek().frequency; i++) {
                ans = ans + maxHeap.peek().letter;
            }
            maxHeap.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "Aabb";
        System.out.println(new FrequencySort().frequencySort(str));
    }
}
