import java.util.Scanner;

public class BattleShip {
	private static String[][] battleMap = new String[5][5];
	private static String[][] defendMap = new String[5][5];
	private static Scanner scan = new Scanner(System.in);
	
	
	public void initMap() {
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				battleMap[i][j] = "█";
			}
		}
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				defendMap[i][j] = "█";
			}
		}
	}
	
	
	public void printMap() {
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				System.out.print(battleMap[i][j]);
			}
			System.out.println();
		}
	}
	
	
	public void placeShipCell(String cellNum) {
		char firstchar = cellNum.charAt(0);
		char columnchar = cellNum.charAt(1);
		int column = Integer.parseInt(Character.toString(columnchar));
		
		int row = 0;
		if (firstchar == 'A') {
			row = 0;
		} else if (firstchar == 'B') {
			row = 1;
		} else if (firstchar == 'C') {
			row = 2;
		} else if (firstchar == 'D') {
			row = 3;
		} else if (firstchar == 'E') {
			row = 4;
		}
		
		battleMap[row][column] = "C";
	}
	
	public void locateShipsRandomly() {
		char align;
		int center_x;
		int center_y;
		
		for (int i=0; i<2; i++) {
			center_x = (int) (Math.random()*3+1);
			center_y = (int) (Math.random()*3+1);
			if (Math.random() >= 0.5) {  // If random number is greater or equal to 0.5,
				align = 'h'; 			// ship will be located horizontally, else vertically
				battleMap[center_y][center_x] = "C";
				battleMap[center_y][center_x-1] = "C";
				battleMap[center_y][center_x+1] = "C";
			} else {
				align = 'v';
				battleMap[center_y][center_x] = "C";
				battleMap[center_y+1][center_x] = "C";
				battleMap[center_y-1][center_x] = "C";
			}
			
		}
	}
	
	
	public static void main(String[] args) {
		// Define variables
		String position;
		String userName;
		
		// Initialize map for user
		BattleShip userMap = new BattleShip();
		userMap.initMap();
		
		// Initialize map for computer
		BattleShip computerMap = new BattleShip();
		computerMap.initMap();
		
		computerMap.locateShipsRandomly();
		computerMap.printMap();
		
		System.out.println("What is your first name?");
		userName = scan.next();
		System.out.println("Place your ships " + userName);
		System.out.println("You have two cruisers that are both of length 3.");
		
		for (int shipNum=0; shipNum<2; shipNum++) {
			System.out.println("Place your ship number " + (shipNum+1));
			for (int pos=0; pos<3; pos++) {
				System.out.println("Enter the row and column (eg. B2):");
				position = scan.next();
				userMap.placeShipCell(position);
			}
		}
		
		userMap.printMap();
	}

}
