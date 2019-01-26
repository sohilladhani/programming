class IsUnique {

	public static boolean hasUniqueCharacters(String string) {
		char characters[] = string.toCharArray();
		int size = characters.length;

		if(size > 128) return false;

		boolean count[] = new boolean[128];

		for(int i=0; i<size; i++) {
			if(count[(int)characters[i]]) {
				return false;
			}
			count[characters[i]] = true;
		}
		return true;		
	}

	public static void main(String args[]){
		String string = "NCwwBLCJGgoNVIkISLRb";
		System.out.println(hasUniqueCharacters(string));
	}
}
