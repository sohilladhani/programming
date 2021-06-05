/* 204. Count Primes - https://leetcode.com/problems/count-primes/ */
/* Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
*/

class CountPrimes {
    public int countPrimes(int n) {
        if (n <= 1) return 0;

        int primesCount = 0;
        int primes[] = new int[n+1];
        for (int i = 2; i <= n; i++) {
            primes[i] = 1;
        }

        for (int i = 2; i*i <= n; i++) {
            if (primes[i] == 1) {
                for (int j = i*i; j <= n; j = j+i) {
                    primes[j] = 0;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (primes[i] == 1) {
                System.out.printf("%d,", i);
                primesCount++;
            }
        }
        System.out.println();
        return primesCount;
    }
    public static void main(String args[]) {
        int n = 52;
        CountPrimes cp = new CountPrimes();
        System.out.println(cp.countPrimes(n));
    }
}
