package main.java.edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/8/12 上午 09:45
 * @Modified_By :
 */
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

public class T133 {
    int n = Integer.MIN_VALUE;
    int[] used = new int[1000];
    Node[] nodes = null;

    public void dfs(Node node, int val) {
        if (used[val] == 1) {
            return;
        }

        used[val] = 1;
        n = Math.max(n, val);

        List<Node> neigh = node.neighbors;
        for (int i = 0; i < neigh.size(); i++) {
            dfs(neigh.get(i), neigh.get(i).val);
        }
    }

    public void dfs2(Node node, int val) {
        if (used[val] == 1) {
            return;
        }

        used[val] = 1;

        ArrayList<Node> newNeigh = new ArrayList<>();
        for (int i = 0; i < node.neighbors.size(); i++) {
            Node next = node.neighbors.get(i);
            newNeigh.add(nodes[next.val]);

            dfs2(next, next.val);
        }

        nodes[val].neighbors = newNeigh;
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        dfs(node, node.val);

        used = new int[n + 1];
        nodes = new Node[n + 1];
        for (int i = 0; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        dfs2(node, node.val);

        return nodes[node.val];
    }

    public static void main(String[] args) {
        Node[] nodes = new Node[4];
        ArrayList<Node>[] neighs = new ArrayList[4];

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i + 1);
            neighs[i] = new ArrayList<>();
        }

        neighs[0].add(nodes[1]);
        neighs[0].add(nodes[3]);
        neighs[1].add(nodes[0]);
        neighs[1].add(nodes[2]);
        neighs[2].add(nodes[1]);
        neighs[2].add(nodes[3]);
        neighs[3].add(nodes[0]);
        neighs[3].add(nodes[2]);

        nodes[0].neighbors = neighs[0];
        nodes[1].neighbors = neighs[1];
        nodes[2].neighbors = neighs[2];
        nodes[3].neighbors = neighs[3];

        System.out.println(new T133().cloneGraph(nodes[0]));
    }
}
