package edu.zju.lemon.bit;

/**
 * @author: zjh
 * @date : 2022/4/22 19:10
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q001 {

    public static boolean isUnique(String astr) {
        int[] aa = new int[32];
        int cc = 1; // 这个变量只是为了移位操作，没啥意义可以用1代替
        for (int i = 0; i < astr.length(); i++) {
            char t = astr.charAt(i);
            int offset = t - 'a';

            int bb = offset;
            if (aa[bb] != 0) {
                return false;
            }

            aa[bb] = 1;
        }

        return true;
    }

}
