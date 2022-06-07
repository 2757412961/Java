package edu.zju.zjh.lc.fs.bfs;

/**
 * @author: zjh
 * @date : 2022/6/7 15:34
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0733 {

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:42.2 MB,击败了43.71% 的Java用户
     */
    public int[][] bfs(int[][] image, int sr, int sc, int newColor, int oldColor) {
        if (sr < 0 || sr >= image.length) return image;
        if (sc < 0 || sc >= image[0].length) return image;
        if (image[sr][sc] != oldColor) return image;
        image[sr][sc] = newColor;

        bfs(image, sr, sc - 1, newColor, oldColor);
        bfs(image, sr, sc + 1, newColor, oldColor);
        bfs(image, sr + 1, sc, newColor, oldColor);
        bfs(image, sr - 1, sc, newColor, oldColor);

        return image;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        return bfs(image, sr, sc, newColor, image[sr][sc]);
    }

}
