class CountOfSubsetWithGivenSum {

    private static int countSubset(int[] arr, int n, int sum) {
		if(sum == 0) return 1;
		if(n == 0) return 0;

        if(arr[n-1] <= sum) {
            return countSubset(arr, n-1, sum) + countSubset(arr, n-1, sum - arr[n-1]);
        } else {
            return countSubset(arr, n-1, sum);
        }
	}

    public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int[] arr = {2, 3, 8, 10};
		int sum = 10;
		System.out.println(countSubset(arr, arr.length, sum));
	}
}
