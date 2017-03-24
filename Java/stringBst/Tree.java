package stringBst;
/** This BST is used to find max occuring string and it should be of length >= 10.
 * Note : file contains large number of strings.
 * All methods are made by me.
 * THANKS for reading.......
 * 
 * @author ABHINAV GUPTA
 *
 */
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Tree {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		String name = cin.nextLine(); // Input file name with absolute path.
		Node a = new Node();
		try {
			a.files(name);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
