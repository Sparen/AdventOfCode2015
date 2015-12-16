import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Driver {

    public Driver() {
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(args[0]));
	String line = scan.next();
	int numvisited = 0;
	int x = 0;
	int y = 0;
	ArrayList<String> visited = new ArrayList<String>();
	for (int i = 0; i < line.length(); i++) {
	    //Add first, move later
	    String genstring = "" + x + "," + y;
	    if (!visited.contains(genstring)) {
		numvisited++;
		visited.add(genstring);
	    }
	    //Determine next
	    char c = line.charAt(i);
	    if (c == '<') {
		x--;
	    } else if (c == '>') {
		x++;
	    } else if (c == 'v') {
		y++;
	    } else if (c == '^') {
		y--;
	    }
	}
	System.out.println("Houses Visited: " + numvisited);
    }
}