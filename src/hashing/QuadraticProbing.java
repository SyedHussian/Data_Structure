package hashing;

import java.util.ArrayList;

public class QuadraticProbing {
	String[] hashTable;
	int noOfCellsUsedInHashTable;
	
	public QuadraticProbing(){
		hashTable = new String[13];
		noOfCellsUsedInHashTable = 0;
	}
	
	public int simpleASCIIHashFunction(String val, int len) {
		char ch[];
		ch = val.toCharArray();
		int sum=0;
		for (int i=0; i<val.length();i++) {
			sum += ch[i];
		}
		return sum%len;
	}
	
	public double getLoadFactor() {
		return noOfCellsUsedInHashTable * 1.0 / hashTable.length;
	}
	
	public void rehashKey(String newStringToBeInserted) {
		noOfCellsUsedInHashTable = 0;
		ArrayList<String> data = new ArrayList<String>();
		for (String s : hashTable) {
			if (s != null) {
				data.add(s);
			}
		}
		data.add(newStringToBeInserted);
		
		hashTable = new String[hashTable.length * 2];
		for (String s : data) {
			insertKeyInHashTable(s);
		}
	}
	
	public void insertKeyInHashTable(String value) {
		double loadFactor = getLoadFactor();
		if (loadFactor >= 0.75) {
			System.out.println("Load factor of this HashTable has exceeded 0.75, hence we need to Rehash!");
			rehashKey(value);
		}
		else {
			System.out.println("Inserting \""+value+"\" in HashTable...");
			int index = simpleASCIIHashFunction(value, hashTable.length);
			int counter = 0;
			for (int i = index; i<index+hashTable.length; i++) {
				int newIndex = (index + (counter * counter)) % hashTable.length;
				if (hashTable[newIndex] == null) {
					hashTable[newIndex] = value;
					System.out.println("Index: "+newIndex+ " is blank. Inserting there...");
					System.out.println("Successfully inserted "+"\""+value+"\""+" in location: "+ newIndex);
					System.out.println("-------------------------------------------\n");
					break;
				}
				else {
					System.out.println("Index: " + newIndex + " is already occupied. Trying next empty cell...");
				}
				counter++;
			}
		}
		noOfCellsUsedInHashTable++;
	}
	
	
	public boolean searchKeyHashTable(String stringToBeSearched) {
		int index = simpleASCIIHashFunction(stringToBeSearched, hashTable.length);
		for (int i = index; i<index+hashTable.length; i++) {
			int newIndex = i%hashTable.length;
			if (hashTable[newIndex] != null && hashTable[newIndex].equals(stringToBeSearched)) {
				System.out.println("\n" + "\"" + stringToBeSearched + "\"" + " found in HashTable at location: " + newIndex);
				return true;
			}
		}
		System.out.println("\n" + "\"" + stringToBeSearched + "\"" + " not found in HashTable.");
		return false;
	}
	
	
	public void deleteKeyFromHashTable(String stringToBeDeleted) {
		int index = simpleASCIIHashFunction(stringToBeDeleted, hashTable.length);
		for (int i = index; i<index+hashTable.length; i++ ) {
			int newIndex = i%hashTable.length;
			if (hashTable[newIndex] != null && hashTable[newIndex].equals(stringToBeDeleted)) {
				hashTable[newIndex] = null;
				System.out.println("\n" + "\"" + stringToBeDeleted + "\"" + " has been found in HashTable.");
				System.out.println("\"" + stringToBeDeleted + "\"" + " has been deleted from HashTable !");
				return;
			}
		}
		System.out.println("\nCould not find " + "\"" + stringToBeDeleted + "\"" + " in HashTable");
	}
	
	public void displayHashTable() {
		if (hashTable == null) {
			System.out.println("\nHashTable does not exits !");
			return;
		}
		else {
			System.out.println("\n---------- HashTable ---------");
			for (int i = 0; i < hashTable.length; i++) {
				System.out.println("Index:" + i + ".   Key:" + hashTable[i]);
			}
		}
		System.out.println("\n");
	}
	
	public void deleteHashTable() {
		System.out.println("Successfully deleted HashTable !");
		hashTable = null;
	}//end of method
}
