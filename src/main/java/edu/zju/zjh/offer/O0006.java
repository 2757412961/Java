package edu.zju.zjh.offer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: zjh
 * @date : 2022/3/10 10:06
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0006 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private List<Integer> res = new LinkedList<>();

    private void reverse2List(ListNode head) {
        if (head == null) return ;

        reverse2List(head);
        res.add(head.val);
    }

    public int[] reversePrint(ListNode head) {
        reverse2List(head);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

}
