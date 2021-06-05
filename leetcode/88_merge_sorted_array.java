/* 88. Merge Sorted Array - https://leetcode.com/problems/merge-sorted-array */
/* Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 *
 * Note:
 *
 *     The number of elements initialized in nums1 and nums2 are m and n
 *     respectively.
 *         You may assume that nums1 has enough space (size that is greater or
 *         equal to m + n) to hold additional elements from nums2.
 *
 *         Example:
 *
 *         Input:
 *         nums1 = [1,2,3,0,0,0], m = 3
 *         nums2 = [2,5,6],       n = 3
 *
 *         Output: [1,2,2,3,5,6]
 */

class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1 = 0, n2 = 0, h = m, r = 0, N = m + n;
        if (m == 0) {
            for (int i = 0; i < n; i++){
                nums1[i] = nums2[i];
            }
        }
        if (n != 0) {
            while (h < N) {
                if (n1 != h && nums1[n1] <= nums2[n2]) {
                    n1++;
                } else {
                    r = h;
                    while (n1 < r) {
                        nums1[r] = nums1[--r];
                    }
                    nums1[n1] = nums2[n2];
                    n1++; n2++; h++;
                }
            }
        }
    }

    public static void main(String args[]) {
        MergeSortedArray msa = new MergeSortedArray();
        int nums1[] = {1,2,3,0,0,0};
        int nums2[] = {2,5,6};
        int m = 3;
        int n = 3;
        msa.merge(nums1, m, nums2, n);
        System.out.println(Utils.integerArrayToString(nums1));
    }
}
