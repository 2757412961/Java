package edu.zju.zjh.lcold;

public class T275 {
    public int hIndex(int[] citations) {
        int res;
        int n = citations.length;

        for (res = n; res > 0; res--) {
            int index = n - res;
            if (citations[index] >= res) {
                if (index - 1 >= 0 && citations[index - 1] < res) {
                    return res;
                } else {
                    return res;
                }

            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] citations = new int[]{0, 1, 3, 5, 6};

        System.out.println(new T275().hIndex(citations));
    }
}
