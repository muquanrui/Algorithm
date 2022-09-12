package ink.vor.onceagain;

/**
 * @author muquanrui
 * @date 2022/6/18 13:22
 */

/**
 * https://leetcode.cn/problems/implement-trie-prefix-tree/
 * 前缀树
 */
public class LeetCode0208 {
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
        root.isLeaf = true;
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            cur.addChild(ch);
            cur = cur.children[ch - 'a'];
        }
        cur.isLeaf = true;
    }

    public boolean search(String word) {
        TrieNode lastTrieNode = getLastTrieNode(word);
        return lastTrieNode != null && lastTrieNode.isLeaf;
    }

    public boolean startsWith(String prefix) {
        TrieNode lastTrieNode = getLastTrieNode(prefix);
        return lastTrieNode != null;
    }

    private TrieNode getLastTrieNode(String str) {
        TrieNode cur = root;
        for (char ch : str.toCharArray()) {
            if (cur.children == null || cur.children[ch - 'a'] == null) {
                return null;
            }
            cur = cur.children[ch - 'a'];
        }
        return cur;
    }
}

class TrieNode {
    char ch = ' ';
    boolean isLeaf = false;
    TrieNode[] children = null;

    public TrieNode() {
    }

    public TrieNode(char ch) {
        this.ch = ch;
    }

    public void addChild(char c) {
        if (children == null) {
            children = new TrieNode[26];
        }
        if (children[c - 'a'] == null) {
            children[c - 'a'] = new TrieNode(c);
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
