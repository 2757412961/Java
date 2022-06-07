package edu.zju.zjh.lc.design;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author: zjh
 * @date : 2022/6/7 15:13
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0295 {

    /**
     * 执行耗时:136 ms,击败了15.18% 的Java用户
     * 内存消耗:69.8 MB,击败了19.13% 的Java用户
     */
    class MedianFinder {

        private PriorityQueue<Integer> maxHeap;
        private PriorityQueue<Integer> minHeap;

        public MedianFinder() {
            this.maxHeap = new PriorityQueue<>();
            this.minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (maxHeap.size() == minHeap.size()) {
                minHeap.offer(num);
                maxHeap.offer(minHeap.poll());
            } else {
                maxHeap.offer(num);
                minHeap.offer(maxHeap.poll());
            }
        }

        public double findMedian() {
            if (maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else {
                return maxHeap.peek();
            }
        }

    }

}
