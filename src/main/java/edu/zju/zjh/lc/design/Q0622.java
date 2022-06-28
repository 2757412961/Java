package edu.zju.zjh.lc.design;

/**
 * @author: zjh
 * @date : 2022/6/27 20:00
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0622 {

    /**
     * 方法一：数组
     * 执行耗时:4 ms,击败了100.00% 的Java用户
     * 内存消耗:42 MB,击败了20.32% 的Java用户
     */
    class MyCircularQueue {

        private int[] nums;
        private int capacity;
        private int size = 0;
        private int idx = 0;

        public MyCircularQueue(int k) {
            this.nums = new int[k];
            this.capacity = k;
        }

        public boolean enQueue(int value) {
            if (isFull()) return false;
            nums[(idx + size++) % capacity] = value;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) return false;
            idx = (idx + 1) % capacity;
            size--;
            return true;
        }

        public int Front() {
            if (isEmpty()) return -1;
            return nums[idx];
        }

        public int Rear() {
            if (isEmpty()) return -1;
            return nums[(idx + size - 1) % capacity];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }
    }

}
