package stringBst;
/** This BST is used to find max occuring string and it should be of length >= 10.
 * Note : file contains large number of strings.
 * All methods are made by me.
 * THANKS for reading.......
 * 
 * @author ABHINAV GUPTA
 *
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Stream;

public class Node {
	String data;
	Node left,right;
	int count;
	Node(){
		this.data="";
		this.left = this.right = null;
		this.count = 0;
	}
	Node(String data){
		this.data=data;
		this.left = this.right = null;
		this.count = 1;
	}
	Node root;
	public void insert(String data){
		if(data.length() >= 10)
			root = insert(root, data);
		else
			return;
	}
	private Node insert(Node root, String data) {
		if (root == null)
			return new Node(data);
		if (root.data.equals(data)){
			root.count+=1;
		}else if (root.data.compareTo(data) < 0) {
			root.right = insert(root.right,data);
		} else if(root.data.compareTo(data) > 0)
			root.left = insert(root.left,data);
		return root;
	}
	public void inOrder(){
		int max[]=new int[2];
		String data[] = new String[2];
		inOrder(root,max,data);
		System.out.println("\nMax = "+max[0]+" -> "+data[0]);
	}
	private void inOrder(Node root,int[] max,String[] data) {
		if (root == null)
			return;
		inOrder(root.left,max,data);
		if (root.count > max[0]){
			max[0] = root.count;
			data[0] = root.data;
		}
		//System.out.println(root.count+"->"+root.data);
		inOrder(root.right,max,data);
	}
	public void files(String name) throws FileNotFoundException{
		Node ans = null;
		try {
			fileIn(ans,name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void fileIn(Node root, String name) throws IOException {
		File file = new File(name);
		Scanner cin = new Scanner(file);
		while(cin.hasNextLine()) {
			String input = cin.nextLine();
			//System.out.println(input);
			
			Stream.of(input.split(" ")).forEach(x -> insert(x));
		}
		System.out.println("");
		inOrder();
	}
}
