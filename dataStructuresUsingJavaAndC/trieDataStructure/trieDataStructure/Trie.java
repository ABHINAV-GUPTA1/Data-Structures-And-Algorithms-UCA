package trieDataStructure;

/** Trie Implementation
 *  @author ABHINAV GUPTA
 * */
class Trie {
	TrieNode root;
	public final int ALPHABET_SIZE=26; 
	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word, int value) {
		TrieNode p = root;
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (p.nodes[index] == null)
				p.nodes[index] = new TrieNode();
			p = p.nodes[index];
		}
		p.value = value;
	}

	/* DISPLAY ALL KEYS AND VALUES IN TRIE */
	public void print() {
		String prefix = "";
		print(root, prefix);
	}
	
	private void print(TrieNode n, String prefix) {
		// show when a complete word is reached
		if(n.value != null)
			System.out.println(prefix + " (" + n.value + ")");
		
		for(int index = 0; index < ALPHABET_SIZE; index++) {
			if(n.nodes[index] != null) {
				char ch = (char)(index + 'a');
				
				prefix = prefix + ch; // add a character at the end
				print(n.nodes[index], prefix); // call recursively
				if(prefix != null && prefix.length() != 0)
					prefix = prefix.substring(0, prefix.length() - 1); // remove a character from the end
			}
		}
	}

	public TrieNode searchNode(String word) {
		TrieNode p = root;
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (p.nodes[index] == null)
				return null;
			p = p.nodes[index];
		}
		return p;
	}

	public void softDelete(String word) {
		TrieNode p = root;
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (p.nodes[index] == null) {
				System.out.println("NOT found");
				return;
			}
			p = p.nodes[index];
		}
		p.value = null;
	}
	
	public void hardDelete(String word) {
		hardDelete(root,word,0);
		System.out.println(word + " deleted");
	}
	
	/*private boolean hardDelete(TrieNode root,String word,int l) {
		if (root == null)
			return false;
		if (l == word.length()) {
			root.value = null;
			if (hasChild(root))
				return false;
			return true;
		}
		int index = word.charAt(l) - 'a';
		if (hardDelete(root.nodes[index], word, l+1)) {
			root.nodes[index] = null;
			return !hasChild(root);
		}
		return false;
	}*/
	
	private boolean hardDelete(TrieNode root,String word,int l) {
		if (root == null)
			return false;
		if (l == word.length()) {
			if (hasChild(root))
				return false;
			root.value = null;
			return true;
		}
		int index = word.charAt(l) - 'a';
		if (hardDelete(root.nodes[index], word, l+1)) {
			root.nodes[index] = null;
			if (!hasChild(root) && root.value == null)
				return true;
			return false;
		}
		return false;
	}
	public void getVals(String word){
		
	}
	private boolean hasChild(TrieNode a) {
		for (int i = 0; i < 26; i++){
			if (a.nodes[i] != null)
				return true;
		}
		return false;
	}
	public void search(String word) {
		TrieNode p = searchNode(word);
		if (p != null && p.value != null)
			System.out.println("Exist with value = " + p.value);
		/*else if (p != null && p.value == null)
				System.out.println("Prefix exist");*/
		else
			System.out.println("Doesnot exist");
	}

	public boolean startWith(String word) {
		TrieNode p = searchNode(word);
		return p != null;
	}

	public static void main(String[] args) {
		Trie ans = new Trie();
		ans.insert("ann", 1);
		ans.insert("annd", 2);
		//ans.insert("ans", 3);
		//ans.insert("anne", 4);
		//ans.insert("gmn", 5);
		System.out.println("Search for annd - ");
		ans.search("annd");
		//ans.search("gmn");
		//ans.searchNode("ann");
		//ans.softDelete("ann");
		ans.hardDelete("annd");
		//System.out.println("");
		System.out.print("search annd - ");
		ans.search("annd");
		System.out.println("Start with - annd -"+ans.startWith("annd"));
		System.out.println("Start with - ann -"+ans.startWith("ann"));
		System.out.print("search ann - ");
		ans.search("ann");
		System.out.println("\n\n");
		ans.print();
	}
}