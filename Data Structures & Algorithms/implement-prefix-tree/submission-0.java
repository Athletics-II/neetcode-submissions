class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWordEnd = false;
}

class PrefixTree {

    TrieNode root;

    public PrefixTree() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode ptr = root;
        for (char c : word.toCharArray()) {
            if (ptr.children[c-'a'] == null) {
                TrieNode node = new TrieNode();
                ptr.children[c-'a'] = node;
            }
            ptr = ptr.children[c-'a'];
        }
        ptr.isWordEnd = true;
    }

    public boolean search(String word) {
        TrieNode ptr = root;
        for (char c : word.toCharArray()) {
            if (ptr.children[c-'a'] == null) return false;
            ptr = ptr.children[c-'a'];
        }
        return ptr.isWordEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode ptr = root;
        for (char c : prefix.toCharArray()) {
            if (ptr.children[c-'a'] == null) return false;
            ptr = ptr.children[c-'a'];
        }
        return true;
    }
}
