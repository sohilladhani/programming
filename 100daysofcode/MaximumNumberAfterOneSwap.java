/* https://binarysearch.com/problems/Maximum-Number-After-One-Swap */

class Solution {
    String max;
    public int solve(int n) {
        String N = String.valueOf(n);
        max = N;
        findMax(N, 1);
        return Integer.parseInt(max);
    }

    private void findMax(String s, int k) {
        if (Integer.parseInt(s) > Integer.parseInt(max)) {
            max = s;
        }
        if (k == 0)
            return;

        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) < s.charAt(j)) {
                    String swapped = swap(s, i, j);
                    findMax(swapped, k - 1);
                }
            }
        }
    }

    private String swap(String s, int i, int j) {
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(i, s.charAt(j));
        sb.setCharAt(j, s.charAt(i));
        return sb.toString();
    }
}
