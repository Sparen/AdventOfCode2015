import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Driver {

    public Driver() {
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(args[0]));
	String line = scan.next();
        int floor = 0;
	boolean basementreported = false;
	for (int i = 0; i < line.length(); i++) {
	    if (line.charAt(i) == '(') {
		floor++;
	    } else {
		floor--;
	    }
	    if (floor == -1 && basementreported == false) {
		System.out.println("Basement Entered at Character:" + (i + 1));
		basementreported = true;
	    }
	}
	System.out.println("Final Floor: " + floor);
    }
}