package main.java.edu.zju.zjh.lcold;

import java.util.*;

public class T347 {
    Map<Integer, Integer> mapCount = new HashMap<>();
    List<Integer> minheap = new ArrayList<>();

    public void swap(int a, int b) {
        int temp = minheap.get(a);
        minheap.set(a, minheap.get(b));
        minheap.set(b, temp);
    }

    public Integer getCount(int index) {
        return mapCount.get(minheap.get(index));
    }

    public void heapify(int index) {
        int leftC = 2 * index + 1;
        int rightC = 2 * index + 2;
        int change = index;
        if (leftC < minheap.size() && getCount(leftC) < getCount(change)) {
            change = leftC;
        }
        if (rightC < minheap.size() && getCount(rightC) < getCount(change)) {
            change = rightC;
        }
        if (change == index) {
            return;
        }
        swap(index, change);
        heapify(change);
    }

    public List<Integer> topKFrequent_20200907(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            if (mapCount.containsKey(nums[i])) {
                mapCount.put(nums[i], 1 + mapCount.get(nums[i]));
            } else {
                mapCount.put(nums[i], 1);
            }
        }

        mapCount.put(-111111, 0);
        for (int i = 0; i < k; i++) {
            minheap.add(-111111);
        }

        Object[] keys = mapCount.keySet().toArray();
        for (int i = 0; i < keys.length; i++) {
            if (mapCount.get((int) keys[i]) > mapCount.get(minheap.get(0))) {
                minheap.set(0, (int) keys[i]);
                heapify(0);
            }
        }

        return minheap;
    }

    public int[] topKFrequent_violence(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        for (int i = 0; i < k; i++) {
            int max = 0, mi = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int key = entry.getKey();
                int val = entry.getValue();

                if (val > max) {
                    max = val;
                    mi = key;
                }
            }

            res[i] = mi;
            map.put(mi, 0);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] data = {1, 1, 1, 2, 2, 3};

        T347 t347 = new T347();
        System.out.println(Arrays.toString(t347.topKFrequent_violence(data, 2)));
        System.out.println(t347.topKFrequent_20200907(data, 2));
    }
}
