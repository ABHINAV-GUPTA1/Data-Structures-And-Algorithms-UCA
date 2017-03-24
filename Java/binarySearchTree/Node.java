package binarySearchTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

/** This BST class whose object can be used to traverse,search,delete,insert etc.
 * All methods are made by me.
 * THANKS for reading.......
 * 
 * @author ABHINAV GUPTA
 *
 */
public class Node implements Comparable<Node>{
	int data;
	Node left,right;
	Node next,pre1;
	int N=1;
	Node(){
		N = 1;
		left = right = null;
		next = pre1 = null;
	}
	Node(int data) {
		this.data = data;
		//this.N = 1;
		left = right = null;
		next = pre1 = null;
	}
	Node(int data,int N) {
		this.data = data;
		this.N = N;
		left = right = null;
		next = pre1 = null;
	}
	Node root;
	///////////////////////////////////////////////////////////////////
	//////////////////////INSERT///////////////////////////////////////
	//////////////////////////////////////////////////////////////////
	public void insert(int data) {
		root = insert(root,data);
	}
	private Node insert(Node root, int data) {
		if (root == null)
			return new Node(data);
		if (root.data < data) {
			root.right = insert(root.right,data);
			root.N = 1 + sizeOf(root.left)+ sizeOf(root.right);
		} else if(root.data > data)
			root.left = insert(root.left,data);
		return root;
	}
	///////////////////////////////////////////////////////////////////
	///////////////////////////Inorder////////////////////////////////
	//////////////////////////////////////////////////////////////////
	public void inOrder(){
		inOrder(root);
	}
	private void inOrder(Node root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data+"->");
		inOrder(root.right);
	}
	////////////////////////////////////////////////////////////////
	////////////////////////////Search/////////////////////////////
	//////////////////////////////////////////////////////////////
	public void search(int data) {
		Node a;
		a = search(root,data);
		if (a == null) {
			System.out.println("\nELEMENT NOT FOUND");
		} else {
			System.out.println("\nELEMENT FOUND = "+a.data);
		}
	}
	private Node search(Node root, int data) {
		if(root == null)
			return null;
		if(root.data > data)
			return search(root.left,data);
		else if(root.data < data) {
			return search(root.right,data);
		}
		return root;
	}
	////////////////////////////////////////////////////////////////////
	////////////////////////////Delete/////////////////////////////////
	//////////////////////////////////////////////////////////////////
	public void delete(int data) {
		root = delete(root,data);
	}
	private Node delete(Node root,int data) {
		if(root == null)
			return root;
		if (root.data > data)
			root.left = delete(root.left,data);
		else if(root.data < data)
			root.right = delete(root.right,data);
		else {
			if(root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			
			root.data = minval(root.right);
			root.right = delete(root.right,root.data);
		}
		return root;
	}
	private int minval(Node root) {
		int minv = root.data;
		while(root.left != null){
			minv = root.left.data;
			root = root.left;
		}
		return minv;
	}
	//////////////////////////////////////////////////////////
	////////////////////////MinVal///////////////////////////
	/////////////////////////////////////////////////////////
	public int minVal(){
		return minVal(root);
	}
	private int minVal(Node root) {
		if (root == null)
			return -1;
		while (root.left != null)
			root = root.left;
		return root.data;
	}
	//////////////////////////////////////////////////////////
	////////////////////////MaxVal///////////////////////////
	/////////////////////////////////////////////////////////
	public int maxVal(){
		return maxVal(root);
	}
	private int maxVal(Node root) {
		if (root == null)
			return -1;
		while (root.right != null)
			root = root.right;
		return root.data;
	}
	//////////////////////////////////////////////////////////
	////////////////////////PreSucc///////////////////////////
	/////////////////////////////////////////////////////////
	public static int pre,suc;
	public void preSucc(int data) {
		preSucc(root,data);
	}
	private void preSucc(Node root,int data) {
		if (root == null)
			return;
		if(root.data == data) {
			if (root.left != null) {
				Node tmp = root.left;
				while(tmp.right != null)
					tmp = tmp.right;
				pre = tmp.data;
			}
			if(root.right != null) {
				Node tmp = root.right;
				while(tmp.left != null)
					tmp = tmp.left;
				suc = tmp.data;
			}
			return;
		}
		if(root.data > data) {
			suc = root.data;
			preSucc(root.left, data);
		} else {
			pre = root.data;
			preSucc(root.right, data);
		}		
	}
	//////////////////////////////////////////////////////////
	////////////////////////isBst///////////////////////////
	/////////////////////////////////////////////////////////	
	Node prev;
	public boolean isBST(){
		//return isBSTUtil(root,Integer.MIN_VALUE,Integer.MIN_VALUE);
		prev = null;
		return isBSTUtil(root);
	}
	/*private boolean isBSTUtil(Node root,int minVal,int maxVal) {
		if (root == null)
			return true;
		if(root.data < minVal || root.data > maxVal)
			return false;
		return (isBSTUtil(root.left,minVal,root.data-1)) && (isBSTUtil(root.right,root.data+1,maxVal));
	}*/
	private boolean isBSTUtil(Node root) {
		if(root!=null){
			if(!isBSTUtil(root.left))
				return false;
			if(prev!=null && prev.data >= root.data)
				return false;
			prev = root;
			return isBSTUtil(root.right);
		}
		return true;
	}
	//////////////////////////////////////////////////////////
	////////////////////////LCA///////////////////////////
	/////////////////////////////////////////////////////////	
	public int lca(int n1,int n2) {
		 Node n = lca(root,n1,n2);
		 if(n != null)
			 return n.data;
		 return -1;
	}
	private Node lca(Node root,int n1,int n2) {
		if(root == null)
			return null;
		if(root.data < n1 && root.data < n2)
			return lca(root.right,n1,n2);
		if(root.data > n1 && root.data > n2)
			return lca(root.left,n1,n2);
		return root;
	}
	//////////////////////////////////////////////////////////
	////////////////////////Inorder Successor/////////////////
	/////////////////////////////////////////////////////////	
	public int inOrderSucc(int data) {
		Node a = search(root,data);
		if (a!=null){
			Node b = inOrderSucc(root,a);
			if (b != null)
				return b.data;
			return -1;
		}
		return -1;
	}
	private Node minVAL(Node root) {
		if (root == null)
			return null;
		while (root.left != null)
			root = root.left;
		return root;
	}
	private Node inOrderSucc(Node root,Node n) {
		if (n.right != null)
			return minVAL(n.right);
		Node succ = null;
		while (root != null) {
			if (n.data < root.data){
				succ = root;
				root = root.left;
			} else if (n.data > root.data)
				root = root.right;
			else
				break;
		}
		return succ;
	}
	//////////////////////////////////////////////////////////
	////////////////////////getKthElement/////////////////
	/////////////////////////////////////////////////////////	
	public int kthElement(int k) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		ArrayList<Integer> ll = new ArrayList<Integer>();
		ll = inOrder_k(root,l);
		return ll.get(k-1);
	}
	private ArrayList<Integer> inOrder_k(Node root,ArrayList<Integer> l) {
		if (root == null)
			return l;
		else {
			inOrder_k(root.left,l);
			l.add(root.data);
			inOrder_k(root.right,l);
		}
		return l;
	}
	//////////////////////////////////////////////////////////
	////////////////////////getKthElement/////////////////
	/////////////////////////////////////////////////////////
	public int ceil(int data) {
		return ceil(root,data);
	}
	private int ceil(Node root, int data) {
		if (root == null)
			return -1;
		if (root.data == data)
			return root.data;
		if(root.data<data)
			return ceil(root.right,data);
		int ceil = ceil(root.left,data);
		return ceil>=data?ceil:root.data;
	}
	//////////////////////////////////////////////////////////
	////////////////////////getKthElement/////////////////
	/////////////////////////////////////////////////////////
	public boolean pairFind(int sum) {
		return pairFind(root,sum);
	}
	private boolean pairFind(Node root, int sum) {
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		boolean done1 = false, done2 = false;
		int val1 = 0, val2 = 0;
		Node c1 = root, c2 = root;
		while(true) {
			while (done1 == false) {
				if (c1 != null) {
					s1.add(c1);
					c1 = c1.left;
				} else {
					if(s1.isEmpty())
						done1 = true;
					else {
						c1 = s1.pop();
						val1 = c1.data;
						c1 = c1.right;
						done1 = true;
					}
				}
			}
			while(done2 == false) {
				if(c2!=null) {
					s2.push(c2);
					c2 = c2.right;
				} else {
					if(s2.isEmpty()) 
						done2 = true;
					else {
						c2 = s2.pop();
						val2 = c2.data;
						c2 = c2.left;
						done2 = true;
					}
				}
			}
			if(val1 != val2 && (val1 + val2) == sum) {
				System.out.println("(Val1 = "+val1+" Val2 = "+val2+") = Sum "+sum);
				return true;
			} else if(val1 + val2 < sum)
				done1 = false;
			else if(val1+val2 > sum)
				done2 = false;
			else if(val1 >= val2)
				return false;
		}
	}
	/////////////////////////////////////////////////////////////
	///////////////////Rank/////////////////////////////////////
	///////////////////////////////////////////////////////////
	/*public int rank(int k) {
		return inOrder_rank(root,k);
	}
	private int inOrder_rank(Node root,int k) {
		if (root == null)
			return -1;
		else {
			inOrder_k(root.left,l);
			l.add(root.data);
			inOrder_k(root.right,l);
		}
		return l;
	}*/
	///////////////////////////////////////////////////////////
	//////////////////DELETE min//////////////////////////////
	//////////////////////////////////////////////////////////
	public void deleteMin(){
		root = deleteMin(root);
	}
	private Node deleteMin(Node root) {
		if (root.left == null)
			return root.right;
		root.left = deleteMin(root.left);
		return root;
	}
	///////////////////////////////////////////////////////////
	//////////////////DELETE max//////////////////////////////
	//////////////////////////////////////////////////////////
	public void deleteMax(){
		root = deleteMax(root);
	}
	private Node deleteMax(Node root) {
		if (root.right == null)
			return root.left;
		root.right = deleteMax(root.right);
		return root;
	}
	////////////////////////////////////////////////////////////////////
	////////////////////////////Delete/////////////////////////////////
	//////////////////////////////////////////////////////////////////
	public void delete_left(int data) {
		root = delete_left(root,data);
	}
	private Node delete_left(Node root,int data) {
		if(root == null)
			return root;
		if (root.data > data)
			root.left = delete(root.left,data);
		else if(root.data < data)
			root.right = delete(root.right,data);
		else {
			if(root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
	
			root.data = maxVal(root.left);
			root.left = delete(root.left,root.data);
		}
		return root;
	}	
	//////////////////////////////////////////////
	///////////////////PreOrder//////////////////
	////////////////////////////////////////////
	public void preOrder(){
		preOrder(root);
	}
	private void preOrder(Node root){
		if(root == null)
			return;
		System.out.print(root.data+"->");
		preOrder(root.left);
		preOrder(root.right);
	}
	//////////////////////////////////////////////////
	///////////////////Delete by Sir Logic Left///////
	/////////////////////////////////////////////////
	public void delete_sir_left(int data) {
		root = delete_sir_left(root,data);
	}
	private Node delete_sir_left(Node root,int data) {
		if(root == null)
			return root;
		if (root.data > data)
			root.left = delete(root.left,data);
		else if(root.data < data)
			root.right = delete(root.right,data);
		else {
			if(root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			Node t = root;
			root = max_Val(root.left);
			root.left = deleteMax(t.left);
			root.right = t.right;
		}
		return root;
	}
	private Node max_Val(Node root) {
		if (root == null)
			return null;
		while (root.right != null)
			root = root.right;
		return root;
	}
	/////////////////////////////////////////////////////////
	/////////////////////////Delete by Sir right////////////
	///////////////////////////////////////////////////////
	public void delete_sir_right(int data) {
		root = delete_sir_right(root,data);
	}
	private Node delete_sir_right(Node root,int data) {
		if(root == null)
			return root;
		if (root.data > data)
			root.left = delete(root.left,data);
		else if(root.data < data)
			root.right = delete(root.right,data);
		else {
			if(root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			Node t = root;
			root = min_Val(root.right);
			root.right = deleteMin(t.right);
			root.left = t.left;
		}
		return root;
	}
	private Node min_Val(Node root) {
		if (root == null)
			return null;
		while (root.left != null)
			root = root.left;
		return root;
	}
	//////////////////////////////////////////////////////////////
	/////////////////////////Level Order/////////////////////////
	////////////////////////////////////////////////////////////
	public void levelOrder() {
		levelOrder(root);
	}
	private void levelOrder(Node root) {
		if (root == null)
			return;
		Queue<Node> q1 = new LinkedList<Node>();
		q1.offer(root);
		while (!q1.isEmpty()) {
			Node t = q1.poll();
			System.out.print(t.data+"->");
			if(t.left != null)
				q1.offer(t.left);
			if(t.right != null)
				q1.offer(t.right);
		}
	}
	//////////////////////////////////////////////////////////
	////////////////////Rank/////////////////////////////////
	////////////////////////////////////////////////////////
	public void getRank(int k) {
		if(search(root, k) != null){
			int a = getRank(root,k);
			System.out.println("Rank is " + a);
		}else{
			System.out.println("Not found");
		}
	}
	private int sizeOf(Node root) {
		return root == null ? 0 : root.N;
	}
	private int getRank(Node root,int k) {
		if (k == root.data) 
			return sizeOf(root.left);
		else if (k < root.data) 
			return getRank(root.left,k);
		else
			return 1+sizeOf(root.left)+getRank(root.right,k);
	}
	/////////////////////////////////////////////////
	///////////////////////////////Height////////////
	/////////////////////////////////////////////////
	public int getHeight(){
		return getHeight(root);
	}
	private int getHeight(Node root){
		if(root == null)
			return 0;
		return 1 + Math.max(getHeight(root.left),getHeight(root.right));
	}
	///////////////////////////////////////////////////////
	//////////////////////////Delete Whole tree///////////
	/////////////////////////////////////////////////////
	public void deleteTree(){
		root = deleteTree(root);
	}
	private Node deleteTree(Node root) {
		if (root == null)
			return root;
		deleteTree(root.left);
		deleteTree(root.right);
		root = null;
		return root;
	}
	/////////////////////////////////////////////////////////////
	//////////////////////Clone Tree////////////////////////////
	///////////////////////////////////////////////////////////
	public void cloneTree() {
		ArrayList<Node> a = new ArrayList<>() ;
		a = cloneTree(root,a);
		System.out.println("\nCloned tree Array = ");
		for (int i=0; i < a.size(); i++)
			System.out.print(a.get(i).data+",");
		System.out.println("");
		Node b = null;
		for(int i = 0; i < a.size(); i++)
			b = insert(b, a.get(i).data);
		System.out.println("\nInorder of cloned tree");
		inOrder(b);
	}
	private ArrayList<Node> cloneTree(Node root,ArrayList<Node> a) {
		if (root == null)
			return a;
		a.add(root);
		cloneTree(root.left,a);
		cloneTree(root.right,a);
		return a;
	}
	/////////////////////////////////////////////////////////////////
	///////////////////////////Generate BST////////////////////////////////
	///////////////////////////////////////////////////////////////
	public void generateBST(){
		ArrayList<Node> a = cloneTree(root,new ArrayList<Node>());
		for (int i=0; i < a.size(); i++)
			System.out.print(a.get(i).data+",");
		System.out.println("\n-----------Sorted-------------------");
		/*for (int i = 0; i < a.size()-1; i++)
			for(int j = 0; j < a.size()-i-1;j++) {
				if(a.get(j).data > a.get(j+1).data) {
					int t = a.get(j).data;
					a.get(j).data = a.get(j+1).data;
					a.get(j+1).data = t;
				}
			}*/
		Collections.sort(a);
		for (int i=0; i < a.size(); i++)
			System.out.print(a.get(i).data+",");
		System.out.println("");
		Node b = null;
		int ab = a.get(a.size()/2).data;
		a.get(a.size()/2).data = a.get(0).data;
		a.get(0).data = ab;
		for (int i = 0; i < a.size(); i++)
			b = insert(b,a.get(i).data);
		preOrder(b);
	}
	@Override
	public int compareTo(Node a) {
		// TODO Auto-generated method stub
		if (this.data < a.data)
			return -1;
		else if(this.data > data)
			return 1;
		else
			return 0;
	}
	////////////////////////////////////////////////////////
	////////////////////Floor in BST///////////////////////
	//////////////////////////////////////////////////////
	public int floor(int data) {
		return floor(root,data);
	}
	private int floor(Node root, int data) {
		if (root == null)
			return -1;
		if (root.data == data)
			return root.data;
		if(root.data > data)
			return floor(root.left,data);
		int floor = floor(root.right,data);
		return floor != -1?floor:root.data;
	}
	//////////////////////////////////////////////////////
	//////Level Order using less space and recursion//////
	//////////////////////////////////////////////////////
	
	
	//////////////////////////////////////////////////////
	///////////////////////Tree to DLL////////////////////
	//////////////////////////////////////////////////////
	/*public void dll(){
		if (root == null) {
			System.out.println("EmptyList");
			return;
		}
		Stack<Node> st = new Stack<Node>();
		Node n = root;
		st.push(n);
		DoublyList dummy = new DoublyList(0);
		DoublyList dnode = dummy;
		
		while (!st.isEmpty()) {
			while (n != null && n.left != null) {
				st.push(n.left);
				n = n.left;
			}
			n = st.pop();
			DoublyList current = new DoublyList(n.data);
			dnode.next = current;
			current.prev = dnode;
			dnode = dnode.next;
			
			n = n.right;
			if (n != null)
				st.push(n);
		}
		print(dummy.next);
	}
	private void print(DoublyList a) {
		DoublyList c, b = a;
		c = b;
		while(b != null) {
			c = b;
			System.out.print(b.val +"->");
			b = b.next;
		}
		System.out.println("");
		b = c;
		while(b.prev != null) {
			System.out.print(b.val +"->");
			b = b.prev;
		}
	}*/
	/*
	private int countNodes(Node root) {
		return count(root,0);
	}
	private Node dll(Node root,Node a) {
		if (root == null)
			return null;
		//n -= 1;
		Node left = dll(root.left,a);
		//a.pre1 = left; 
		a.next = left;
		//a.pre1 = null;
		a.pre1 = dll(root.right,a);
		return a;
	}
	private int count(Node root,int i) {
		if (root  == null)
			return i;
		count(root.left,i+1);
		//System.out.print(root.data+ " ");
		count(root.right,i+1);
		return i;
	}*/
	/*private void dll(Node root) {
		if(root == null)
			return;
		ArrayList<Node> a = new ArrayList<>();
		DLL obj = new DLL();
		a = cloneTree(root, a);
		for (int i=0; i < a.size(); i++) {
			obj.insert(a.get(i).data);
			System.out.print(a.get(i).data+"->");
		}
		System.out.println();
		obj.print();
	}*/
	//////////////////////////////////////////////////////
	//////////////ValidBST///////////////////////////////
	////////////////////////////////////////////////////
	public void validBST(int arr[]) {
		if (preAns(arr))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	private boolean preAns(int arr[]) {
		int low = Integer.MIN_VALUE;
	    /*Stack<Integer> path = new Stack();
	    for (int p : arr) {
	        if (p < low)
	            return false;
	        while (!path.empty() && p > path.peek())
	            low = path.pop();
	        path.push(p);
	    }
	    return true;*/
		int i = -1;
		for (int p : arr) {
			if (p < low)
				return false;
			while (i >= 0 && p > arr[i])
				low = arr[i--];
			arr[++i] = p;
		}
		return true;
	}
	/////////////////////////////////////////////////
	////////////////////top view ///////////////////
	///////////////////////////////////////////////
	class q_item{
		int n1;
		Node val;
		q_item(Node val,int n1) {
			this.n1 = n1;
			this.val = val;
		}
	}/*
	public void top_view(){
		if (root == null)
			return;
        HashSet<Integer> set = new HashSet<>();
		Queue<q_item> q1 = new LinkedList<>();
		q1.add(new q_item(root,0));
		while (!q_item.isEmpty()) {
			q_item t = q_item.remove();
			int hd = q1.n1;
            Node n = t.val;
            if (!set.contains(hd)) {
                set.add(hd);
                System.out.print(n.data + " ");
            }
			if(t.val.left != null)
				q1.add(new q_item(n.left,hd-1));
			if(t.val.right != null)
				q1.add(new q_item(n.right,hd+1));
		}
	}*/
	/////////////////////////////////////////////
	///////////////////Bottom view//////////////
	///////////////////////////////////////////
	/*public void bottom_view() {
		if (root == null)
            return;
        int hd = 0;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Node> queue = new LinkedList<Node>();
        root.hd = hd;
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            hd = temp.hd;
            map.put(hd, temp.data);
            if (temp.left != null) {
                temp.left.hd = hd-1;
                queue.add(temp.left);
            } 
            if (temp.right != null) {
                temp.right.hd = hd+1;
                queue.add(temp.right);
            }
        }
        Set<Entry<Integer, Integer>> set = map.entrySet();
        Iterator<Entry<Integer, Integer>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> me = iterator.next();
            System.out.print(me.getValue()+" ");
        }
	}*/
    ////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////zigzag traversal/////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////
    public void zigzag () {
    	zigzagtraversal(root);
    }
	private void zigzagtraversal(Node root) {
        if (root == null)
            return;
        Deque<Node> dq = new LinkedList<Node>();
        boolean positive = true;
        dq.add(root);
        while (!dq.isEmpty()) {
            int size = dq.size();
            while (size-- > 0) {
                root = positive ? dq.pollFirst() : dq.pollLast();
                System.out.print(root.data + " ");
                if (positive) {
                    if (root.left != null) {
                        dq.add(root.left);
                    }
                    if (root.right != null) {
                        dq.add(root.right);
                    }
                } else {
                    if (root.right != null) {
                        dq.addFirst(root.right);
                    }
                    if (root.left != null) {
                        dq.addFirst(root.left);
                    }
                }
                //positive = !positive;
            }
            positive = !positive;
        }
    }
    /////////////////////////////////////////////////////
    ///////////////////////zigzag another way////////////
    ////////////////////////////////////////////////////
    public void zigzagTraversal() {
    	Node node = root; 
        if (node == null) 
            return;
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        s1.push(node);
        while (!s1.empty() || !s2.empty()) {
            while (!s1.empty()) {
                Node temp = s1.peek();
                s1.pop();
                System.out.print(temp.data + " ");
                if (temp.left != null) 
                    s2.push(temp.left); 
                if (temp.right != null) 
                    s2.push(temp.right); 
            }
            while (!s2.empty()) {
                Node temp = s2.peek();
                s2.pop();
                System.out.print(temp.data + " "); 
                if (temp.right != null)
                    s1.push(temp.right);
                if (temp.left != null)
                    s1.push(temp.left);
            }
        }
    }
    ////////////////////////////////////////////////////////////
    ///////////////////////even odd diff///////////////////////
    //////////////////////////////////////////////////////////
    public void zigzagEvenOdd () {
    	zigzagEvenOdd(root);
    }
	private void zigzagEvenOdd(Node root) {
        if (root == null)
            return;
        Deque<Node> dq = new LinkedList<Node>();
        boolean positive = true;
        dq.add(root);
        int even = 0;
        int odd = 0;
        while (!dq.isEmpty()) {
            int size = dq.size();
            while (size-- > 0) {
                root = positive ? dq.pollFirst() : dq.pollLast();
                System.out.print(root.data + " ");
                if (positive) {
                	odd +=root.data;
                    if (root.left != null) {
                        dq.add(root.left);
                    }
                    if (root.right != null) {
                        dq.add(root.right);
                    }
                } else {
                	even += root.data;
                    if (root.right != null) {
                        dq.addFirst(root.right);
                    }
                    if (root.left != null) {
                        dq.addFirst(root.left);
                    }
                }
                //positive = !positive;
            }
            positive = !positive;
        }
        System.out.println("Even = " + even + " Odd = "+odd);
    }
}