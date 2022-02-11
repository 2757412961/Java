package main.java.edu.zju.zjh.lcold;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/7/9 下午 12:50
 * @Modified_By :
 */
public class O1713 {
    public int respace(String[] dictionary, String sentence) {
        int n = sentence.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }

        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < dictionary.length; i++) {
            map.put(dictionary[i], true);
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (map.containsKey(sentence.substring(j, i))) {
                    dp[i] = Math.min(dp[i], dp[j]);
                } else {
                    dp[i] = Math.min(dp[i], dp[j] + i - j);
                }
            }
        }


        return dp[n];
    }

    public static void main(String[] args) {
//        输入：
//        dictionary = ["looked","just","like","her","brother"]
//        sentence = "jesslookedjustliketimherbrother"
//        输出： 7
//        解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。

        String[] dictionary = new String[5];
        dictionary[0] = "looked";
        dictionary[1] = "just";
        dictionary[2] = "like";
        dictionary[3] = "her";
        dictionary[4] = "brother";

        String sentence = "jesslookedjustliketimherbrother";

        System.out.println(new O1713().respace(dictionary, sentence));
    }
}
