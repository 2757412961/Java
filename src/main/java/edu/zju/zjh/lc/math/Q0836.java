package edu.zju.zjh.lc.math;

/**
 * @author: zjh
 * @date : 2022/7/17 18:54
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0836 {

    /**
     * 方法一：检查位置
     * https://leetcode.cn/problems/rectangle-overlap/solution/tu-jie-jiang-ju-xing-zhong-die-wen-ti-zhuan-hua-we/
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.1 MB,击败了5.45% 的Java用户
     */
    private class S1 {

        public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
            if (rec2[0] >= rec1[2] || rec2[2] <= rec1[0]) return false;
            if (rec2[1] >= rec1[3] || rec2[3] <= rec1[1]) return false;
            return true;
        }

    }

    /**
     * 方法二：检查区域 / 计算面积
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.8 MB,击败了49.38% 的Java用户
     */
    private class S2 {

        public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
            int x = Math.min(rec1[2], rec2[2]) - Math.max(rec1[0], rec2[0]);
            int y = Math.min(rec1[3], rec2[3]) - Math.max(rec1[1], rec2[1]);
            return x > 0 && y > 0;
        }

    }

}
