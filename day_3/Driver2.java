import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Driver2 {

    public Driver2() {
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(args[0]));
	String line = scan.next();
	int numvisited = 0;
	int x = 0;
	int y = 0;
	int xr = 0;
	int yr = 0;
	int state = 0; //0 santa 1 robo
	ArrayList<String> visited = new ArrayList<String>();
	for (int i = 0; i < line.length(); i++) {
	    //Add first, move later
	    String genstring = (state == 0) ? "" + x + "," + y : "" + xr + "," + yr;
	    if (!visited.contains(genstring)) {
		numvisited++;
		visited.add(genstring);
	    }
	    //Determine next
	    char c = line.charAt(i);
	    if (c == '<') {
		if (state == 0) {
		    x--;
		} else {
		    xr--;
		}
	    } else if (c == '>') {
		if (state == 0) {
		    x++;
		} else {
		    xr++;
		}
	    } else if (c == 'v') {
		if (state == 0) {
		    y++;
		} else {
		    yr++;
		}
	    } else if (c == '^') {
		if (state == 0) {
		    y--;
		} else {
		    yr--;
		}
	    }
	    state = (state == 0) ? 1 : 0;
	}
	System.out.println("Houses Visited: " + numvisited);
    }
}