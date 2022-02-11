package main.java.edu.zju.zjh.lcold;

public class T287 {

    public void qSort(int[] nums, int i, int j) {
        if (i >= j) return;

        int base = nums[i];
        int left = i;
        int righ = j;

        while (left < righ) {
            while (righ > left && nums[righ] >= base) {
                righ--;
            }
            nums[left] = nums[righ];

            while (left < righ && nums[left] <= base) {
                left++;
            }
            nums[righ] = nums[left];
        }
        nums[righ] = base;

        qSort(nums, i, righ - 1);
        qSort(nums, left + 1, j);
    }

    public int findDuplicate(int[] nums) {
        int n = nums.length;
        qSort(nums, 0, n - 1);
        int res = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] == res) {
                break;
            }
            res = nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 1};

        System.out.println(new T287().findDuplicate(nums));
    }
}
