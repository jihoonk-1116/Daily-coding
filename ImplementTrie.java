class Trie {
    
    public class Node{
        
        Node[] children;
        boolean isEnd;
        
        public Node(){
            this.children = new Node[26];
            this.isEnd = false;
        }
        
    }
    
    private Node root;
    public Trie() {
        this.root = new Node();
    }
    
    public void insert(String word) {
        Node w = this.root;
        
        for(char c : word.toCharArray()){
            
            int i = c - 'a';
            
            if(w.children[i] == null){
                w.children[i] = new Node();
            }
            w = w.children[i];
        }
        
        w.isEnd = true;
        
    }
    
    public boolean search(String word) {
        Node w = root;
        
        for(char c : word.toCharArray()){
            int i = c - 'a';
            if(w.children[i] == null){
                return false;
            }
            w = w.children[i];
        }
        
        return w.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Node w = root;
        
        for(char c : prefix.toCharArray()){
            int i = c - 'a';
            if(w.children[i] == null) return false;
            w = w.children[i];
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */


