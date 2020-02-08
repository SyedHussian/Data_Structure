package node;

import java.util.ArrayList;

public class NumberOfPathNode {
	
	int costToReachLastCell = 0;
	int costOfCurrentCell = 0;
	NumberOfPathNode rightCell = null;
	NumberOfPathNode downCell = null;
	int numberOfWaysToComeHereFromRightOrDown = 0;
	ArrayList<Integer> NumberOfWaysSatisfyingDownCell = new ArrayList<Integer>();
	ArrayList<Integer> NumberOfWaysSatisfyingRightCell = new ArrayList<Integer>();
	
	//Constructor
	public NumberOfPathNode(int costOfCurrentCell, NumberOfPathNode rightCell, NumberOfPathNode DownCell, int costToReachLastCell) {
		this.costOfCurrentCell = costOfCurrentCell;
		this.rightCell = rightCell;
		this.downCell = downCell;
		this.costToReachLastCell = costToReachLastCell;
	}
	
	//Getting numbers of ways to reach last cell from current cell
	public int getNumberOfWaysToReachLastCellFromHere() {
		int numberOfWaysToReachLastCellFromHere = 0;
		for (int i=0; i<NumberOfWaysSatisfyingRightCell.size(); i++) {
			if ( NumberOfWaysSatisfyingRightCell.get(i) == costOfCurrentCell) {
				numberOfWaysToReachLastCellFromHere++;
			}
		}
		for (int i=0; i<NumberOfWaysSatisfyingDownCell.size(); i++) {
			if (NumberOfWaysSatisfyingDownCell.get(i) == costOfCurrentCell) {
				numberOfWaysToReachLastCellFromHere++;
			}
		}
		return numberOfWaysToReachLastCellFromHere;
	}
	
	//Calculate number ways
	public void setNumberOfWaysToComeHereFromRightOfDown() {
		numberOfWaysToComeHereFromRightOrDown = NumberOfWaysSatisfyingDownCell.size() + NumberOfWaysSatisfyingRightCell.size();
		System.out.println("Number of ways to come here from right to down: "+numberOfWaysToComeHereFromRightOrDown);
		for (int i=0; i<NumberOfWaysSatisfyingDownCell.size(); i++) {
			System.out.println("Down Array: " + NumberOfWaysSatisfyingDownCell);
		}
		for (int i=0; i<NumberOfWaysSatisfyingRightCell.size(); i++) {
			System.out.println("Right Array: " + NumberOfWaysSatisfyingRightCell);
		}
	}
	
	//Calculate number of ways to come here from Right cell
		public void calculateNumberOfWaysSatifyingRightCell(){
			if(rightCell == null) { 
				return;
			}
			
			int sizeOfRightCellsRight = rightCell.NumberOfWaysSatisfyingRightCell.size();
			int sizeOfRightCellsDown  = rightCell.NumberOfWaysSatisfyingDownCell.size();
			
			for(int i=0; i<sizeOfRightCellsRight; i++) {
				if(rightCell.NumberOfWaysSatisfyingRightCell.get(i) >= rightCell.costOfCurrentCell) {
					NumberOfWaysSatisfyingRightCell.add(rightCell.NumberOfWaysSatisfyingRightCell.get(i)-rightCell.costOfCurrentCell);
				}
			}//end of loop
			
			for(int i=0; i<sizeOfRightCellsDown; i++) {
				if(rightCell.NumberOfWaysSatisfyingDownCell.get(i) >= rightCell.costOfCurrentCell) {
					NumberOfWaysSatisfyingRightCell.add(rightCell.NumberOfWaysSatisfyingDownCell.get(i)-rightCell.costOfCurrentCell);
				}
			}//end of loop
		}//end of method
		
		
		//Calculate number of ways to come here from Down cell
		public void calculateNumberOfWaysSatifyingDownCell(){
			if((downCell == null) && (rightCell == null)) { //Base case for last row and col
				NumberOfWaysSatisfyingDownCell.add(costToReachLastCell);
			}
			
			if(downCell == null) {
				return;
			}
			
			int sizeOfDownCellsRight = downCell.NumberOfWaysSatisfyingRightCell.size();
			int sizeOfDownCellsDown = downCell.NumberOfWaysSatisfyingDownCell.size();
			
			for(int i=0; i<sizeOfDownCellsRight; i++) {
				if(downCell.NumberOfWaysSatisfyingRightCell.get(i) >= downCell.costOfCurrentCell) {
					NumberOfWaysSatisfyingDownCell.add(downCell.NumberOfWaysSatisfyingRightCell.get(i)-downCell.costOfCurrentCell);
				}
			}//end of loop
			
			for(int i=0; i<sizeOfDownCellsDown; i++) {
				if(downCell.NumberOfWaysSatisfyingDownCell.get(i) >= downCell.costOfCurrentCell) {
					NumberOfWaysSatisfyingDownCell.add(downCell.NumberOfWaysSatisfyingDownCell.get(i)-downCell.costOfCurrentCell);
				}
			}//end of loop
		}//end of method
	
}
