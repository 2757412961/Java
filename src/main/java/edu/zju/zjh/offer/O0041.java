package edu.zju.zjh.offer;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: zjh
 * @date : 2022/4/10 下午 04:20
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0041 {

    class MedianFinder {

        private  Queue<Integer> max;
        private  Queue<Integer> min;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            max = new PriorityQueue<>(Collections.reverseOrder());
            min = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (max.size() == min.size()) {
                min.offer(num);
                max.offer(min.poll());
            } else {
                max.offer(num);
                min.offer(max.poll());
            }
        }

        public double findMedian() {
            if (max.size() == min.size()) {
                return 1.0 / 2 * (max.peek() + min.peek());
            } else {
                return max.peek();
            }
        }
    }

}
