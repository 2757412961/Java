package edu.zju.lemon;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author: zjh
 * @date : 2022/6/10 15:51
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0698 {

    class Solution1 {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            if (k == 1) return true;
            if (nums.length == 1 && k > 1) return false;
            Arrays.sort(nums);
            int len = nums.length;
            int max = nums[len - 1];
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % k != 0) return false;
            int avr = sum / k;
            if (max > avr) return false;

            return dfs(0, len - 1, nums, k, avr);
        }

        boolean dfs(int start, int end, int[] nums, int k, int avr) {
            while (k < 0) return true;
            while (start > end) return false;
            int sum = nums[end];
            if (sum == avr) {
                if (start < end)
                    dfs(start, end--, nums, k--, avr);
            }
            while (sum < avr && start < end) {
                sum += nums[start];
                start++;
            }
            if (start == end) return false;

            if (sum + nums[start] == avr) {
                if (start < end)
                    dfs(start++, end--, nums, k--, avr);
            } else {
                return false;
            }
            return true;
        }
    }

    class Solution2 {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            // 排除一些基本情况
            if (k > nums.length) return false;
            int sum = 0;
            for (int v : nums) sum += v;
            if (sum % k != 0) return false;

            int used = 0; // 使用位图技巧
            int target = sum / k;
            // k 号桶初始什么都没装，从 nums[0] 开始做选择
            return backtrack(k, 0, nums, 0, used, target);
        }

        HashMap<Integer, Boolean> memo = new HashMap<>();

        boolean backtrack(int k, int bucket,
                          int[] nums, int start, int used, int target) {
            // base case
            if (k == 0) {
                // 所有桶都被装满了，而且 nums 一定全部用完了
                return true;
            }
            if (bucket == target) {
                // 装满了当前桶，递归穷举下一个桶的选择
                // 让下一个桶从 nums[0] 开始选数字
                boolean res = backtrack(k - 1, 0, nums, 0, used, target);
                // 缓存结果
                memo.put(used, res);
                return res;
            }

            if (memo.containsKey(used)) {
                // 避免冗余计算
                return memo.get(used);
            }

            for (int i = start; i < nums.length; i++) {
                // 剪枝
                if (((used >> i) & 1) == 1) { // 判断第 i 位是否是 1
                    // nums[i] 已经被装入别的桶中
                    continue;
                }
                if (nums[i] + bucket > target) {
                    continue;
                }
                // 做选择
                used |= 1 << i; // 将第 i 位置为 1
                bucket += nums[i];
                // 递归穷举下一个数字是否装入当前桶
                if (backtrack(k, bucket, nums, i + 1, used, target)) {
                    return true;
                }
                // 撤销选择
                used ^= 1 << i; // 将第 i 位置为 0
                bucket -= nums[i];
            }

            return false;
        }
    }

}
