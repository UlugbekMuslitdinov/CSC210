import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class PA11Main {

    public static void main(String[] args) {
        int start = 0;
        int nodes = 0;
        int edges = 0;
        List<Integer> path = new ArrayList<>();
        String fileName = args[0];
        String command = args[1];
        DGraph dg = new DGraph();

        try {
            File file = new File(fileName);
            Scanner fileReader = new Scanner(file);
            boolean firstLine = false;
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                if (line.charAt(0) != '%') {
                    if (firstLine == false) {
                        String[] items = line.split(" ");
                        if (items.length == 3) {
                            start = Integer.parseInt(items[0]);
                            nodes = Integer.parseInt(items[1]);
                            edges = Integer.parseInt(items[2]);
                            for (int i = 1; i <= nodes; i++) {
                                path.add(i);
                            }
                            firstLine = true;
                        }
                    } else {
                        String[] items = line.split(" ");
                        if (items.length == 3) {
                            int u = Integer.parseInt(items[0]);
                            int v = Integer.parseInt(items[1]);
                            double w = Double.parseDouble(items[2]);
                            dg.addEdge(u, v, w);
                        }
                    }
                }
            }
            fileReader.close();
            if (command.equals("HEURISTIC")) {
                dg.heuristic(1);
            }
            if (command.equals("BACKTRACKING")) {
                dg.backtracking(1);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
