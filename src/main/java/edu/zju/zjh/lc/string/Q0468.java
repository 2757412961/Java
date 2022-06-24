package edu.zju.zjh.lc.string;

/**
 * @author: zjh
 * @date : 2022/6/24 上午 10:07
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0468 {

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.4 MB,击败了61.79% 的Java用户
     */
    public String validIPAddress(String queryIP) {
        if (queryIP.contains(".")) {
            //加-1是防止出现空字符串无法计数 比如192.168.1.1. 后边多了一个点，不加-1会被忽略后边的空串
            String[] items = queryIP.split("\\.", -1);
            if (items.length != 4) return "Neither";

            for (String item : items) {
                //每个长度不在 1-3之间
                if (item.length() == 0 || item.length() > 3) return "Neither";
                //有前导0 并且长度不为1
                if (item.length() != 1 && item.charAt(0) == '0') return "Neither";

                //计算数字
                int sum = 0;
                for (int i = 0; i < item.length(); i++) {
                    char c = item.charAt(i);
                    if (!Character.isDigit(c)) return "Neither";
                    sum = sum * 10 + c - '0';
                }

                //数字超过255
                if (sum > 255) return "Neither";
            }

            return "IPv4";
        }

        if (queryIP.contains(":")) {
            //加-1是防止出现空字符串无法计数 比如192.168.1.1. 后边多了一个点，不加-1会被忽略后边的空串
            String[] items = queryIP.split(":", -1);
            if (items.length != 8) return "Neither";

            for (String item : items) {
                if (item.length() == 0 || item.length() > 4) return "Neither";

                for (int i = 0; i < item.length(); i++) {
                    char c = item.charAt(i);
                    if (Character.isDigit(c) || ('A' <= c && c <= 'F') || ('a' <= c && c <= 'f')) continue;
                    return "Neither";
                }
            }

            return "IPv6";
        }

        return "Neither";
    }

}
