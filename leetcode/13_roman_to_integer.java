/* 13. Roman to Integer - https://leetcode.com/problems/roman-to-integer/ */
/* Roman numerals are represented by seven different symbols: I, V, X, L, C, D
 * and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

For example, two is written as II in Roman numeral, just two one's added 
together. Twelve is written as, XII, which is simply X + II. The number twenty 
seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. 
However, the numeral for four is not IIII. Instead, the number four is written 
as IV. Because the one is before the five we subtract it making four. The same
principle applies to the number nine, which is written as IX. There are six
instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9. 
    X can be placed before L (50) and C (100) to make 40 and 90. 
    C can be placed before D (500) and M (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer. Input is guaranteed to be
within the range from 1 to 3999.*/

class RomanToInteger {
    public int romanToInt(String s) {
        int result = 0;
        int sLength = s.length(); 
        for (int i = 0; i < sLength; i++) {
            switch(s.charAt(i)) {
                case 'I':
                    result += 1;
                    break;
                case 'V':
                    if(i > 0 && s.charAt(i-1) == 'I') {
                        result += 3;
                    } else {
                        result += 5;
                    }
                    break;
                case 'X':
                    if(i > 0 && s.charAt(i-1) == 'I') {
                        result += 8;
                    } else {
                        result += 10;
                    }
                    break;
                case 'L':
                    if(i > 0 && s.charAt(i-1) == 'X') {
                        result += 30;
                    } else {
                        result += 50;
                    }
                    break;
                case 'C':
                    if(i > 0 && s.charAt(i-1) == 'X') {
                        result += 80;
                    } else {
                        result += 100;
                    }
                    break;
                case 'D':
                    if(i > 0 && s.charAt(i-1) == 'C') {
                        result += 300;
                    } else {
                        result += 500;
                    }
                    break;
                case 'M':
                    if(i > 0 && s.charAt(i-1) == 'C') {
                        result += 800;
                    } else {
                        result += 1000;
                    }
                    break;
                default:
            }
        }
        return result;
    }

    public static void main (String args[]) {
        RomanToInteger rti = new RomanToInteger();
        String romanNumerals [] = {"MMMDCCXXIV", "MCMXCVI", "MMXII", "XXXVI",
                                   "XCVIII"};
        for (int i = 0; i< romanNumerals.length; i++) {
            System.out.println("Roman: " + romanNumerals[i]);
            System.out.println("Integer: " + rti.romanToInt(romanNumerals[i]));
        }
    }
}
