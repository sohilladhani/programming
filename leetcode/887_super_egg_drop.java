/* 887. Super Egg Drop
 * https://leetcode.com/problems/super-egg-drop/
 * You are given K eggs, and you have access to a building with N floors from 1 to N. 

Each egg is identical in function, and if an egg breaks, you cannot drop it 
again.

You know that there exists a floor F with 0 <= F <= N such that any egg dropped 
at a floor higher than F will break, and any egg dropped at or below floor F 
will not break.

Each move, you may take an egg (if you have an unbroken one) and drop it from 
any floor X (with 1 <= X <= N). 

Your goal is to know with certainty what the value of F is.

What is the minimum number of moves that you need to know with certainty what F 
is, regardless of the initial value of F?
Example 1:


Input: K = 1, N = 2
Output: 2
Explanation: 
Drop the egg from floor 1.  If it breaks, we know with certainty that F = 0.
Otherwise, drop the egg from floor 2.  If it breaks, we know with certainty that
F = 1.
If it didn't break, then we know with certainty F = 2.
Hence, we needed 2 moves in the worst case to know what F is with certainty.

Example 2:

Input: K = 2, N = 6
Output: 3

Example 3:

Input: K = 3, N = 14
Output: 4

Note:

    1 <= K <= 100
    1 <= N <= 10000

Explanation:
https://youtu.be/S49zeUjeUL0?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go
*/

class SuperEggDrop {
    int[][] cache;
    public int superEggDrop(int eggs, int floors) {
        cache = new int[eggs+1][floors+1];
        return sedDP(eggs, floors); 
    }

    private int sedDP(int eggs, int floors) {
        if(cache[eggs][floors] != 0) return cache[eggs][floors];
        if(eggs == 1) return floors;
        if(floors == 0 || floors == 1) return floors;

        int minAttempts = Integer.MAX_VALUE;
        int low = 1; int high = floors;

//        for(int k = 1; k <= floors; k++) {
//            int attempts = 1 + Math.max(sedDP(eggs-1, k - 1), 
//                                        sedDP(eggs, floors - k));
//            minAttempts = Math.min(minAttempts, attempts);
//        }

        //https://leetcode.com/problems/super-egg-drop/discuss/792736/CPP-Explained-Recursive-greatermemoization-greateroptimization-greaterDP-oror-Well-Explained-oror-Easy-to-unserstand
        //Using binary search to reduce search space
        while(low <= high) {
            int mid = low + (high - low)/2;
            int left = sedDP(eggs - 1, mid - 1);
            int right = sedDP(eggs, floors - mid);
            //Taking maximum since we want worst case
            int attempts = 1 + Math.max(left, right); 
            if(left < right) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            minAttempts = Math.min(minAttempts, attempts);
        }
        return cache[eggs][floors] = minAttempts;
    }

    private int sedRecursive(int eggs, int floors) {
        if(floors ==0 || floors == 1) return floors;
        if(eggs == 1) return floors;

        int minAttempts = Integer.MAX_VALUE;

        for(int k = 1; k <= floors; k++) {
            // attempts in worst case ---
            // If egg breaks at a floor, solve for below floors with rest of the
            // eggs-> solve sedRecursive(eggs-1, k-1)
            // If egg doesn't break, go to the above floor with same egg ->
            // solve sedRecursive(eggs, floors-k)
            // Add 1 for every attempt made. Take max to find the attempts in 
            // worst case, and then take minimum of the attempts and current
            // minimum
            int attempts = 1 + Math.max(sedRecursive(eggs-1, k-1),
                                    sedRecursive(eggs, floors-k));
            minAttempts = Math.min(minAttempts, attempts);
        }
        return minAttempts;
    }

    public static void main(String[] args) {
        SuperEggDrop sed = new SuperEggDrop();
        int eggs = 0;
        int floors = 0;
        eggs = 1;
        floors = 2;
        System.out.println(sed.superEggDrop(eggs, floors));
        eggs = 2;
        floors = 6;
        System.out.println(sed.superEggDrop(eggs, floors));
        eggs = 3;
        floors = 14;
        System.out.println(sed.superEggDrop(eggs, floors));
        eggs = 2;
        floors = 100;
        System.out.println(sed.superEggDrop(eggs, floors));
        eggs = 6;
        floors = 1000;
        System.out.println(sed.superEggDrop(eggs, floors));
    }
}
