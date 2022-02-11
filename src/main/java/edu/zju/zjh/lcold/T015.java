package main.java.edu.zju.zjh.lcold;

import java.util.*;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/6/12 下午 11:13
 * @Modified_By :
 */
public class T015 {
    public List<List<Integer>> threeSum_violence(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        int sum = 0;
        ArrayList<Integer> lst = new ArrayList<>();
        Set<ArrayList<Integer>> set = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            lst.add(nums[i]);
            for (int j = i + 1; j < n; j++) {
                sum += nums[j];
                lst.add(nums[j]);
                for (int k = j + 1; k < n; k++) {
                    sum += nums[k];
                    lst.add(nums[k]);
                    if (sum == 0) {
                        set.add((ArrayList<Integer>) lst.clone());
                    }

                    sum -= nums[k];
                    lst.remove(lst.size() - 1);
                }
                sum -= nums[j];
                lst.remove(lst.size() - 1);
            }
            sum -= nums[i];
            lst.remove(lst.size() - 1);
        }

        for (List<Integer> item : set) {
            res.add(item);
        }

        return res;
    }

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            // 枚举 a
            for (int first = 0; first < n; ++first) {
                // 需要和上一次枚举的数不相同
                if (first > 0 && nums[first] == nums[first - 1]) {
                    continue;
                }
                // c 对应的指针初始指向数组的最右端
                int third = n - 1;
                int target = -nums[first];
                // 枚举 b
                for (int second = first + 1; second < n; ++second) {
                    // 需要和上一次枚举的数不相同
                    if (second > first + 1 && nums[second] == nums[second - 1]) {
                        continue;
                    }
                    // 需要保证 b 的指针在 c 的指针的左侧
                    while (second < third && nums[second] + nums[third] > target) {
                        --third;
                    }
                    // 如果指针重合，随着 b 后续的增加
                    // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                    if (second == third) {
                        break;
                    }
                    if (nums[second] + nums[third] == target) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        ans.add(list);
                    }
                }
            }
            return ans;
        }
    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();


        return res;
    }

        public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
//        -1 0 1
//        1 2 -1

        new T015().threeSum(nums);
        new T015().threeSum_violence(nums);
    }
}
