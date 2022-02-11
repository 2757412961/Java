package main.java.edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/8/1 下午 09:08
 * @Modified_By :
 */
public class T632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        int stas[] = new int[k];

        int gmin = 0;
        int gmax = Integer.MAX_VALUE ;

        while (true) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int mini = 0;

            for (int i = 0; i < k; i++) {
                int num = nums.get(i).get(stas[i]);
                if (num < min) {
                    min = num;
                    mini = i;
                }

                if (num > max) {
                    max = num;
                }
            }

            if (max - min < gmax - gmin) {
                gmax = max;
                gmin = min;
            }

            stas[mini]++;
            if (stas[mini] >= nums.get(mini).size()) {
                break;
            }
        }

        return new int[]{gmin, gmax};
    }

    public static void main(String[] args) {
//        你有 k 个升序排列的整数数组。找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
//
//        我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
//
//        示例 1:
//        输入:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
//        输出: [20,24]
//        解释:
//        列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
//        列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
//        列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。

        List<Integer> temp;
        List<List<Integer>> nums = new ArrayList<>();

        temp = new ArrayList<>();
        temp.add(4);
        temp.add(10);
        temp.add(15);
        temp.add(24);
        temp.add(26);
        nums.add(temp);

        temp = new ArrayList<>();
        temp.add(0);
        temp.add(9);
        temp.add(12);
        temp.add(20);
        nums.add(temp);

        temp = new ArrayList<>();
        temp.add(5);
        temp.add(18);
        temp.add(22);
        temp.add(30);
        nums.add(temp);


        System.out.println(Arrays.toString(new T632().smallestRange(nums)));
    }
}
