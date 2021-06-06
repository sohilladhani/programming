/* https://binarysearch.com/problems/Anagram-Substrings */

class Solution {
    public int solve(String s0, String s1) {
        int window = s0.length() - 1;
        int ans = 0;
        int i = 0;
        char prev = ' ';
        boolean wasLastWindowAnagram = false;
        while (i + window < s1.length()) {
            int start = i;
            int end = i + window;
            if (i > 0 && wasLastWindowAnagram == true) {
                if (prev == s1.charAt(i + window)) {
                    ans++;
                    wasLastWindowAnagram = true;
                } else {
                    wasLastWindowAnagram = false;
                }
            } else if (areAnagrams(s0, s1, start, end) == true) {
                ans++;
                wasLastWindowAnagram = true;
            } else {
                wasLastWindowAnagram = false;
            }
            prev = s1.charAt(i);
            i++;
        }
        return ans;
    }

    private boolean areAnagrams(String a, String b, int bStart, int bEnd) {
        int[] ascii = new int[26];
        for (char A : a.toCharArray()) {
            ascii[A - 'a']++;
        }
        for (int i = bStart; i <= bEnd; i++) {
            ascii[b.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (ascii[i] != 0)
                return false;
        }
        return true;
    }
}
