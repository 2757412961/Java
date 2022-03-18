package edu.zju.zjh.lc.doublepointer.slidingwindow;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author: zjh
 * @date : 2022/3/18 16:48
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Object CON = new Object();
        TreeMap<Long, Object> map = new TreeMap<>();

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (i > k) {
                map.remove((long) nums[i - k - 1]);
            }
            Long ceilingKey = map.ceilingKey((long) n);
            Long floorKey = map.floorKey((long) n);
            if (map.size() > 0 && ceilingKey != null && ceilingKey - n <= t) {
                return true;
            }
            if (map.size() > 0 && floorKey != null && n - floorKey <= t) {
                return true;
            }

            map.put((long) nums[i], CON);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Q0220().containsNearbyAlmostDuplicate(new int[]{1, 2, 1, 1}, 1, 0));
        System.out.println(new Q0220().containsNearbyAlmostDuplicate(new int[]{4, 1, 6, 3}, 100, 1));
        System.out.println(new Q0220().containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
        System.out.println(new Q0220().containsNearbyAlmostDuplicate(new int[]{-2147483648, 2147483647}, 1, 1));
    }
}
