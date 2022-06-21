package edu.zju.zjh.lc.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: zjh
 * @date : 2022/5/27 19:30
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0041 {

    /**
     * 方法一：哈希表 打标记
     */

    /**
     * 方法二：置换
     * 执行耗时:2 ms,击败了94.74% 的Java用户
     * 内存消耗:97.4 MB,击败了24.97% 的Java用户
     * <p>
     * 可以使用置换的方法，将给定的数组「恢复」成下面的形式：
     * 如果数组中包含 x∈[1,N]，那么恢复后，数组的第 x−1 个元素为 x。
     * 时间复杂度：O(N)
     */
    private class S2 {

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public int firstMissingPositive(int[] nums) {
            // 在恢复后，数组应当有 [1, 2, ..., N] 的形式，但其中有若干个位置上的数是错误的，每一个错误的位置就代表了一个缺失的正数。
            // 以题目中的示例二 [3, 4, -1, 1] 为例，恢复后的数组应当为 [1, -1, 3, 4]，我们就可以知道缺失的数为 2。
            int n = nums.length;
            for (int i = 0; i < nums.length; i++) {
                // 把数字移动到正确的位置，不断检测新的数值
                while (1 <= nums[i] && nums[i] <= n) {
                    // 判断置换位置是否已经正确
                    if (nums[nums[i] - 1] == nums[i]) {
                        break;
                    }
                    swap(nums, i, nums[i] - 1);
                }
            }

            int idx = 0;
            while (idx < n) {
                // 判断下标和数值是否对应
                if (nums[idx] != idx + 1) {
                    return idx + 1;
                }
                idx++;
            }

            return idx + 1;
        }

    }

    /**
     * 二刷
     * 执行耗时:2 ms,击败了94.57% 的Java用户
     * 内存消耗:97.1 MB,击败了56.18% 的Java用户
     */
    private class S3 {

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public int firstMissingPositive(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (0 < nums[i] && nums[i] <= n) {
                    int pos = nums[i] - 1;
                    if (nums[pos] != pos + 1) {
                        swap(nums, i, pos);
                        i--;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }

            return n + 1;
        }

    }

}
