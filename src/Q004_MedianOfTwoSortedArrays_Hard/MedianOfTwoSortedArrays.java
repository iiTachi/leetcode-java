package Q004_MedianOfTwoSortedArrays_Hard;

/**
 * @author Howie Lu
 * @version Updated at 2020/01/04
 * @description
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 */

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int odd = (n + m + 1) / 2; // 共有奇数个元素
        int even = (n + m + 2) / 2; // 共有偶数个元素
        // 奇数偶数情况合并
        return (
                getKth(nums1, 0, m-1, nums2, 0, n-1, odd) //奇数情况
                +
                getKth(nums1, 0, m-1, nums2, 0, n-1, even) //偶数情况
                ) * 0.5;
    }

    private double getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k){
        int length1 = end1 - start1 + 1;
        int length2 = end2 - start2 + 1;
        // 使length1始终小于length2，确保若有数组为空，则一定是nums1
        if (length1 > length2){ return getKth(nums2, start2, end2, nums1, start1, end1, k); }
        // 若nums1为空，直接返回nums2的第k个元素
        if (length1 == 0){ return nums2[start2 + k - 1]; }
        //若k = 1，直接返回两个数组最左侧元素中的最小值
        if (k == 1){ return Math.min(nums1[start1], nums2[start2]); }

        // 分别求两个数组的第k小数的位置，若数组长度不足K/2，则指向数组末尾
        int i = start1 + Math.min(length1, k/2) - 1;
        int j = start2 + Math.min(length2, k/2) - 1;

        if (nums1[i] > nums2[j]){
            // 说明第k小的数不会出现在nums2[start2...j]之间，排除掉这些元素
            // 排除掉了j - start2 + 1个元素，现在只需要找到第k - (j - start2 + 1)小的元素就ok
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }else {
            // 说明第k小的数不会出现在nums1[start1...i]之间，排除掉这些元素
            // 排除掉了i - start1 + 1个元素，现在只需要找到第k - (i - start1 + 1)小的元素就ok
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }
}
