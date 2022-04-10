package edu.zju.zjh.lc.offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: zjh
 * @date : 2022/4/8 下午 09:35
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0033 {

    private Map<Integer, Integer> map = new HashMap<>();

    public boolean testTree(int[] inorder, int ins, int ine, int[] postorder, int pos, int poe) {
        if (ins > ine || pos > poe) return true;

        int val = postorder[poe];
        int inidx = map.get(val);

        if (inidx < ins || ine < inidx) return false;
        int lenLeft = inidx - ins;
        int lenRight = ine - inidx;

        return testTree(inorder, ins, inidx - 1, postorder, pos, pos + lenLeft - 1) &&
                testTree(inorder, inidx + 1, ine, postorder, poe - lenRight, poe - 1);
    }

    public boolean verifyPostorder(int[] postorder) {
        int[] inorder = Arrays.copyOf(postorder, postorder.length);
        Arrays.sort(inorder);

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return testTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public static void main(String[] args) {
        System.out.println(new O0033().verifyPostorder(new int[]{7, 4, 6, 5}));
        System.out.println(new O0033().verifyPostorder(new int[]{1, 2, 5, 10, 6, 9, 4, 3}));
        System.out.println(new O0033().verifyPostorder(new int[]{4, 8, 6, 12, 16, 14, 10}));
    }

}
