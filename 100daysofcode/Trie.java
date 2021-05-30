/* https://binarysearch.com/problems/Trie */

class Trie {
    class TrieNode {
        char c;
        TrieNode[] charMap = new TrieNode[27];
        public TrieNode(char c) {
            this.c = c;    
        }
        public TrieNode() {}
    }
    
    TrieNode root = null;
    public Trie() {
        root = new TrieNode();
    }

    public void add(String word) {
        if(word.length() == 0) return;
        TrieNode temp = root;
        for(char c: word.toCharArray()) {
            if(temp.charMap[c - 'a'] == null) {
                temp.charMap[c - 'a'] = new TrieNode(c);
            }
            temp = temp.charMap[c - 'a'];
        }
        temp.charMap[26] = new TrieNode('0');
    }

    public boolean exists(String word) {
        TrieNode temp = root;
        if(temp.charMap == null) return false;
        for(char c: word.toCharArray()) {
            if(temp.charMap[c - 'a'] == null) {
                return false;
            }
            temp = temp.charMap[c - 'a'];
        }
        if(temp.charMap[26] == null)  return false;
        return true;
    }

    public boolean startswith(String prefix) {
        TrieNode temp = root;
        if(temp.charMap == null) return false;
        for(char c: prefix.toCharArray()) {
            if(temp.charMap[c - 'a'] == null) {
                return false;
            }
            temp = temp.charMap[c - 'a'];
        }
        return true;
    }
}
