package hashing;

public class DirectChainingMain {

	public static void main(String[] args) {
		
		System.out.println("Diriect Chaining...\n");
		
		DirectChaining directChaining = new DirectChaining();

		directChaining.insertKeyInHashTable("The");
		directChaining.insertKeyInHashTable("quick");
		directChaining.insertKeyInHashTable("brown");
		directChaining.insertKeyInHashTable("fox");
		directChaining.insertKeyInHashTable("over");
		directChaining.insertKeyInHashTable("lazy");
		directChaining.displayHashTable();

		directChaining.insertKeyInHashTable("fox"); // use for showing collision
		directChaining.displayHashTable();

		directChaining.insertKeyInHashTable("fox"); 
		directChaining.displayHashTable();
		
		directChaining.insertKeyInHashTable("fox"); 
		directChaining.displayHashTable();
		
		directChaining.insertKeyInHashTable("fox"); 
		directChaining.displayHashTable();
		
		directChaining.deleteKeyFromHashTable("fox");
		directChaining.displayHashTable();
	}

}
