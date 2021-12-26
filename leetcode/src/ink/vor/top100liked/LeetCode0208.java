package ink.vor.top100liked;

import java.util.*;

/**
 * @author muquanrui
 * @date 26/12/2021 21:27
 */
public class LeetCode0208 {
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        char[] wordArr = word.toCharArray();
        TrieNode temp = root;
        int i = 0;
        for (; i < wordArr.length; i++) {
            if (temp.subMap.get(wordArr[i]) != null) {
                temp = temp.subMap.get(wordArr[i]);
            } else {
                break;
            }
        }
        for (; i < wordArr.length; i++) {
            TrieNode newNode = new TrieNode();
            newNode.letter = wordArr[i];
            newNode.isEnd = false;
            temp.subMap.put(wordArr[i], newNode);
            temp = newNode;
        }
        temp.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode res = moveTemp(word);
        if (res == null) {
            return false;
        } else {
            return res.isEnd;
        }
    }

    public boolean startsWith(String prefix) {
        return moveTemp(prefix) != null;
    }

    public TrieNode moveTemp(String str) {
        if (root == null) {
            return null;
        }
        TrieNode temp = root;
        for (int i = 0; i < str.length(); i++) {
            if (temp.subMap.get(str.charAt(i)) != null) {
                temp = temp.subMap.get(str.charAt(i));
            } else {
                return null;
            }
        }
        return temp;
    }

}

class TrieNode {
    char letter;
    Map<Character, TrieNode> subMap;
    boolean isEnd;

    public TrieNode() {
        subMap = new HashMap<>();
    }
}
