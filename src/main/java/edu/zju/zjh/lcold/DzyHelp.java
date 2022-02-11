package main.java.edu.zju.zjh.lcold;

import java.util.Arrays;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/6/22 下午 07:14
 * @Modified_By :
 */
public class DzyHelp {

    public int[] test(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        int[] left;
        int[] righ;
        if (n % 2 == 0) {
            left = new int[n / 2];
            righ = new int[n / 2];
        } else {
            left = new int[n / 2 + 1];
            righ = new int[n / 2];
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j < left.length) left[j] = nums[j];
                else righ[j - left.length] = nums[j];
            }

            int l = left.length - 1;
            int r = righ.length - 1;
            int nl = nums.length - 1;
            Boolean flag = true;
            if (i % 2 == 0) {
                while (nl >= 0) {
                    if (flag) {
                        res[nl--] = left[l--];
                    } else {
                        res[nl--] = righ[r--];
                    }

                    flag = !flag;
                }
            } else {
                while (nl >= 0 && r >= 0) {
                        if (flag) {
                        res[nl--] = righ[r--];
                    } else {
                        res[nl--] = left[l--];
                    }

                    flag = !flag;
                }
                while (nl >= 0 && l >= 0){
                    res[nl--] = left[l--];
                }
            }
            nums = res;
        }

        return res;
    }


    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
//        int k = 2;
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 2;

        System.out.println(Arrays.toString(new DzyHelp().test(nums, k)));
    }
}
