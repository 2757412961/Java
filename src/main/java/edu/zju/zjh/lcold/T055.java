package edu.zju.zjh.lcold;

public class T055 {
    boolean canjump = false;
    int[] used;

    public void dfs(int[] nums, int index) {
        if (canjump) {
            return;
        }

        for (int i = nums[index]; i >= 0; i--) {
            int j = i + index;
            if (j < nums.length && used[j] == 0) {
                if (j == nums.length - 1) {
                    canjump = true;
                    break;
                }
                used[j] = 1;
                dfs(nums, j);
            }
        }
    }

    public boolean canJump(int[] nums) {
        if (nums.length - 1 == 0) {
            return true;
        }
        int n = nums.length;
        used = new int[n];

        dfs(nums, 0);

        return canjump;
    }

    public boolean canJump2(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};

        T055 t055 = new T055();
        System.out.println(t055.canJump(nums));
        System.out.println(t055.canJump2(nums));
    }
}
