package main.java.edu.zju.zjh.lcold;

public class T496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] output = new int[nums1.length];

        for (int i=0; i<nums1.length; i++){
            int index = 0;
            output[i] = -1;

            for (; index<nums2.length; index++){
                if (nums1[i] == nums2[index]){
                    break;
                }
            }

            for (int j=index; j<nums2.length; j++){
                if (nums1[i] < nums2[j]){
                    output[i] = nums2[j];
                    break;
                }
            }
        }

        return output;
    }
}
