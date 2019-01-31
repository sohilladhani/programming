/* Palindrome Permutation: Given a string, write a function to check if it is a 
 * permutation of a palindrome. A palindrome is a word or phrase that is the same 
 * forwards and backwards. A permutation is a rearrangement of letters. 
 * The palindrome does not need to be limited to just dictionary words.
 *  
 * EXAMPLE
 * Input: Tact Coa
 * Output: True (permutations: "taco cat", "atco eta", etc.)
 *
 * */

class PalindromePermutation {

	public static boolean isUpperCase(char character) {
		return ((int) character >= 65 && (int) character <= 90);
	}

	public static boolean isPalindromePermutationASCIICaseInsensitive(String inputString) {
		int count[] = new int[128];
		int inputStringLength = inputString.length();

		for(int i = 0; i < inputStringLength; i++) {
			if(inputString.charAt(i) != ' ') {
			
				if(isUpperCase(inputString.charAt(i))) {
					count[(int)inputString.charAt(i) + 32]++;
				} else {
					count[(int)inputString.charAt(i)]++;
				}
			}
		}

		int noOfOdds = 0;
		for(int i = 0; i < 128; i++) {
			if(noOfOdds > 1) return false;
			if(count[i] % 2 == 0) { 
				continue;
			} else {
				noOfOdds++;
			}
		}

		return true;
	}

	public static void main(String args[]) {
		String string = "malayalam";
		System.out.println(isPalindromePermutationASCIICaseInsensitive(string));

	}
}
