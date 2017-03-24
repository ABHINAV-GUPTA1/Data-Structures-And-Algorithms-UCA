package binarySearchTree;

/** This is main function in which we call BST tree method using Node class.
 * Available methods : insert(data), delete(data), inOrder(), preOrder(),preSucc()
 *  
 * 
 * @author <a href="mailto:abhig605@gmail.com">ABHINAV GUPTA</a>
 * 
 */
public class Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node a = new Node();
		a.insert(10);
		a.insert(9);
		a.insert(12);
		a.insert(11);
		a.insert(13);
		a.insert(2);
		a.insert(3);
		a.insert(4);
		a.insert(5);
		a.insert(6);
		a.insert(7);
		a.insert(8);
		a.insert(1);
		/*a.insert(50);
		a.insert(30);
		a.insert(70);
		a.insert(60);
		a.insert(80);
		a.insert(20);
		a.insert(40);
		a.insert(65);
		a.insert(66);
		a.insert(67);
		a.insert(68);*/
		a.inOrder();
		/*a.search(30);
		a.search(80);
		a.search(100);
		a.search(3);*/
		//System.out.println("\n--------------------------------");
		//a.delete(30);
		//a.inOrder();
		System.out.println("\n--------------------------------");
		/*a.delete(80);
		a.delete(70);
		a.delete(60);
		a.delete(50);
		a.delete(30);
		a.delete(20);
		a.delete(40);*/
		//a.inOrder();
		//System.out.println("\nMin value = "+a.minVal());
		//System.out.println("\nMax value = "+a.maxVal());
		/*a.preSucc(65);
		System.out.println("\nPre = "+a.pre+" Succ = "+a.suc);
		a.preSucc(50);
		System.out.println("\nPre = "+a.pre+" Succ = "+a.suc);
		a.preSucc(55);
		System.out.println("\nPre = "+a.pre+" Succ = "+a.suc);
		*/
		//System.out.println("\n"+a.isBST());
		//System.out.println("\nLCA of 40 and 80 is "+a.lca(40,80));
		//System.out.println("Inorder Successor of 20 = "+a.inOrderSucc(30));
		/*try {
			System.out.println("Kth Element = "+a.kthElement(7));
		} catch(IndexOutOfBoundsException e) {
			System.out.println("Kth Element doesnot exist");
		}*/
		//System.out.println(a.ceil(45));
		//System.out.println(a.pairFind(20));
		//a.pairFind(150);
		//System.out.println(a.rank(4));
		/*a.deleteMin();
		System.out.print("\tDELETE MIN");
		System.out.println("\n--------------------------------");
		a.inOrder();
		a.deleteMax();
		System.out.print("\n\tDELETE MAX");
		System.out.println("\n--------------------------------");*/
		//a.inOrder();
		//a.delete_left(50);
		//a.delete_sir_right(50);
		//a.delete_sir_right(50);
		//a.inOrder();
		//System.out.println("\n-----------------------------");
		//a.levelOrder();
		//a.getRank(70);
		//System.out.println(a.getHeight());
		//a.deleteTree();
		//a.inOrder();
		/*a.preOrder();
		System.out.println("------------------");
		a.cloneTree();
		System.out.println("\n---------------");
		System.out.println("Inorder of tree");
		a.inOrder();*/
		//System.out.println(a.isBST());
		//a.generateBST();
		//System.out.println(a.floor(65));
		//System.out.println(a.ceil(65));
		
		//a.dll();
		//int arr[] = {50,39,44,28,85};
		//int arr[] = {50,99,44,85};
		//a.validBST(arr);
		//a.top_view();
		//a.bottom_view();
		a.zigzag();
		System.out.println();
		//a.zigzagTraversal();
		a.zigzagEvenOdd();
	}
	
}
