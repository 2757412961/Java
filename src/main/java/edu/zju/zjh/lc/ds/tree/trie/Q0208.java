package edu.zju.zjh.lc.ds.tree.trie;

/**
 * @author: zjh
 * @date : 2022/5/9 21:12
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0208 {

    class Trie {

        private boolean isEnd;
        private Trie[] nodes;

        public Trie() {
            this.nodes = new Trie[26];
            this.isEnd = false;
        }

        public int index(char ch) {
            return ch - 'a';
        }

        public boolean existNode(int idx) {
            return this.nodes[idx] != null;
        }

        public void putNode(int idx) {
            this.nodes[idx] = new Trie();
        }

        public Trie getNode(int idx) {
            return this.nodes[idx];
        }

        public void setEnd() {
            this.isEnd = true;
        }

        public boolean getEnd() {
            return this.isEnd;
        }

        public void insert(String word) {
            Trie trie = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int idx = index(ch);
                if (!trie.existNode(idx)) {
                    trie.putNode(idx);
                }
                trie = trie.getNode(idx);
            }
            trie.setEnd();
        }

        public boolean search(String word) {
            Trie trie = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int idx = index(ch);
                if (!trie.existNode(idx)) {
                    return false;
                }
                trie = trie.getNode(idx);
            }
            return trie.getEnd();
        }

        public boolean startsWith(String prefix) {
            Trie trie = this;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                int idx = index(ch);
                if (!trie.existNode(idx)) {
                    return false;
                }
                trie = trie.getNode(idx);
            }

            return true;
        }

    }

}
