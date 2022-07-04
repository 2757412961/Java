package edu.zju.zjh.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: zjh
 * @date : 2022/4/15 下午 04:22
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0057_II {

    /**
     * 方法三：双指针
     * 如果 sum<target 则说明指针 r 还可以向右拓展使得 sum 增大，此时指针 r 向右移动，即 r+=1
     * 如果 sum>target 则说明以 l 为起点不存在一个 r 使得 sum=target，此时要枚举下一个起点，指针 l 向右移动，即 l+=1
     * 如果 sum==target 则说明我们找到了以 l 为起点得合法解 [l,r]，我们需要将 [l,r] 的序列放进答案数组，且我们知道以 l 为起点的合法解最多只有一个，所以需要枚举下一个起点，指针 l 向右移动，即 l+=1
     */
    private class S1 {

        public int calSum(int i, int j) {
            return (i + j) * (j - i + 1) / 2;
        }

        public int[][] findContinuousSequence(int target) {
            List<int[]> res = new ArrayList<>();
            int l = 1, r = 2;

            while (l < r) {
                int sum = calSum(l, r);
                if (sum > target) {
                    l++;
                } else if (sum < target) {
                    r++;
                } else if (sum == target) {
                    int[] a = new int[r - l + 1];
                    for (int i = l; i <= r; i++) {
                        a[i - l] = i;
                    }
                    res.add(a);
                    l++;
                }
            }

            return res.toArray(new int[0][0]);
        }

    }

    /**
     * 二刷
     * 执行耗时:2 ms,击败了94.60% 的Java用户
     * 内存消耗:39.2 MB,击败了85.96% 的Java用户
     */
    private class S2 {

        public int[][] findContinuousSequence(int target) {
            if (target == 1) return new int[0][0];
            int l = 1, r = 1, sum = 1, limit = (target + 1) / 2;
            List<int[]> res = new LinkedList<>();

            while (r <= limit) {
                if (sum == target) {
                    int[] arr = new int[r - l + 1];
                    for (int i = 0; i < arr.length; i++) {
                        arr[i] = l + i;
                    }
                    res.add(arr);
                    sum -= l;
                    l++;
                } else if (sum > target) {
                    sum -= l;
                    l++;
                } else if (sum < target) {
                    r++;
                    sum += r;
                }
            }

            return res.toArray(new int[0][0]);
        }

    }

    public static void main(String[] args) {
        new O0057_II().new S1().findContinuousSequence(1);
        new O0057_II().new S1().findContinuousSequence(15);

        new O0057_II().new S2().findContinuousSequence(1);
        new O0057_II().new S2().findContinuousSequence(15);
    }

}
