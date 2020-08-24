/* Implement the StreamChecker class as follows:

    StreamChecker(words): Constructor, init the data structure with the given 
    words.
    query(letter): returns true if and only if for some k >= 1, the last k 
    characters queried (in order from oldest to newest, including this letter 
    just queried) spell one of the words in the given list.

Example:

StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // init the dictionary.
streamChecker.query('a');          // return false
streamChecker.query('b');          // return false
streamChecker.query('c');          // return false
streamChecker.query('d');          // return true, because 'cd' is in the wordlist
streamChecker.query('e');          // return false
streamChecker.query('f');          // return true, because 'f' is in the wordlist
streamChecker.query('g');          // return false
streamChecker.query('h');          // return false
streamChecker.query('i');          // return false
streamChecker.query('j');          // return false
streamChecker.query('k');          // return false
streamChecker.query('l');          // return true, because 'kl' is in the wordlist

 

Note:

    1 <= words.length <= 2000
    1 <= words[i].length <= 2000
    Words will only consist of lowercase English letters.
    Queries will only consist of lowercase English letters.
    The number of queries is at most 40000.

*/

class StreamChecker {
    StringBuilder sb;
    Trie trie;
    TrieNode root;
    public StreamChecker(String[] words) {
        trie = new Trie();
        sb = new StringBuilder();
        for(int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        TrieNode temp = root;
        for(int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            temp = temp.charMap[c - 'a'];
            if(temp != null && temp.isWord == true) {
                return true;
            }
            if(temp == null) {
                return false;
            }
        }
        return false;
    }
    
    class Trie {
        public Trie() {
            root = new TrieNode();
        }
        
        /* Create suffix tree */
        public void insert(String word) {
            if(word.length() == 0) return;
            TrieNode temp = root;
            char c;
            for(int i = word.length() - 1; i >= 0; i--) {
                c = word.charAt(i);
                if(temp.charMap[c - 'a'] == null) {
                    temp.charMap[c - 'a'] = new TrieNode(c);
                }
                temp = temp.charMap[c - 'a'];
            }
            temp.isWord = true;
        }
    }
    
    class TrieNode {
        char c;
        TrieNode[] charMap = new TrieNode[26];
        boolean isWord = false;
        public TrieNode(char c) {
            this.c = c;
        }
        public TrieNode() {};
    }

    public static void main(String[] args) {
        String[] words = {"cd","f","kl"};
        StreamChecker streamChecker = new StreamChecker(words);
        String queries = "abcdefghijkl";
        for(char c: queries.toCharArray()) {
            System.out.println("Querying: " + c);
            System.out.println(streamChecker.query(c));
        }
    }
}

/*
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
