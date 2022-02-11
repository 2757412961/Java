package main.java.edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.List;

public class T126 {
    int minDepth = Integer.MAX_VALUE;
    int target;
    List<String> words;
    ArrayList<String> templst = new ArrayList<>();
    List<List<String>> res = new ArrayList<>();

    public Boolean isConnect(String str1, String str2) {
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
        }

        if (count == 1) return true;
        else return false;
    }

    public void dfs(int[] used, ArrayList<ArrayList<Integer>> dis, int pos, int depth) {
        if (depth > minDepth) {
            return;
        }
        if (target == pos) {
            if (depth > minDepth) {
                res.clear();
            }
            minDepth = Math.min(minDepth, depth);
            res.add(new ArrayList<>(templst));
            return;
        }

        List<Integer> dispos = dis.get(pos);
        for (int i = 0; i < dispos.size(); i++) {
            int posi = dispos.get(i);
            if (used[posi] == 0) {
                used[posi] = 1;
                templst.add(words.get(posi - 1));
                dfs(used, dis, posi, depth + 1);
                templst.remove(templst.size() - 1);
                used[posi] = 0;
            }
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        int[] used = new int[n + 1];
        ArrayList<ArrayList<Integer>> dis = new ArrayList<>();
        target = -1;
        words = wordList;
        templst.add(beginWord);

        for (int i = 0; i < n + 1; i++) {
            dis.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            if (isConnect(beginWord, wordList.get(i))) {
                dis.get(0).add(i + 1);
            }
            for (int j = i + 1; j < n; j++) {
                if (isConnect(wordList.get(i), wordList.get(j))) {
                    dis.get(i + 1).add(j + 1);
                    dis.get(j + 1).add(i + 1);
                }
            }
            if (endWord.equals(wordList.get(i))) {
                target = i + 1;
            }
        }

        dfs(used, dis, 0, 1);

        List<List<String>> res2 = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i).size() == minDepth) {
                res2.add(res.get(i));
            }
        }

        return res2;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        new T126().findLadders(beginWord, endWord, wordList);
    }
}
