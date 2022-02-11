package main.java.edu.zju.zjh.lcold;

import java.util.Arrays;

public class T503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        for(int i=0; i<n; i++){
            output[i] = -1;
            for(int j=1; j<n; j++){
                if (nums[i] < nums[(i+j)%n]){
                    output[i] = nums[(i+j)%n];
                    break;
                }
            }
        }


        return output;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};

        T503 t503 = new T503();
        System.out.println(Arrays.toString(t503.nextGreaterElements(nums)));
    }
}
