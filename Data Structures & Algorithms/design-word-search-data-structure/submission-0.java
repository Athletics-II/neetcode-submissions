class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWordEnd = false;
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode ptr = root;
        for (char c : word.toCharArray()) {
            if (ptr.children[c-'a']==null) {
                TrieNode node = new TrieNode();
                ptr.children[c-'a'] = node;
            }
            ptr = ptr.children[c-'a'];
        }
        ptr.isWordEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int idx, TrieNode root) {
        TrieNode ptr = root;
        for (int i=idx; i<word.length(); i++) {
            char c = word.charAt(i);
            if (c =='.') {
                for (TrieNode t : ptr.children) {
                    if (t!=null && dfs(word, i+1, t)) return true;
                }
                return false;
            }
            if (ptr.children[c-'a']==null) return false;
            ptr = ptr.children[c-'a'];
        }
        return ptr.isWordEnd;
    }
}
