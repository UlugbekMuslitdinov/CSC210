import java.util.Scanner;

public class BattleShip {
	private String[][] battleMap = new String[5][5];
	private String[][] defendMap = new String[5][5];
	private static Scanner scan = new Scanner(System.in);
	
	
	public void initMap() {
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				this.battleMap[i][j] = "█";
			}
		}
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				this.defendMap[i][j] = "█";
			}
		}
	}
	
	
	public void printBattleMap() {
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				System.out.print(this.defendMap[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				System.out.print(this.battleMap[i][j]);
			}
			System.out.println();
		}
	}

	
	public void placeShipCell(String cellNum) {
		char columnchar = cellNum.charAt(1);
		int column = Integer.parseInt(Character.toString(columnchar));
		int row = cellRow(cellNum);
		
		this.battleMap[row][column] = "C";
	}
	
	public void locateShipRandomly() {
		int center_x;
		int center_y;

		center_x = (int) (Math.random()*3+1);
		center_y = (int) (Math.random()*3+1);
		if (Math.random() >= 0.5) {  // If random number is greater or equal to 0.5,
			// ship will be located horizontally, else vertically
			if (this.battleMap[center_y][center_x] != "C" && this.battleMap[center_y][center_x-1] != "C" && this.battleMap[center_y][center_x+1] != "C") {
				this.battleMap[center_y][center_x] = "C";
				this.battleMap[center_y][center_x-1] = "C";
				this.battleMap[center_y][center_x+1] = "C";
			} else {
				locateShipRandomly();
			}
		} else {
			if (this.battleMap[center_y][center_x] != "C" && this.battleMap[center_y+1][center_x] != "C" && this.battleMap[center_y-1][center_x] != "C") {
				this.battleMap[center_y][center_x] = "C";
				this.battleMap[center_y+1][center_x] = "C";
				this.battleMap[center_y-1][center_x] = "C";
			}else {
				locateShipRandomly();
			}
		}
	}
	
	public static int cellRow(String cell) {
		char firstchar = cell.charAt(0);
		
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
		
		return row;
	}
	
	public void makeShot(BattleShip enemyMap, String cell) {
		int row = cellRow(cell);
		char columnchar = cell.charAt(1);
		int column = Integer.parseInt(Character.toString(columnchar));
		
		if (enemyMap.battleMap[row][column] == "C") {
			enemyMap.battleMap[row][column] = "H";
			this.defendMap[row][column] = "H";
		} else if (enemyMap.battleMap[row][column] == "█") {
			enemyMap.battleMap[row][column] = "M";
			this.defendMap[row][column] = "M";
		}
	}
	
	public void makeRandomShot(BattleShip enemyMap) {
		int row = (int) (Math.random()*5);
		int column = (int) (Math.random()*5);
		System.out.println(row + " " + column);
		if (enemyMap.battleMap[row][column] == "C") {
			enemyMap.battleMap[row][column] = "H";
			this.defendMap[row][column] = "H";
		} else if (enemyMap.battleMap[row][column] == "█") {
			enemyMap.battleMap[row][column] = "M";
			this.defendMap[row][column] = "M";
		}
	}
	
	public boolean isDefeated() {
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				if (this.battleMap[i][j] == "C") {
					return false;
				}
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		// Define variables
		String position;
		String userName;
		String attackCell;
		
		// Initialize map for user
		BattleShip userMap = new BattleShip();
		userMap.initMap();
		
		// Initialize map for computer
		BattleShip computerMap = new BattleShip();
		computerMap.initMap();
		
		for (int i=0; i<2; i++) {
			computerMap.locateShipRandomly();
		}
		computerMap.printBattleMap();
		
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
		
		userMap.printBattleMap();
		
		while (true) {
			System.out.println("Call your shot " + userName + "!");
			System.out.println("Enter the row and column (eg. B2):");
			attackCell = scan.next();
			userMap.makeShot(computerMap, attackCell);
			userMap.printBattleMap();
			scan.nextLine();
			System.out.print("Press the enter key to see the computer's shot:");
			scan.nextLine();
			computerMap.makeRandomShot(userMap);
			userMap.printBattleMap();
			
			if (userMap.isDefeated()) {
				System.out.println("You lose " + userName + " !!!");
			} else if (computerMap.isDefeated()) {
				System.out.println("You win " + userName + " !!!");
			}
		}
		
	}
}
