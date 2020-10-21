package leetcode;

/**
 * 寻找两个正序数组的中位数
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 * 提示：
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class FindMedia {
    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {2, 3};
        double d = findMedianSortedArrays(nums1, nums2);
        System.out.println(d);
    }

    /**
     * 将两个数组合并，根据奇数还是偶数，返回中位数  --归并法
     * 注意：3/2=1；3/2.0=1.5
     * 时间复杂度O(m+n)，空间复杂度O(m+n)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int k = m + n;
        int[] nums = new int[m + n];
        //第一个数组为空,第二个数组的中位数就是整个数组的中位数，根据奇偶返回中位数
        if (m == 0) {
            //偶数个，返回中间两个的平均值
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {
                return nums2[n / 2];
            }
        }
        if (n == 0) {
            //偶数个，返回中间两个的平均值
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2;
            } else {
                return nums1[m / 2];
            }
        }
        int i = 0, j = 0, count = 0;
        while (count < k) {
            //若第一个数组遍历完，还剩第二个数组
            if (i == m) {
                while (j != n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if (j == n) {
                while (i != m) {
                    nums[count++] = nums1[i++];
                }
                break;
            }
            //若两个数组都不为空，先将小的存入数组
            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }
        if (count % 2 == 0) {
            return (nums[count / 2 - 1] + nums[count / 2]) / 2;
        } else {
            return nums[count / 2];
        }
    }

    /**
     * 不真的合并数组，找到中位数即可。len表示合并后数组的长度，len为奇数，中位数为第len/2+1；
     * len为偶数，中位数为第len/2和len/2+1，遍历到len/2+1即可。
     * 用left和right保存循环的结果，right表示现在循环结果，left表示上次循环结果。
     * a,b分别表示指向a，b数组起始的位置，a如果还没有到最后并且此时 A 位置的数字小于 B 位置的数组，那么就可以后移了。也就是a＜m&&A[a]< B[b]。
     * 但如果 B 数组此刻已经没有数字了，继续取数字 B[ b ]，则会越界，所以判断下 b 是否大于数组长度了，这样 || 后边的就不会执行了，也就不会导致错误了
     * 所以增加为 a＜m&&(b >= n||A[a]<B[b])
     * 时间复杂度O(m+n)，空间复杂度O(1)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int left = -1, right = -1;
        int a = 0, b = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (a < m && (b >= n || nums1[a] < nums2[b])) {
                right = nums1[a++];
            } else {
                right = nums2[b++];
            }
        }
        if (len % 2 == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }
}
