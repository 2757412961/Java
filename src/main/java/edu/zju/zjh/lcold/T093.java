package edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T093 {
    String str;
    String ip;

    public String isLegal(int sta, int end) {
        String num = str.substring(sta, end);
        if (str.charAt(sta) == '0' && end - sta > 1) {
            return "";
        }

        if (Integer.parseInt(num) > 255) {
            return "";
        }

        ip = ip + num + ".";

        return num;
    }

    public List<String> restoreIpAddresses_violence(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        str = s;

        String temp;
        String temp2;
        for (int i = 1; i < Math.min(n, 4); i++) {
            ip = "";
            if (isLegal(0, i) == "") {
                break;
            }

            temp = ip;
            for (int j = i + 1; j < Math.min(n, i + 4); j++) {
                ip = temp;
                if (isLegal(i, j) == "") {
                    break;
                }

                temp2 = ip;
                for (int k = j + 1; k < Math.min(n, j + 4); k++) {
                    ip = temp2;
                    if (isLegal(j, k) == "") {
                        break;
                    }
                    if (n - k > 3) {
                        continue;
                    }
                    if (isLegal(k, n) == "") {
                        continue;
                    }
                    res.add(ip.substring(0, n + 3));
                }
            }
        }

        return res;
    }


    List<String> ans = new ArrayList<>();

    public void judge(List<String> res) {
        if (res.size() != 4) return;

        String join = "";
        for (int i = 0; i < res.size(); i++) {
            String resstr = res.get(i);

            if (resstr.length() <= 0 || resstr.length() > 3) return;
            if (resstr.length() > 1 && resstr.charAt(0) == '0') return;
            if (Integer.valueOf(resstr) > 255) return;

            join += "." + resstr;
        }

        ans.add(join.substring(1));
    }

    public void hs(String s, int idx, List<String> res) {
        if (idx > s.length() || res.size() > 4) return;
        if (res.size() == 3) {
            res.add(s.substring(idx));
            judge(res);
            res.remove(res.size() - 1);
            return;
        }

        for (int i = 1; i <= 3 && idx + i <= s.length(); i++) {
            res.add(s.substring(idx, idx + i));
            hs(s, idx + i, res);
            res.remove(res.size() - 1);
        }

    }


    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();

        hs(s, 0, res);
        return ans;
    }


    public static void main(String[] args) {
//        String s = "25525511135";
//        输出: ["255.255.11.135", "255.255.111.35"]
//        String s = "010010";
//        String s = "101023";
        String s = "0279245587303";

        System.out.println(Arrays.toString(new T093().restoreIpAddresses(s).toArray()));
        System.out.println(Arrays.toString(new T093().restoreIpAddresses_violence(s).toArray()));
    }
}
