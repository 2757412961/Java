package edu.zju.zjh.lcold;

import java.util.ArrayList;

public class T556 {
    public int nextGreaterElement(int n) {
        ArrayList<Integer> els = new ArrayList<>();

        if (n > 999999999) return -1;

        while (n > 0) {
            els.add(n % 10);
            n /= 10;
        }

        for (int i = 1; i < els.size(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (els.get(i) < els.get(j)) {
                    int minIndex = j;
                    for (int k = 0; k < i; k++) {
                        if (els.get(minIndex) > els.get(k) && (els.get(k) > els.get(i))) {
                            minIndex = k;
                        }
                    }
                    int temp = els.get(i);
                    els.set(i, els.get(minIndex));
                    els.set(minIndex, temp);

                    for (int ri = 0; ri < i; ri++) {
                        int maxIndex = ri;
                        for (int rj = ri + 1; rj < i; rj++) {
                            if (els.get(rj) > els.get(maxIndex)) {
                                maxIndex = rj;
                            }
                        }

                        int tempR = els.get(ri);
                        els.set(ri, els.get(maxIndex));
                        els.set(maxIndex, tempR);
                    }

                    int res = 0;
                    for (int z = els.size() - 1; z >= 0; z--) {
                        res = res * 10 + els.get(z);
                    }
                    return res;
                }
            }
        }

        return -1;
    }

    public int nextGreaterElementSimple(int n) {

        return -1;
    }


    public static void main(String[] args) {
        T556 t556 = new T556();
        System.out.println(t556.nextGreaterElement(1999999999));
    }
}
