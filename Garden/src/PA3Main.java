import java.util.Scanner;
public class PA3Main {
	Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
//		filename = input.nextLine();
//		openFile = new File(filename);
		Garden garden = new Garden(5, 5);
		
		garden.plant("Iris", 0, 0);
		garden.plant("Lily", 0, 2);
		garden.plant("Coconut", 0, 4);

		garden.printMap();
	}

}
