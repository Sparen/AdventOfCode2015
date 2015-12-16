import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Stack;
import java.util.Arrays;

public class Driver {

    public Driver() {
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(args[0]));
	long finalamount = 0l;
	long ribbonlength = 0l;
	while (scan.hasNext()) {
	    String line = scan.next();
	    Scanner parser = new Scanner(line);
	    parser.useDelimiter("x");
	    int l = parser.nextInt();
	    int w = parser.nextInt();
	    int h = parser.nextInt();
	    //Smallest side
	    if (l >= w && l >= h) {
		finalamount += w*h;
	    } else if (w >= l && w >= h) {
		finalamount += l*h;
	    } else if (h >= w && h >= l) {
		finalamount += w*l;
	    }
	    //Smallest perimeter
	    int[] perims = {2*l + 2*w, 2*w + 2*h, 2*h + 2*l};
	    Arrays.sort(perims);
	    ribbonlength += perims[0]; //min
	    //Surface Area
	    finalamount += 2*l*w;
	    finalamount += 2*h*w;
	    finalamount += 2*l*h;
	    //System.out.println("L W H Final: " + " " + l + " " + w + " " + h + " " + finalamount);
	    //Volume
	    ribbonlength += l*w*h;
	}
	System.out.println("Final Amount: " + finalamount);
	System.out.println("Final Ribbon: " + ribbonlength);
    }
}