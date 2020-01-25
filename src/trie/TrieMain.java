package trie;

public class TrieMain {
	public static void main(String[] args) {
		Trie t  =new Trie();
		
		System.out.println("Case 1...");
		//CASE#1
		t.insert("bcde");
		t.insert("bckg");
		t.delete("bcde");
		t.search("bcde");
		t.search("bckg");
		
		System.out.println("\nCase 2...");
		//CASE#2
		t.insert("bcde");
		t.insert("bcdefg");
		t.delete("bcde");
		t.search("bcde");
		t.search("bcdefg");
		
		System.out.println("\nCase 3...");
		//CASE#3
		t.insert("bcde");
		t.insert("bc");
		t.delete("bcde");
		t.search("bcde");
		t.search("bcde");
		t.search("bc");
		t.search("b");
		
		System.out.println("\nCase 4...");
		//CASE#4
		t.insert("bcde");
		t.delete("bcde");
		t.search("bcde");
		
		
	}
}
