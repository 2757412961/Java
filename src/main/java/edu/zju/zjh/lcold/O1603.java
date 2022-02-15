package edu.zju.zjh.lcold;

public class O1603 {
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        double[] res = new double[0];
//        int x1 = Math.min(start1[0], end1[0]), x2 = Math.max(start1[0], end1[0]);
//        int x3 = Math.min(start2[0], end2[0]), x4 = Math.max(start2[0], end2[0]);
//        int y1 = Math.min(start1[1], end1[1]), y2 = Math.max(start1[1], end1[1]);
//        int y3 = Math.min(start2[1], end2[1]), y4 = Math.max(start2[1], end2[1]);
        int x1 = start1[0], x2 = end1[0], x3 = start2[0], x4 = end2[0];
        int y1 = start1[1], y2 = end1[1], y3 = start2[1], y4 = end2[1];

        int delX1 = x2 - x1;
        int delY1 = y2 - y1;
        int delX2 = x4 - x3;
        int delY2 = y4 - y3;

        if (delX1 == 0 && delX2 == 0) {
            if (x1 == x3) {
                if (Math.max(y1, y2) < Math.min(y3, y4) || Math.max(y3, y4) < Math.min(y1, y2)) {

                } else {
                    res = new double[2];
                    res[0] = x1;
                    res[1] = Math.max(Math.min(y1, y2), Math.min(y3, y4));
                }
            }
        } else if (delX1 == 0 && delX2 != 0) {
            if (Math.min(x3, x4) <= x1 && x1 <= Math.max(x3, x4)) {
                double insectY = 1.0 * delY2 / delX2 * (x1 - x3) + y3;
                if (Math.min(y1, y2) <= insectY && insectY <= Math.max(y1, y2)) {
                    res = new double[2];
                    res[0] = x1;
                    res[1] = insectY;
                }
            }
        } else if (delX1 != 0 && delX2 == 0) {
            if (Math.min(x1, x2) <= x3 && x3 <= Math.max(x1, x2)) {
                double insectY = 1.0 * delY1 / delX1 * (x3 - x1) + y1;
                if (Math.min(y3, y4) <= insectY && insectY <= Math.max(y3, y4)) {
                    res = new double[2];
                    res[0] = x3;
                    res[1] = insectY;
                }
            }
        } else {
            double k12 = 1.0 * delY1 / delX1;
            double k34 = 1.0 * delY2 / delX2;
            double b12 = y1 - k12 * x1;
            double b34 = y3 - k34 * x3;
            if (delY1 * delX2 != delY2 * delX1) {
                double insectX = (b12 - b34) / (k34 - k12);
                if (Math.min(x1, x2) <= insectX && insectX <= Math.max(x1, x2) && Math.min(x3, x4) <= insectX && insectX <= Math.max(x3, x4)) {
                    res = new double[2];
                    res[0] = insectX;
                    res[1] = k12 * insectX + b12;
                }
            } else {
                if (Math.abs(k12 * x3 + b12 - y3) < 1e-6) {
                    if (Math.max(y1, y2) < Math.min(y3, y4) || Math.max(y3, y4) < Math.min(y1, y2)) {

                    } else {
                        res = new double[2];
                        res[0] = Math.max(Math.min(x1, x2), Math.min(x3, x4));
                        res[1] = Math.max(Math.min(y1, y2), Math.min(y3, y4));
                    }
                }
            }
        }


        return res;
    }

    public static void main(String[] args) {
//        int[] start1 = new int[]{0, 0};
//        int[] end1 = new int[]{1, 1};
//        int[] start2 = new int[]{0, 1};
//        int[] end2 = new int[]{1, 0};

//        int[] start1 = new int[]{0, 1};
//        int[] end1 = new int[]{1, 0};
//        int[] start2 = new int[]{2, 0};
//        int[] end2 = new int[]{0, 2};

//        int[] start1 = new int[]{0, 0};
//        int[] end1 = new int[]{1, -1};
//        int[] start2 = new int[]{0, 0};
//        int[] end2 = new int[]{-1, 1};

        int[] start1 = new int[]{-10, 48};
        int[] end1 = new int[]{-43, 46};
        int[] start2 = new int[]{-16, 59};
        int[] end2 = new int[]{-1 ,85};


//        若有多个交点（线段重叠）则返回 X 值最小的点，X 坐标相同则返回 Y 值最小的点
        new O1603().intersection(start1, end1, start2, end2);
    }
}
