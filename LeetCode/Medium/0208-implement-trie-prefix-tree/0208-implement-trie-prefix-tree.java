class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (curr.children[letter - 'a'] != null) {
                curr = curr.children[letter - 'a'];
            } else {
                curr.children[letter - 'a'] = new TrieNode();
                curr = curr.children[letter - 'a'];

            }
        }
        curr.wordEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (curr.children[letter - 'a'] == null) {
                return false;
            }
            curr = curr.children[letter - 'a'];
        }
        return curr.wordEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char letter = prefix.charAt(i);
            if (curr.children[letter - 'a'] == null) {
                return false;
            }
            curr = curr.children[letter - 'a'];
        }
        return true;
    }
}

class TrieNode {
    public boolean wordEnd;

    public TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[26];
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */