package main.java.edu.zju.zjh.lcold;

import java.util.HashMap;
import java.util.Map;

public class T136 {
    public int singleNumber_violenec(int[] nums) {
        int res = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length;i++){
            if (map.containsKey(nums[i])){
                map.remove(nums[i]);
            }else {
                map.put(nums[i], 0);
            }
        }

        for (Map.Entry<Integer, Integer> entry :map.entrySet()){
            res = entry.getKey();
        }

        return res;
    }

    public int singleNumber(int[] nums) {
        int res = 0;


        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2,1,2};

        System.out.println(new T136().singleNumber(nums));
        System.out.println(new T136().singleNumber_violenec(nums));
    }
}
