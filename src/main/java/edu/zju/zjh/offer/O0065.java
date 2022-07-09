package edu.zju.zjh.offer;

/**
 * @author: zjh
 * @date : 2022/4/25 10:13
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0065 {

    /**
     *
     */
    private class S1 {

        public int add(int a, int b) {
            while (b != 0) {
                int c = a & b;
                a = a ^ b;
                b = c << 1;
            }

            return a;
        }

    }

    /**
     * 二刷 Wrong
     */
    private class S2 {

//        public int add(int a, int b) {
//            int res = 0;
//            int bit = 1, limit = 1 << 31, carry = 0;
//
//            while (true) {
//                int ra = a & bit;
//                int rb = b & bit;
//
//                if (ra != 0 && rb != 0) {
//                    if (carry != 0) {
//                        ra = res | bit;
//                        ra = rb = bit;
//                    } else {
//                        ra = rb = bit;
//                    }
//                } else if (ra != 0 && rb == 0 || ra == 0 && rb != 0) {
//                    if (carry != 0) {
//                        ra = rb = bit;
//                    } else {
//                        res = res | bit;
//                    }
//                } else if (ra == 0 && rb == 0) {
//                    res = res | carry;
//                }
//
//                bit = bit << 1;
//                carry = (ra & rb) << 1;
//                if (bit == limit) break;
//            }
//
//            return res;
//        }

    }

    /**
     * 二刷
     * 无进位和 与 异或运算 规律相同，进位 和 与运算 规律相同（并需左移一位）
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.5 MB,击败了8.72% 的Java用户
     */
    private class S3 {

        public int add(int a, int b) {
            int xor = 0, carry = 0;

            while (b != 0) {
                xor = a ^ b;
                carry = a & b;

                a = xor;
                b = carry << 1;
            }

            return a;
        }

    }

}
