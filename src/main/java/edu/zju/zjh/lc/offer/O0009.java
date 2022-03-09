package edu.zju.zjh.lc.offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: zjh
 * @date : 2022/3/9 10:01
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0009 {

    class CQueue {

        private Deque<Integer> stackI;
        private Deque<Integer> stackD;

        public CQueue() {
            stackI = new LinkedList<>();
            stackD = new LinkedList<>();
        }

        public void appendTail(int value) {
            stackI.push(value);
        }

        public int deleteHead() {
            if (stackD.isEmpty()) {
                while (!stackI.isEmpty()) {
                    stackD.push(stackI.pop());
                }
            }

            if (stackD.isEmpty()) {
                return -1;
            } else {
                return stackD.pop();
            }
        }

    }

}
