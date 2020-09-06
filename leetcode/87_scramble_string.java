/* 87. Scramble String
 * https://leetcode.com/problems/scramble-string/
 * We can scramble a string s to get a string t using the following algorithm:
    If the length of the string is 1, stop.
    If the length of the string is > 1, do the following:
        Split the string into 2 non-empty substrings at a random index, i.e. if 
        the string is s, divide it to x and y where s = x + y.
        Randomly, decide to swap the two substrings or to keep them in the same 
        order. i.e. after this step, s may become s = x + y or s = y + x.
        Apply step 1 recursively on each of the two substrings x and y.

Given two strings s1 and s2 of the same length, return true if s2 is a scrambled
string of s1, otherwise, return false.

Example 1:

Input: s1 = "great", s2 = "rgeat"
Output: true
Explanation: One possible scenario applied on s1 is:
"great" --> "gr/eat" // divide at random index.
"gr/eat" --> "gr/eat" // random decision is not to swap the two substrings and 
keep them in order.
"gr/eat" --> "g/r / e/at" // apply the same algorith recursively on both 
substrings. divide at ranom index each of them.
"g/r / e/at" --> "r/g / e/at" // random decision was to swap the first substing 
and to keep the second substring in the same order.
"r/g / e/at" --> "r/g / e/ a/t" // again apply the algorithm recursively, divide
"at" to "a/t".
"r/g / e/ a/t" --> "r/g / e/ a/t" // random decision is to keep both substings 
in the same order.
The algorithm stops now and the result string is "rgeat" which is s2.
As there is one possible scenario that led s1 to be scrambled to s2, we return 
true.

Example 2:

Input: s1 = "abcde", s2 = "caebd"
Output: false

Example 3:

Input: s1 = "a", s2 = "a"
Output: true
Constraints:

    s1.length == s2.length
    1 <= s1.length <= 30
    s1 and s2 consist of lower-case English letters.

Explanation:
https://youtu.be/SqA0o-DGmEw?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go
*/

class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        return false; 
    }

    public boolean isScrambleRecursive(String a, String b) {
        if(a.length() != b.length()) return false;
        if(a.length() == 0) return false;
        return isSR(a, b);
    }

    private boolean isSR(String a, String b) {
        int n = a.length();
        if(a.equals(b)) return true;
        if(n <= 1) return false;
        
        boolean isSS = false;
        boolean swapped = false;
        boolean not_swapped = false;
        for(int i = 1; i < n; i++) {
            swapped = isSR(a.substring(0, i), b.substring(n-i, n)) &&
                              isSR(a.substring(i, n), b.substring(0, n-i));

            not_swapped = isSR(a.substring(0, i), b.substring(0, i)) &&
                                  isSR(a.substring(i, n), b.substring(i, n));
//            swapped = isSR(new String(a.getBytes(), 0, i), 
//                           new String(b.getBytes(), n-i, i)) &&
//                      isSR(new String(a.getBytes(), i, n-i), 
//                           new String(b.getBytes(), 0, n-i));
//
//            not_swapped = isSR(new String(a.getBytes(), 0, i), 
//                           new String(b.getBytes(), 0, i)) &&
//                      isSR(new String(a.getBytes(), i, n-i), 
//                           new String(b.getBytes(), i, n-i));
            if(swapped || not_swapped) {
                isSS = true;
                break;
            }
        }
        return isSS;
    }

    public static void main(String[] args) {
        ScrambleString ss = new ScrambleString();
        String a = "";
        String b = "";
        a="great";
        b="rgeat";
        System.out.println(ss.isScrambleRecursive(a,b));
        a="abcde";
        b="caebd";
        System.out.println(ss.isScrambleRecursive(a,b));
    }
}
