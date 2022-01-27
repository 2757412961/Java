package edu.zju.zjh.lcold;

import java.util.*;

public class T1338 {
    public int minSetSize(int[] arr) {
        int res = 0;
        int sum = 0;
        int n = (arr.length + 1) / 2;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        ArrayList<Integer> vals = new ArrayList<>(map.values());
        Collections.sort(vals);
        Collections.reverse(vals);

        for (int i=0;i<vals.size(); i++){
            sum += vals.get(i);
            res++;
            if (sum>=n){
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 3, 5, 5, 5, 2, 2, 7};

        T1338 t1338 = new T1338();
        System.out.println(t1338.minSetSize(arr));
    }
}
