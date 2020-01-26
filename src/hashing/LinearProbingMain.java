package hashing;

public class LinearProbingMain {

	public static void main(String[] args) {
		System.out.println("Linear Probing...\n");
		
		LinearProbing linearProbing = new LinearProbing();


		linearProbing.insertKeyInHashTable("The");
		linearProbing.insertKeyInHashTable("quick");
		linearProbing.insertKeyInHashTable("brown");
		linearProbing.insertKeyInHashTable("fox");
		linearProbing.insertKeyInHashTable("over");
		linearProbing.insertKeyInHashTable("lazy");
		linearProbing.displayHashTable();
		
		linearProbing.insertKeyInHashTable("fox"); //use for showing collision
		linearProbing.displayHashTable();
		
		linearProbing.insertKeyInHashTable("fox");
		linearProbing.displayHashTable();
		
		linearProbing.insertKeyInHashTable("fox");
		linearProbing.displayHashTable();
		
		linearProbing.insertKeyInHashTable("fox");
		linearProbing.displayHashTable();

//		linearProbing.insertKeyInHashTable("fox");
//		linearProbing.displayHashTable();
//		
//		linearProbing.insertKeyInHashTable("fox");
//		linearProbing.displayHashTable();
		
//		linearProbing.searchKeyInHashTable("fox");
//		linearProbing.deleteKeyFromHashTable("fox");
//		linearProbing.displayHashTable();	linearProbing.deleteKeyFromHashTable("fox");
//		linearProbing.displayHashTable();
//		linearProbing.deleteKeyFromHashTable("fox");
//		linearProbing.displayHashTable();
//		linearProbing.deleteKeyFromHashTable("fox");
//		linearProbing.displayHashTable();	
//		linearProbing.deleteKeyFromHashTable("fox");
//		linearProbing.displayHashTable();
//		linearProbing.deleteKeyFromHashTable("fox");
//		linearProbing.displayHashTable();
//		linearProbing.deleteKeyFromHashTable("fox");
//		linearProbing.displayHashTable();
//		linearProbing.deleteKeyFromHashTable("fox");
//		linearProbing.displayHashTable();
	}

}
