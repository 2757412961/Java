package edu.zju.zjh.lc.offer;

/**
 * @author: zjh
 * @date : 2022/4/15 下午 07:59
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0058_II {

    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }

}
