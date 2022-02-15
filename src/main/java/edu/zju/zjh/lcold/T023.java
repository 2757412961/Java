package edu.zju.zjh.lcold;

public class T023 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode root = new ListNode(0);
        ListNode res = root;

        Boolean flag = true;
        while (flag) {
            flag = false;

            int minIndex = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    flag = true;

                    if (minIndex == -1) {
                        minIndex = i;
                    } else {
                        if (lists[minIndex].val > lists[i].val) {
                            minIndex = i;
                        }
                    }
                }
            }

            if (minIndex == -1) {
                break;
            }
            ListNode node = new ListNode(lists[minIndex].val);
            root.next = node;
            root = root.next;

            lists[minIndex] = lists[minIndex].next;
        }


        return res.next;
    }

    public static void main(String[] args) {
        new T023().mergeKLists(new ListNode[1]);
    }
}
