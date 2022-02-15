package edu.zju.zjh.lcold;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/6/26 下午 02:47
 * @Modified_By :
 */
public class O0201 {
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode res = new ListNode(-1);
        ListNode root = res;
        Map<Integer, Boolean> map = new HashMap<>();

        while (head != null) {
            ListNode now = head;
            head = head.next;
            now.next = null;

            if (!map.containsKey(now.val)) {
                root.next = now;
                root = root.next;

                map.put(now.val, true);
            }
        }

        return res.next;
    }

    public static void main(String[] args) {
//        编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
//
//        示例1://
//        输入：[1, 2, 3, 3, 2, 1]
//        输出：[1, 2, 3]

//        示例2://
//        输入：[1, 1, 1, 1, 2]
//        输出：[1, 2]
//        提示：
//
//        链表长度在[0, 20000]范围内。
//        链表元素在[0, 20000]范围内。

        ListNode[] nodes = new ListNode[6];
        nodes[0] = new ListNode(1);
        nodes[1] = new ListNode(2);
        nodes[2] = new ListNode(3);
        nodes[3] = new ListNode(3);
        nodes[4] = new ListNode(2);
        nodes[5] = new ListNode(1);

        for (int i = 0; i < nodes.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }

        System.out.println(new O0201().removeDuplicateNodes(nodes[0]));
    }
}
