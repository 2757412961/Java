package edu.zju.zjh.lc.ds.linkedlist;

import java.util.List;

/**
 * @author: zjh
 * @date : 2022/5/29 16:47
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0082 {

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

    /**
     * 方法一：一次遍历 时间复杂度：O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.7 MB,击败了77.15% 的Java用户
     */
    public static final int OUT = 1000;

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(OUT, head);
        // prev 保留前一个节点，cur一直遍历下去，遇到重复的则删除
        ListNode prev = dummy, cur = dummy.next;
        int delete = -1;

        while (cur != null) {
            if (cur.next != null) {
                // 跳过重复的节点
                if (cur.val == cur.next.val) {
                    delete = cur.val;
                    while (cur != null && cur.val == delete) {
                        prev.next = cur.next;
                        cur = cur.next;
                    }
                    // 重新检验新的节点是否重复
                    continue;
                }
            }
            prev = prev.next;
            cur = cur.next;
        }

        return dummy.next;
    }

}
