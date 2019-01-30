/* URLify: Write a method to replace all spaces in a string with '%20'. 
 * You may assume that the string has sufficient space at the end to 
 * hold the additional characters,and that you are given the "true"
 * length of the string. (Note: If implementing in Java,please use a 
 * character array so that you can perform this operation in place.)
 *
 * Example
 *
 * Input: "Mr John Smith    ", 13
 * Output: "Mr%20John%20Smith"
 *
 * */

class URLify {

	public static String URLifyTheStringInPlace(String inputString, int trueLength) {
		if(trueLength <= 0) return "";

		int noOfSpaces = 0;
		char inputArray[] = inputString.toCharArray();
	
		for(int i = 0; i < trueLength; i++) {
			if(inputArray[i] == ' ') {
				noOfSpaces++;
			}
		}

		int finalLength = noOfSpaces * 2 + trueLength;
		
		if(trueLength < inputArray.length) inputArray[trueLength] = '\0';

		int i = trueLength - 1;
		int j = finalLength - 1;


		while(i>0){
			if(inputArray[i] == ' ') {
				inputArray[j--] = '0';
				inputArray[j--] = '2';
				inputArray[j] = '%';
			} else {
				inputArray[j] = inputArray[i];
			}
			i--;
			j--;
		}

		return String.valueOf(inputArray);
	}

	public static String URLifyTheString(String inputString, int true_length) {
		if(true_length <= 0) {
			return "";
		}
		char sourceArray[] = inputString.toCharArray();
		int length = sourceArray.length;

		int i = 0;
		for(i=0; sourceArray[i] == ' '; i++);

		int k = 0;
		char destArray[] = new char[length];
		
		while(true_length > 0){
			if(sourceArray[i] == ' ') {
				destArray[k++] = '%';
				destArray[k++] = '2';
				destArray[k] = '0';
			} else {
				destArray[k] = sourceArray[i];
			}
			i++;
			k++;
			true_length--;
		}
			
		return String.valueOf(destArray);
	}

	public static void main(String args[]) {
		String string = "Mr John Smith    ";
		System.out.println(URLifyTheString(string, 13));
		System.out.println(URLifyTheStringInPlace(string, 13));
	}

}
