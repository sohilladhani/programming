/* https://binarysearch.com/problems/Word-Formation */

import java.util.*;

class Solution {
    public int solve(String[] words, String letters) {
        int[] letterFreq = new int[26];
        int longestWord = 0;
        for (int i = 0; i < letters.length(); i++) {
            letterFreq[letters.charAt(i) - 'a']++;
        }

        for (String word : words) {
            int totalWords = wordsMade(letterFreq, word);
            longestWord = Math.max(longestWord, totalWords);
        }

        return longestWord;
    }

    private int wordsMade(int[] letterFreq, String word) {
        int totalWords = 0;
        int[] freq = Arrays.copyOf(letterFreq, letterFreq.length);
        for (int i = 0; i < word.length(); i++) {
            if (freq[word.charAt(i) - 'a'] > 0)
                totalWords++;
            freq[word.charAt(i) - 'a']--;
        }

        return totalWords >= word.length() ? totalWords : 0;
    }
}
