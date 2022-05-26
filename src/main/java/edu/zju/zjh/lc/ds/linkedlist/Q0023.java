package edu.zju.zjh.lc.ds.linkedlist;

import javafx.scene.layout.Priority;

import java.util.PriorityQueue;

/**
 * @author: zjh
 * @date : 2022/5/26 9:16
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0023 {

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
     * 方法一：顺序合并 渐进时间复杂度为 O(k^2 * n)
     */

    /**
     * 方法二：分治合并 渐进时间复杂度为 O(kn×logk)。
     */

    /**
     * 方法三：使用优先队列合并 渐进时间复杂度为 O(kn×logk)。
     * 执行耗时:4 ms,击败了70.38% 的Java用户
     * 内存消耗:43.2 MB,击败了55.42% 的Java用户
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(), p = dummy, next;
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>((a, b) -> {
            return a.val - b.val;
        });

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) heap.offer(lists[i]);
        }

        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            next = node.next;
            if (next != null) heap.offer(next);

            node.next = null;
            p.next = node;
            p = p.next;
        }

        return dummy.next;
    }

}
