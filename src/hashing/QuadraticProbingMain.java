package hashing;

public class QuadraticProbingMain {

	public static void main(String[] args) {
		System.out.println("Quadratic Probing...\n");
		QuadraticProbing quadraticProbing = new QuadraticProbing();


		quadraticProbing.insertKeyInHashTable("The");
		quadraticProbing.insertKeyInHashTable("quick");
		quadraticProbing.insertKeyInHashTable("brown");
		quadraticProbing.insertKeyInHashTable("fox");
		quadraticProbing.insertKeyInHashTable("over");
		quadraticProbing.insertKeyInHashTable("lazy");
		quadraticProbing.displayHashTable();
	}

}
