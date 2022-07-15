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


}
