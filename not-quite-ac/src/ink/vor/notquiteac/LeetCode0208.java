package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/6/18 13:22
 */
public class LeetCode0208 {
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode('0');
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (cur.next[i] == null) {
                cur.next[i] = new TrieNode(ch);
            }
            cur = cur.next[i];
        }
        cur.isLeaf = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (cur.next[i] == null) {
                return false;
            }
            cur = cur.next[i];
        }
        return cur.isLeaf;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char ch : prefix.toCharArray()) {
            int i = ch - 'a';
            if (cur.next[i] == null) {
                return false;
            }
            cur = cur.next[i];
        }
        return true;
    }
}

class TrieNode {
    char ch;
    boolean isLeaf;
    TrieNode[] next;
    public TrieNode(char ch) {
        this.ch = ch;
        isLeaf = false;
        next = new TrieNode[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
