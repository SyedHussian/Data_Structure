package trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	
	private class TrieNode{
		Map<Character, TrieNode> children;
		boolean endOfWord;
		
		public TrieNode() {
			children = new HashMap<>();
			endOfWord = false;
		}
	}

	private final TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	public void insert(String word) {
		TrieNode current = root;
		for (int i=0; i<word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) {
				node = new TrieNode();
				current.children.put(ch, node);
			}
			current = node;
		}
		current.endOfWord = true;
		System.out.println("Successfully inserted "+word+ " in Trie!");
	}
	
	
	public boolean search(String word) {
		TrieNode currentNode = root;
		for (int i=0; i<word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = currentNode.children.get(ch);
			//Case#1 -- if node does not exist for given char then return false
			if (node == null) {
				System.out.println("Word: " +word+ " does not exists in Trie!");
				return false;
			}
			currentNode = node;
		}
		if (currentNode.endOfWord == true) {
			System.out.println("Word: "+word+" does not exists in Trie! ");
		}
		else { //Case#3 -- current word is a prefix of another word. But this word does not exists
			System.out.println("Word: "+word+" does not exists in Trie! But this is not a Prefix of another word !");
		}
		return currentNode.endOfWord;
	}
	
	
	public void delete(String word) {
		if (search(word) == true) {
			delete(root, word, 0);
		}
	}
	
	public boolean delete(TrieNode parentNode, String word, int index) {
		// CASE#1 -- Some other word's prefix is same as Prefix of this word (BCDE, BCKG)
		// CASE#2 -- We are at last character of this word and This word is a Prefix of some other word (BCDE, BCDEFG)
		// CASE#3 -- Some other word is a Prefix of this word (BCDE, BC)
		// CASE#4 -- No one is dependent on this Word (BCDE, BCDE)
		
		char ch = word.charAt(index);
		TrieNode currentNode = parentNode.children.get(ch);
		
		boolean canThisNodeBeDeleted;
		
		if (currentNode.children.size() > 1) {
			System.out.println("Entering Case#1");
			delete(currentNode, word, index+1);//Case#1
			return false;
		}
		
		if (index == word.length()-1) { //Case#2
			System.out.println("Entering Case#2");
			if (currentNode.children.size() >= 1) {
				currentNode.endOfWord = false; // updating endOfWord
				return false;
			}
		}
		else {
			System.out.println("Character "+ch+ " has no dependency, hence deleting it from last!");
			parentNode.children.remove(ch);
			return true;
			// if this word is not a prefix of some other word, and since this is last
			// character, we should
			// return true, indicating we are ok to delete this node
		}
		
		System.out.println("Entering Case#1");
		canThisNodeBeDeleted = delete(currentNode, word, index+1);
		
		if (canThisNodeBeDeleted = true) { //Case#4
			System.out.println("Character "+ch+" has no dependency, hence deleting it!");
			parentNode.children.remove(ch);
			return true;
		}
		else {
			return false;
		}
	}
}
