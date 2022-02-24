package edu.zju.zjh.lc.fs.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: zjh
 * @date : 2022/2/21 20:00
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0838 {

    public String pushDominoesFail(String dominoes) {
        int n = dominoes.length();
        int[] find = new int[n];
        char[] res = new char[n];
        Queue<Integer> que = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            char ch = dominoes.charAt(i);
            if (ch != '.') {
                que.offer(i);
                res[i] = ch;
                find[i] = 1;
            } else {
                res[i] = '.';
            }
        }

        while (!que.isEmpty()) {
            int pos = que.poll();
            char ch = res[pos];
            find[pos] = 1;

            if (ch == 'L' && pos >= 1) {
//                if (find[pos - 1] == 0) {
                if (res[pos - 1] == '.') {
                    find[pos] = 1;
                    if (pos - 2 >= 1 && find[pos - 2] == 1 && res[pos - 2] == 'R') {
                        continue;
                    }
                    res[pos - 1] = ch;
                    que.offer(pos - 1);
                }
//                    else if (res[pos - 1] == 'R') {
//                        res[pos - 1] = '.';
//                        find[pos - 1] = 1;
//                    }
//                }
            } else if (ch == 'R' && pos <= n - 2) {
//                if (find[pos + 1] == 0) {
                if (res[pos + 1] == '.') {
                    find[pos] = 1;
                    if (pos + 2 <= n - 2 && find[pos + 2] == 1 && res[pos + 2] == 'L') {
                        continue;
                    }
                    res[pos + 1] = ch;
                    que.offer(pos + 1);
                }
//                    else if (res[pos + 1] == 'L') {
//                        res[pos + 1] = '.';
//                        find[pos + 1] = 1;
//                    }
//                }
            } else {

            }
        }


        return new String(res);
    }

    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] find = new int[n];
        char[] res = new char[n];
        Queue<Integer> que = new LinkedList<>();
        Queue<Integer> quefind = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            char ch = dominoes.charAt(i);
            if (ch != '.') {
                que.offer(i);
                res[i] = ch;
                find[i] = 1;
            } else {
                res[i] = '.';
            }
        }

        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int pos = que.poll();
                char ch = res[pos];

                if (ch == 'L' && pos >= 1) {
                    if (find[pos - 1] == 0) {
                        if (res[pos - 1] == '.') {
                            res[pos - 1] = ch;
                            que.offer(pos - 1);
                            quefind.offer(pos - 1);
                        } else if (res[pos - 1] == 'R') {
                            res[pos - 1] = '.';
                            quefind.offer(pos - 1);
                        }
                    }
                } else if (ch == 'R' && pos <= n - 2) {
                    if (find[pos + 1] == 0) {
                        if (res[pos + 1] == '.') {
                            res[pos + 1] = ch;
                            que.offer(pos + 1);
                            quefind.offer(pos + 1);
                        } else if (res[pos + 1] == 'L') {
                            res[pos + 1] = '.';
                            quefind.offer(pos + 1);
                        }
                    }
                }
            }

            while (!quefind.isEmpty()) {
                int pos = quefind.poll();
                find[pos] = 1;
            }
        }

        return new String(res);
    }

    public static void main(String[] args) {
        System.out.println(".L.RR.LLRRLL..");
        System.out.println(new Q0838().pushDominoes(".L.RR.LLRRLL.."));
        System.out.println("..R..");
        System.out.println(new Q0838().pushDominoes("..R.."));
        System.out.println(".L.R...LR..L..");
        System.out.println(new Q0838().pushDominoes(".L.R...LR..L.."));
        System.out.println(".L.R...LR..L..");
        System.out.println(new Q0838().pushDominoes(".L.R...LR..L.."));
    }

}
