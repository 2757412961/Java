package edu.zju.zjh.offer;

public class O0019 {

    /**
     * 递归 + 备忘录
     */
    private class S1 {

        int[][] memo = new int[128][128];

        public boolean isMatch(String s, int i, String p, int j) {
            if (i == s.length() && j == p.length()) return true;
            if (i < s.length() && j == p.length()) return false;
            if (i == s.length()) {
                while (j < p.length()) {
                    if (p.charAt(j) == '*') {
                        j++;
                    } else if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                        j += 2;
                    } else {
                        break;
                    }
                }
                return j == p.length();
            }

            if (memo[i][j] != 0) return memo[i][j] == 1;
            boolean res = false;
            if (j != p.length() - 1 && p.charAt(j + 1) == '*') {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    res = isMatch(s, i + 1, p, j + 2) || isMatch(s, i + 1, p, j) || isMatch(s, i, p, j + 2);
                } else {
                    res = isMatch(s, i, p, j + 2);
                }
            } else if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                res = isMatch(s, i + 1, p, j + 1);
            }
            memo[i][j] = res ? 1 : -1;

            return res;
        }

        public boolean isMatch(String s, String p) {
            return isMatch(s, 0, p, 0);
        }

    }

    /**
     * 动态规划
     */
    private class S2 {

        public boolean isMatch(String s, int i, String p, int j) {
            if (i == s.length() && j == p.length()) return true;
            if (i < s.length() && j == p.length()) return false;
            if (i == s.length()) {
                while (j < p.length()) {
                    if (p.charAt(j) == '*') {
                        j++;
                    } else if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                        j += 2;
                    } else {
                        break;
                    }
                }
                return j == p.length();
            }

            if (j != p.length() - 1 && p.charAt(j + 1) == '*') {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    return isMatch(s, i + 1, p, j + 2) || isMatch(s, i + 1, p, j) || isMatch(s, i, p, j + 2);
                } else {
                    return isMatch(s, i, p, j + 2);
                }
            }
            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                return isMatch(s, i + 1, p, j + 1);
            }

            return false;
        }

        public boolean isMatch(String s, String p) {
            return isMatch(s, 0, p, 0);
        }

    }

    /**
     * 二刷
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:41.2 MB,击败了13.53% 的Java用户
     */
    private class S3 {

        private int[][] memo;

        public boolean isMatch(String s, int i, String p, int j) {
            if (i == s.length() && j == p.length()) {
                return true;
            } else if (i < s.length() && j == p.length()) {
                return false;
            } else if (i == s.length() && j < p.length()) {
                while (j < p.length()) {
                    if (p.charAt(j) == '*') {
                        j += 1;
                    } else if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                        j += 2;
                    } else {
                        break;
                    }
                }
                return j == p.length();
            }

            if (memo[i][j] == 1) return true;
            if (memo[i][j] == -1) return false;
            boolean res = true;

            if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    res = isMatch(s, i + 1, p, j) || isMatch(s, i + 1, p, j + 2) || isMatch(s, i, p, j + 2);
                } else {
                    res = isMatch(s, i, p, j + 2);
                }
            } else {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    res = isMatch(s, i + 1, p, j + 1);
                } else {
                    return false;
                }
            }

            memo[i][j] = res ? 1 : -1;
            return res;
        }

        public boolean isMatch(String s, String p) {
            memo = new int[s.length()][p.length()];
            return isMatch(s, 0, p, 0);
        }

    }

    public static void main(String[] args) {
        System.out.println(new O0019().new S1().isMatch("a", "a*a"));
        System.out.println(new O0019().new S1().isMatch("bbba", ".*a*a"));
        System.out.println(new O0019().new S1().isMatch("ab", ".*c*"));
        System.out.println(new O0019().new S1().isMatch("ab", ".*c"));
        System.out.println(new O0019().new S1().isMatch("aab", "c*a*b"));
        System.out.println();
        System.out.println(new O0019().new S2().isMatch("a", "a*a"));
        System.out.println(new O0019().new S2().isMatch("bbba", ".*a*a"));
        System.out.println(new O0019().new S2().isMatch("ab", ".*c*"));
        System.out.println(new O0019().new S2().isMatch("ab", ".*c"));
        System.out.println(new O0019().new S2().isMatch("aab", "c*a*b"));
        System.out.println();
        System.out.println(new O0019().new S3().isMatch("a", "a*a"));
        System.out.println(new O0019().new S3().isMatch("bbba", ".*a*a"));
        System.out.println(new O0019().new S3().isMatch("ab", ".*c*"));
        System.out.println(new O0019().new S3().isMatch("ab", ".*c"));
        System.out.println(new O0019().new S3().isMatch("aab", "c*a*b"));
    }

}
