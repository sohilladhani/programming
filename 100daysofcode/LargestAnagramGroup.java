/* https://binarysearch.com/problems/Largest-Anagram-Group */

import java.util.*;

class Solution {
    public int solve(String[] words) {
        int maxAnagrams = 0;
        char[] wordsArray = null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            wordsArray = words[i].toCharArray();
            Arrays.sort(wordsArray);
            int hash = Arrays.hashCode(wordsArray);
            map.put(hash, new Integer(map.getOrDefault(hash, 0) + 1));
            maxAnagrams = Math.max(maxAnagrams, map.get(hash));
        }
        return maxAnagrams;
    }
}
