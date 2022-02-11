package main.java.edu.zju.zjh.lcold;

public class T033 {
    public int search(int[] nums, int target) {
        for (int i=0; i<nums.length; i++){
            if (nums[i] == target){
                return i;
            }
        }

        return -1;
    }
}
