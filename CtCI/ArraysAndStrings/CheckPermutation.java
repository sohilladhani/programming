/* Given two strings, write a method to decide if one is a permutation of the other. */

/* Questions to ask the interviewer:
 * 1. Are the strings case sensitive
 * 2. Are the strings represented in ASCII?  Or the representation is generic?
 * 3. Are whitespaces significant?
 */

import java.util.Arrays;

class CheckPermutation {
	
	public static boolean arePermutationsIfInGeneric(String string1, String string2) {
		if(string1.length() != string2.length()) {
			return false;
		}
		int stringLength = string1.length(); /* int stringLength = string2.length(); */
		char string1CharArray[] = string1.toCharArray();
		char string2CharArray[] = string2.toCharArray();
		Arrays.sort(string1CharArray);
		Arrays.sort(string2CharArray);

		for(int i=0; i<stringLength; i++) {
			if(string1CharArray[i] != string2CharArray[i]) {
				return false;
			}
		}

		return true;
	}

	public static boolean arePermutationsIfInASCII(String string1, String string2) {
		if(string1.length() != string2.length()){
			return false;
		}
		
		int stringLength = string1.length();

		int countString1Characters[] = new int[128];
		for(int i=0; i<stringLength; i++) {
			countString1Characters[(int)string1.charAt(i)]++;
		}

		int countString2Characters[] = new int[128];
		for(int i=0; i<stringLength; i++) {
			countString2Characters[(int)string2.charAt(i)]++;
		}

		for(int i=0; i<128; i++) {
			if(countString1Characters[i] != countString2Characters[i]) {
				return false;
			}
		}

		return true;
	}

	public static void main(String args[]) {
		String string1 = "abccdefab";
		String string2 = "aabbfecdc";
		System.out.println(arePermutationsIfInGeneric(string1, string2));
		System.out.println(arePermutationsIfInASCII(string1, string2));
	}
}
