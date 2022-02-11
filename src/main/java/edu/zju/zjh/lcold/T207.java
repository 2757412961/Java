package main.java.edu.zju.zjh.lcold;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/8/4 下午 11:13
 * @Modified_By :
 */
public class T207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int[] in = new int[n];
        int[][] matrix = new int[n][n];
        Queue<Integer> que = new LinkedList<>();

        for (int i = 0; i < prerequisites.length; i++) {
            matrix[prerequisites[i][1]][prerequisites[i][0]] = 1;
            in[prerequisites[i][0]]++;
        }

        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                que.add(i);
            }
        }

        while (!que.isEmpty()) {
            int now = que.poll();

            for (int i = 0; i < n; i++) {
                if (matrix[now][i] == 1) {
                    in[i]--;
                    if (in[i] == 0) {
                        que.add(i);
                    }
                }
            }

        }

        for (int i = 0; i < n; i++) {
            if (in[i] > 0) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
//        你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
//        在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
//
//        给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？

//        示例 1:
//        输入: 2, [[1,0]]
//        输出: true
//        解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。

//        示例 2:
//        输入: 2, [[1,0],[0,1]]
//        输出: false
//        解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。

        int numCourses = 4;
        int[][] prerequisites = new int[][]{
                {0, 1},
                {0, 3},
                {2, 1},
                {2, 3}
        };

        System.out.println(new T207().canFinish(numCourses, prerequisites));
    }
}
