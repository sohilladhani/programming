/* 242. Valid Anagram - https://leetcode.com/problems/valid-anagram */
/* Given two strings s and t , write a function to determine if t is an anagram 
   of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true

Example 2:

Input: s = "rat", t = "car"
Output: false

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution
to such case?
*/

class Anagram {
    public boolean isAnagram(String s, String t) {
        /* Assuming the string is an ASCII string*/
        /* Initialize the array with 0's*/
        int ascii[] = new int[128];

        int sLength = s.length();
        int tLength = t.length();
        if (sLength != tLength) return false;

        for (int i = 0; i < sLength; i++) {
            ascii[(int) s.charAt(i)]++;
        }

        for (int i = 0; i < tLength; i++) {
            ascii[(int) t.charAt(i)]--;
        }

        for (int i = 0; i < 128; i++) {
            if (ascii[i] != 0) return false;
        }

        return true;    
    }

    public static void main (String args[]) {
        Anagram anagramObj = new Anagram();
        String s1 = "care";
        String s2 = "race";
        System.out.println("Anagram? " + anagramObj.isAnagram(s1, s2));
    }
}
