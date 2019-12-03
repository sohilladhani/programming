/* String Compression: Implement a method to perform basic string compression 
 * using the counts of repeated characters. For example, the string aabcccccaaa
 * would become a2blc5a3. If the "compressed" string would not become smaller
 * than the original string, your method should return the original string. 
 * You can assume the string has only uppercase and lowercase letters (a - z).
 * 
 *
 * Assumptions: 1. Only lowercase and uppercase letters are present in the string
 *
 * Input: String to be compressed (String in Java)
 * Output: Compressed string (String in Java)
 *
 * */

class StringCompression {

	public static String compressString(String stringToBeCompressed) {
		if(stringToBeCompressed == "" || stringToBeCompressed == null) {
			return "";
		}

		int stringToBeCompressedLength = stringToBeCompressed.length();

		StringBuilder compressedString = new StringBuilder();
		char currentCharacter = stringToBeCompressed.charAt(0); 
		int currentCharacterCount = 0;
		
		for(int i = 0; i < stringToBeCompressedLength; i++) {
			char c = stringToBeCompressed.charAt(i);
			if (c == ' ') continue;
			if (c != currentCharacter) {
				compressedString.append(currentCharacter);
				compressedString.append(currentCharacterCount);
				currentCharacter = c;
				currentCharacterCount = 1;
			} else {
				currentCharacterCount++;
			}
		}
		
		compressedString.append(currentCharacter);
		compressedString.append(currentCharacterCount);

		if(compressedString.toString().length() > stringToBeCompressedLength) {
			return stringToBeCompressed;
		}

		return compressedString.toString();
	}


	public static void main(String args[]) {
		if(args.length < 1) {
			System.out.println("Proper usage: java StringCompression stringToBeCompressed");
			System.exit(0);
		}
		System.out.println(compressString(args[0]));
	}
}
