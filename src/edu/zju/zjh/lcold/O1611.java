package edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/7/8 下午 06:06
 * @Modified_By :
 */
public class O1611 {
    public int[] divingBoard_official(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        int[] lengths = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            lengths[i] = shorter * (k - i) + longer * i;
        }
        return lengths;
    }

    public int[] divingBoard(int shorter, int longer, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        int last = 0;

        for (int i = 0; i < k + 1; i++) {
            int len = longer * i + shorter * (k - i);
            if (len != last) {
                res.add(len);
            }
            last = len;
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }

    public static void main(String[] args) {
//        int shorter = 1;
//        int longer = 2;
//        int k = 3;
        int shorter = 1;
        int longer = 1;
        int k = 100;

        System.out.println(Arrays.toString(new O1611().divingBoard(shorter, longer, k)));
        System.out.println(Arrays.toString(new O1611().divingBoard_official(shorter, longer, k)));
    }
}
