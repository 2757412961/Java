package edu.zju.zjh.lcold;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/8/22 上午 12:24
 * @Modified_By :
 */
public class T679 {
    public boolean judgePoint24_violence_huisu(int[] nums) {
        int n = nums.length;
        double[] ans = new double[n + 3];
        int[] used = new int[n + 2];

        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            if (used[i] == 0) {
                used[i] = 1;
                for (int j = 0; j < n; j++) {
                    if (used[j] == 0) {
                        used[j] = 1;

                        //
                        for (int ij = 0; ij < 4; ij++) {
                            if (ij == 0) {
                                ans[4] = ans[i] + ans[j];
                            } else if (ij == 1) {
                                ans[4] = ans[i] - ans[j];
                            } else if (ij == 2) {
                                ans[4] = ans[i] * ans[j];
                            } else if (ij == 3 && ans[j] != 0) {
                                ans[4] = ans[i] / ans[j];
                            }

                            for (int k = 0; k < n + 1; k++) {
                                if (used[k] == 0) {
                                    used[k] = 1;
                                    for (int l = 0; l < n + 1; l++) {
                                        if (used[l] == 0) {
                                            used[l] = 1;


                                            for (int kl = 0; kl < 4; kl++) {
                                                if (kl == 0) {
                                                    ans[5] = ans[k] + ans[l];
                                                } else if (kl == 1) {
                                                    ans[5] = ans[k] - ans[l];
                                                } else if (kl == 2) {
                                                    ans[5] = ans[k] * ans[l];
                                                } else if (kl == 3 && ans[l] != 0) {
                                                    ans[5] = ans[k] / ans[l];
                                                }

                                                for (int o = 0; o < n + 2; o++) {
                                                    if (used[o] == 0) {
                                                        used[o] = 1;
                                                        for (int p = 0; p < n + 2; p++) {
                                                            if (used[p] == 0) {
                                                                used[p] = 1;


                                                                for (int op = 0; op < 4; op++) {
                                                                    if (op == 0) {
                                                                        ans[6] = ans[o] + ans[p];
                                                                    } else if (op == 1) {
                                                                        ans[6] = ans[o] - ans[p];
                                                                    } else if (op == 2) {
                                                                        ans[6] = ans[o] * ans[p];
                                                                    } else if (op == 3 && ans[p] != 0) {
                                                                        ans[6] = ans[o] / ans[p];
                                                                    }

                                                                    if (Math.abs(ans[6] - 24.0) <= 1e-6) return true;
                                                                }


                                                                used[p] = 0;
                                                            }
                                                        }
                                                        used[o] = 0;
                                                    }
                                                }
                                            }

                                            used[l] = 0;
                                        }
                                    }
                                    used[k] = 0;
                                }
                            }
                        }

                        used[j] = 0;
                    }
                }
                used[i] = 0;
            }
        }


        return false;
    }

    private boolean res = false;

    public void huishu(double[] ans, int[] used, int ord) {
        if (ord == 7 && Math.abs(ans[6] - 24.0) <= 1e-6) res = true;
        if (ord == 7 || res) return;

        for (int i = 0; i < ord; i++) {
            if (used[i] == 0) {
                used[i] = 1;
                for (int j = 0; j < ord; j++) {
                    if (used[j] == 0) {
                        used[j] = 1;

                        for (int ij = 0; ij < 4; ij++) {
                            if (ij == 0) {
                                ans[ord] = ans[i] + ans[j];
                            } else if (ij == 1) {
                                ans[ord] = ans[i] - ans[j];
                            } else if (ij == 2) {
                                ans[ord] = ans[i] * ans[j];
                            } else if (ij == 3 && ans[j] != 0) {
                                ans[ord] = ans[i] / ans[j];
                            } else {
                                ans[ord] = 0;
                            }

                            huishu(ans, used, ord + 1);
                        }

                        used[j] = 0;
                    }
                }

                used[i] = 0;
            }
        }

    }

    public boolean judgePoint24(int[] nums) {
        int n = nums.length;
        double[] ans = new double[n + 3];
        int[] used = new int[n + 2];

        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
        }

        huishu(ans, used, 4);

        return res;
    }


    public static void main(String[] args) {
//        你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
//
//        示例 1:
//        输入: [4, 1, 8, 7]
//        输出: True
//        解释: (8-4) * (7-1) = 24

//        示例 2:
//        输入: [1, 2, 1, 2]
//        输出: False
//        注意:
//
//        除法运算符 / 表示实数除法，而不是整数除法。例如 4 / (1 - 2/3) = 12 。

//        int[] nums = new int[]{4, 1, 8, 7};
//        int[] nums = new int[]{1, 2, 1, 2};
//        int[] nums = new int[]{1, 9, 1, 2};
        int[] nums = new int[]{8, 1, 6, 6};     // 6 / (1 - 6 / 8)
        System.out.println(new T679().judgePoint24(nums));
        System.out.println(new T679().judgePoint24_violence_huisu(nums));
    }
}
