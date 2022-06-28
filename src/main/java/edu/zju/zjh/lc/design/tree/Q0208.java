package edu.zju.zjh.lc.design.tree;

/**
 * @author: zjh
 * @date : 2022/6/27 16:40
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0208 {

    /**
     * 现在你应该知道为啥 Trie 树也叫前缀树了，因为其中的字符串共享前缀，
     * 相同前缀的字符串集中在 Trie 树中的一个子树上，给字符串的处理带来很大的便利。
     * 执行耗时:42 ms,击败了22.72% 的Java用户
     * 内存消耗:78.6 MB,击败了4.99% 的Java用户
     */
    class Trie {

        private int size = 0;
        private Trie[] children = new Trie[128];
        private boolean isNode = false;

        public Trie() {

        }

        public Trie findNode(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                if (node == null) break;
                node = node.children[word.charAt(i)];
            }

            return node;
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.children[c] == null) {
                    node.size++;
                    node.children[c] = new Trie();
                }
                node = node.children[c];
            }
            node.isNode = true;
        }

        public boolean search(String word) {
            Trie node = findNode(word);

            return node != null && node.isNode;
        }

        public boolean startsWith(String prefix) {
            Trie node = findNode(prefix);

            return node != null;
        }

    }

}
