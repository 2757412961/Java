package edu.zju.zjh.lcold;

import java.util.Stack;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/6/30 下午 02:59
 * @Modified_By :
 */
public class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        int val = -1;
        stack2.clear();
        while (stack1.size() > 0) {
            stack2.push(stack1.pop());
        }

        if (stack2.size() > 0) {
            val = stack2.pop();
        }


        while (stack2.size() > 0) {
            stack1.push(stack2.pop());
        }

        return val;
    }

    /**
     * Your CQueue object will be instantiated and called as such:
     * CQueue obj = new CQueue();
     * obj.appendTail(value);
     * int param_2 = obj.deleteHead();
     */

    public static void main(String[] args) {
    /*    剑指 Offer 09. 用两个栈实现队列
        用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
        分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

        示例 1：
        输入：
        ["CQueue","appendTail","deleteHead","deleteHead"]
        [[],[3],[],[]]
        输出：[null,null,3,-1]

        示例 2：
        输入：
        ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
        [[],[],[5],[2],[],[]]
        输出：[null,-1,null,null,5,2]

        提示：
        1 <= values <= 10000
        最多会对 appendTail、deleteHead 进行 10000 次调用*/


    }
}
