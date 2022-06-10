package edu.zju.zjh.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: zjh
 * @date : 2022/3/5 9:54
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0038 {

    private List<String> res = new ArrayList<>();
    private StringBuilder path = new StringBuilder();
    private boolean[] used;

    private void backTrack(char[] chars) {
        if (path.length() == chars.length) {
            res.add(path.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (used[i] == false) {
                if (i > 0 && chars[i] == chars[i - 1] && used[i - 1] == false) {
                    continue;
                }
                used[i] = true;
                path.append(chars[i]);
                backTrack(chars);
                path.deleteCharAt(path.length() - 1);
                used[i] = false;
            }
        }
    }

    public String[] permutation(String s) {
        used = new boolean[s.length()];
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        backTrack(chars);

        return res.toArray(new String[0]);
    }

}
