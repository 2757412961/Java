package edu.zju.zjh.lc.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zjh
 * @date : 2022/6/23 下午 02:29
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0133 {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    /**
     * DFS
     * 执行耗时:23 ms,击败了99.85% 的Java用户
     * 内存消耗:41.4 MB,击败了52.22% 的Java用户
     */
    private class S1 {

        private Map<Node, Node> map = new HashMap<>();

        public Node cloneGraph(Node node) {
            if (node == null) return null;

            if (map.containsKey(node)) {
                return map.get(node);
            }

            Node copy = new Node(node.val);
            map.put(node, copy);

            for (Node neighbor : node.neighbors) {
                copy.neighbors.add(cloneGraph(neighbor));
            }

            return copy;
        }

    }

}
