package main.java.edu.zju.zjh.lcold;

public class T045 {
    int[] used;
    int res = 9999;

    public void dfs(int[] nums, int index, int depth) {
        if (index >= nums.length - 1) {
            res = Math.min(res, depth);
            return;
        }
//        if (used[index] == 1) {
//            return;
//        }
//        used[index] = 1;

        for (int i = 1; i <= nums[index]; i++) {
            dfs(nums, index + i, depth + 1);
        }
    }

    public int jump_violence(int[] nums) {
        used = new int[nums.length];

        dfs(nums, 0, 0);
        res = res >= 9999 ? -1 : res;
        return res;
    }

    public int jump(int[] nums) {
        int res = 0;
        int[] used = new int[nums.length];

        int nowIn = 0, maxDis = 0, update = 0;
        while (maxDis < nums.length - 1) {
            for (int i = nowIn; i <= maxDis; i++) {
                if (i >= nums.length) {
                    return res;
                }
                update = Math.max(update, i + nums[i]);
            }
            nowIn = maxDis + 1;
            maxDis = update;

            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1, 1, 1};

        System.out.println(new T045().jump(nums));
        System.out.println(new T045().jump_violence(nums));
    }
}
