/* One Away: There are three types of edits that can be performed on strings: insert a character,
   remove a character, or replace a character. Given two strings, write a function to check if they are
   one edit (or zero edits) away.
   EXAMPLE 
   pale, ple -> true
   pales, pale -> true
   pale, bale ->  true
   pale, bake ->  false
 *
 *
 * */

/* Assumptions:
 * 1. Strings are case insensitive (A = a)
 * 2. Strings do not contain whitespaces
 */


/* Input: string1, string2
 * Output: boolean (true/false)
 *
 */

class OneAway {
		
	public static boolean areStringsOneOrZeroEditsAway(String string1, String string2) {
		int string1Length = string1.length();
		int string2Length = string2.length();
		if(Math.abs(string1Length - string2Length) > 1) {
			return false;
		}

		if(Math.abs(string1Length - string2Length) == 1) {
			String biggerString; String smallerString;
		
			if(string1Length > string2Length) {
				biggerString = string1;
				smallerString = string2;
			} else {
				biggerString = string2;
				smallerString = string1;
			}	

			int i = 0; int j = 0; int diffCount = 0;

			while(i < biggerString.length()) {
				if(diffCount > 1) return false;
				if(biggerString.charAt(i) != biggerString.charAt(j)) {
					i++;
					diffCount++;
					continue;
				}
				i++;
				j++;
			}

		} 

		if(Math.abs(string1Length - string2Length) == 0) {
			int i = 0; int diffCount = 0;

			while(i < string1Length) {
				if(diffCount > 1) return false;
				if(string1.charAt(i) != string2.charAt(i)) {
					diffCount++;
				}
				i++;
			}
		}

		return true;
	}

	public static void main(String args[]) {
		if(args.length < 2) {
			System.out.println("Proper usage: java OneAway string1 string2");
			System.exit(0);
		}
		String string1 = args[0];
		String string2 = args[1];
		System.out.println(areStringsOneOrZeroEditsAway(string1, string2));
	}
}
