package net.frankium.sunwaydiit.assignment.Assignment2;

import java.util.Scanner;

public class Question2 {
	private static AirplaneCabin cabin = new AirplaneCabin(new int[]{2,5,6});
	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args){
		while (true) {
			switch (getMenuOption("Thank you for using the seat selection system", new String[]{"View Current Available Seats","Book a new seat","Exit"})){
				case 0:
					cabin.displaySeatTable();
					break;
				case 1:
					int classChoice = getMenuOption("Which class do you wish to book?", new String[]{"First Class","Business Class","Economy Class"});
					int rowChoice;
					char columnChoice;
					int[] range = new int[2];
					switch (classChoice){
						case 0: range = new int[]{1,cabin.getCLASSES_DISTRIBUTION()[0]}; break;
						case 1: range = new int[]{cabin.getCLASSES_DISTRIBUTION()[0]+1,cabin.getCLASSES_DISTRIBUTION()[0]+cabin.getCLASSES_DISTRIBUTION()[1]}; break;
						case 2: range = new int[]{cabin.getCLASSES_DISTRIBUTION()[0]+cabin.getCLASSES_DISTRIBUTION()[1]+1,cabin.getCLASSES_DISTRIBUTION()[0]+cabin.getCLASSES_DISTRIBUTION()[1]+cabin.getCLASSES_DISTRIBUTION()[2]}; break;
					}
					while (true){
						System.out.println("Please input a row number you wish to choose");
						System.out.println("("+range[0]+"~"+range[1]+"):");
						try{
							rowChoice = Integer.parseInt(input.nextLine().substring(0));
							if (rowChoice < range[0] || rowChoice > range[1]) throw new Exception();
							break;
						}catch(Exception e){
							System.out.println("Error. Please Re-enter.");
						}
					}
					while (true){
						System.out.println("Please input a column number you wish to choose");
						System.out.println("(A~F):");
						try{
							columnChoice = input.nextLine().charAt(0);
							if (columnChoice < 'A' || columnChoice > 'F') throw new Exception();
							break;
						}catch(Exception e){
							System.out.println("Error. Please Re-enter.");
						}
					}
					if (cabin.isSpaceEmpty(rowChoice,columnChoice)){
						cabin.setSeatState(rowChoice,columnChoice,true);
						System.out.println("Booked!");
					}else System.out.println("Seat is already occupied!");
					break;
				case 2:
					System.out.println("Thank you for using the system, see you next time!");
					System.exit(0);
					break;
			}
		}
	}
	private static int getMenuOption(String title, String[] options){
		System.out.println("\n|================================");
		while (true){
			System.out.println("| > "+title+"\n|");
			for (int i = 0; i < options.length; i++){
				System.out.println("|   "+i+" - "+options[i]);
			}
			System.out.print("| \n| > Please select an option by entering a number from (0~"+(options.length-1)+") and press Enter\n| > ");
			String raw = input.nextLine();
			try{
				int index = Integer.parseInt(raw.substring(0));
				if (index >= 0 && index < options.length){
					System.out.print("|================================\n");
					return index;
				}
				else throw new Exception("");
			}catch(Exception e){
				System.out.println("| \n| Error. Please Re-enter.\n| ");
			};
		}
	}
}
