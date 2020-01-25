package hashing;

import java.util.LinkedList;

public class DirectChaining {
	LinkedList<String>[] hashTable;
	int maxChainSize = 5;
	
	public DirectChaining() {
		hashTable = new LinkedList[13];
	}
	
	public int simpleASCIIHashFunction(String val, int len) {
		char ch[];
		ch = val.toCharArray();
		int sum = 0;
		for (int i=0 ; i<val.length(); i++) {
			sum += ch[i];
		}
		return sum%len;
	}
	
	public void insertKeyInHashTable(String value) {
		int newIndex = simpleASCIIHashFunction(value, hashTable.length);
		if (hashTable[newIndex] == null) {
			System.out.println("Index: "+newIndex+" is empty. Creating a new LinkedList there...");
			hashTable[newIndex] = new LinkedList<String>();
			hashTable[newIndex].add(value);
			System.out.println("Successfully inserted "+"\""+value+"\""+" in location: " +newIndex);
			System.out.println("---------------------------------------------------------");
		}
		else {
			System.out.println("\nIndex: " + newIndex + " is having sufficient space. Inserting there...");
			hashTable[newIndex].add(value);
			System.out.println("Successfully inserted " + "\"" + value + "\"" + " in location: " + newIndex);
			System.out.println("-------------------------------------------\n");
		}
	}
	
	public boolean searchKeyInHashTable(String stringToBeSearched) {
		int newIndex = simpleASCIIHashFunction(stringToBeSearched, hashTable.length);
		if (hashTable[newIndex] != null && hashTable[newIndex].contains(stringToBeSearched)) {
			System.out.println("\n"+"\""+stringToBeSearched+"\""+" found in HashTable at location: "+newIndex);
			return true;
		}
		else {
			System.out.println("\n" + "\"" + stringToBeSearched + "\"" + " not found in HashTable.");
			return false;
		}
	}
	
	
	public void deleteKeyFromHashTable(String stringToBeDeleted) {
		int newIndex = simpleASCIIHashFunction(stringToBeDeleted, hashTable.length);
		if (hashTable[newIndex] != null && hashTable[newIndex].contains(stringToBeDeleted)) {
			System.out.println("\n" + "\"" + stringToBeDeleted + "\"" + " has been found in HashTable." );
			hashTable[newIndex].remove(stringToBeDeleted);
			System.out.println("\"" + stringToBeDeleted + "\"" + " has been deleted from HashTable !" );
		}
		else {
			System.out.println("\nCould not find " + "\"" + stringToBeDeleted + "\"" + " in HashTable");
		}
	}

	public void displayHashTable() {
		if (hashTable == null) {
			System.out.println("\nHashTable does not exists!");
			return;
		}
		else {
			System.out.println("\n----------------HashTable------------");
			for (int i=0; i<hashTable.length; i++) {
				System.out.println("Index: "+i+ ", key: "+ hashTable[i]);
			}
		}
	}
	
	public void deleteHashTable() {
		hashTable = null;
		System.out.println("Successfully deleted HashTable!");
	}
}
