package net.frankium.sunwaydiit.assignment.Assignment2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AirplaneCabin {
	private static final char[] INDICATIONS = {'X','*'};
	private static final boolean O = true; //Occupied
	private static final boolean U = false; //Unoccupied
	private static final Map<Character,Integer> COL_MAP = new HashMap<Character,Integer>(){{for(int i = 0; i < 6 ; i ++){ put((char)('A' + (char) i),i); }}};
	private final int[] CLASSES_DISTRIBUTION;
	private List<Boolean[]> seatsState = new ArrayList<Boolean[]>();
	public AirplaneCabin(int[] classesDistribution){
		this.CLASSES_DISTRIBUTION = classesDistribution;
		for (int i = 0 ; i < CLASSES_DISTRIBUTION[0] + CLASSES_DISTRIBUTION[1] + CLASSES_DISTRIBUTION[2] ; i++){
			seatsState.add(new Boolean[]{U, U, U, U, U, U});
		}
	}
	public boolean isSpaceEmpty(int row, char col){
		return !(seatsState.get(row - 1)[COL_MAP.get(col)]);
	}
	public void setSeatState(int row, char col, boolean stateOccupied){
		seatsState.get(row - 1)[COL_MAP.get(col)] = stateOccupied;
	}
	public void displaySeatTable(){
		String message = "\n    CLASS TYPE   ROWS           COLUMNS\n\n                         A   B   C   D   E   F\n\n";
		for (int i = 0 ; i < CLASSES_DISTRIBUTION[0] + CLASSES_DISTRIBUTION[1] + CLASSES_DISTRIBUTION[2] ; i++) {
			if (i == 0) message += "   FIRST CLASS   ";
			else if (i == CLASSES_DISTRIBUTION[0]) message += "BUSINESS CLASS   ";
			else if (i == CLASSES_DISTRIBUTION[1] + CLASSES_DISTRIBUTION[0]) message += " ECONOMY CLASS   ";
			else message += "                 ";
			String s =new String(new char[8 - Integer.toString(i+1).length()]).replace("\0", " ");
			message += i+1 + s;
			for (int j = 0; j < 6; j++){
				if (seatsState.get(i)[j]) message += INDICATIONS[0];
				else message += INDICATIONS[1];
				message += "   ";
			}
			message += "\n";
		}
		System.out.print(message);
		System.out.println("[* = Available Seat, X = Occupied Seat]");
	}
	public int[] getCLASSES_DISTRIBUTION (){
		return this.CLASSES_DISTRIBUTION;
	}
}
