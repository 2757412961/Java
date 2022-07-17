package edu.zju.zjh.topk.microsoft.d20220715;

/**
 * @author: zjh
 * @date : 2022/7/15 下午 07:22
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q002 {

    // Remember, all submissions are being checked for plagiarism.
    // Your recruiter will be informed in case suspicious activity is detected.

    // you can also use imports, for example:
    // import java.util.*;

    // you can write to stdout for debugging purposes, e.g.
    // System.out.println("this is a debug message");

    //class Solution {
    //    public int solution(int[] blocks) {
    //        // write your code in Java SE 8
    //        int res = 1, lastPeek, thisPeek;
    //
    //        lastPeek = 0;
    //        thisPeek = 0;
    //        for (int i = 1; i < blocks.length; i++) {
    //            if (blocks[i - 1] <= blocks[i]) {
    //                res = Math.max(res, i - lastPeek + 1);
    //                thisPeek = i;
    //            } else {
    //                lastPeek = thisPeek;
    //                res = Math.max(res, i - lastPeek + 1);
    //            }
    //        }
    //
    //        lastPeek = blocks.length - 1;
    //        thisPeek = blocks.length - 1;
    //        for (int i = blocks.length - 2; i >= 0; i--) {
    //            if (blocks[i] >= blocks[i + 1]) {
    //                res = Math.max(res, lastPeek - i + 1);
    //                thisPeek = i;
    //            } else {
    //                lastPeek = thisPeek;
    //                res = Math.max(res, lastPeek - i + 1);
    //            }
    //        }
    //
    //        return res;
    //    }
    //}

    class Solution {
        public int solution(int[] blocks) {
            // write your code in Java SE 8
            int res = 1, cnt;
            int trend = 0;

            for (int i = 0; i < blocks.length; i++) {
                cnt = 1;
                int l = i, r = i;

                while (l > 0 && blocks[l - 1] >= blocks[l]) {
                    l--;
                    cnt++;
                }
                while (r < blocks.length - 1 && blocks[r] <= blocks[r + 1]) {
                    r++;
                    cnt++;
                }

                res = Math.max(res, cnt);
            }

            return res;
        }
    }

    /**
     * 计算以i为起点，向左和向右分别能跳多少步，两者相加再加1就是从该点初始的最远距离。
     * 所有的最远距离取最大值即为结果。
     * # Remember, all submissions are being checked for plagiarism.
     * # Your recruiter will be informed in case suspicious activity is detected.
     *
     * # you can write to stdout for debugging purposes, e.g.
     * # print("this is a debug message")
     *
     * def solution(blocks):
     *     # Task: find the longest possible distance between two frogs
     *     # Limit: N <= 2*10^5, blocks[i] <= 1*10^9
     *
     *     # Method: starting from each block[i], find the longest steps jumping to the left, and the longest steps to the right.
     *     #         Add them together and add one. The longest will be the answer
     *     # Time Complexity: O(n)
     *     # Space Complexity: O(n). I'm not sure if there exists a method with more efficient space complexity.
     *
     *     n = len(blocks)
     *
     *     # step1: find the longest steps jumping to the left
     *     # `jump_to_left[i]` means how many steps the frog can jump to the left
     *     jump_to_left = [0] * n
     *     sum_ = 0
     *     for i in range(1, n):
     *         # the current block is no higher than the left one
     *         if blocks[i] <= blocks[i - 1]:
     *             # can jump one more block
     *             sum_ += 1
     *             jump_to_left[i] = sum_
     *         else:
     *             sum_ = 0
     *
     *     # step2: find the longest steps jumping to the right
     *     # `jump_to_right[i]` means how many steps the frog can jump to the right
     *     jump_to_right = [0] * n
     *     sum_ = 0
     *     for i in range(n-2, -1, -1):
     *         # the current block is no higher than the right one
     *         if blocks[i] <= blocks[i + 1]:
     *             # can jump one more block
     *             sum_ += 1
     *             jump_to_right[i] = sum_
     *         else:
     *             sum_ = 0
     *
     *     # step3: find the longest distance between the two frogs
     *     res = 0
     *     for i in range(n):
     *         res = max(res, jump_to_left[i] + jump_to_right[i] + 1)
     *
     *     return res
     *
     *
     * blocks = [2, 6, 8, 5]
     * # blocks = [1, 5, 5, 2, 6]
     * # blocks = [1, 1]
     * # blocks = [1]
     * # blocks = [1, 2, 3]
     * # blocks = [3, 4, 1, 6, 5, 2, 7]
     *
     *
     * res = solution(blocks)
     * print(res)
     */


}
