package edu.zju.zjh.lc.ds.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zjh
 * @date : 2022/2/24 9:39
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0083 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode prev = dummyHead;
        Map<Integer, Integer> map = new HashMap<>();

        while (head != null) {
            if (!map.containsKey(head.val)) {
                map.put(head.val, 1);
                prev = prev.next;
                head = head.next;
            } else {
                prev.next = head.next;
                head.next = null;
                head = prev.next;
            }
        }

        return dummyHead.next;
    }

}
