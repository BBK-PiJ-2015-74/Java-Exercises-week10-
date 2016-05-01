package exam_questions;


public class Treestring {

	public Treestring() {
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		if (IntTree.getRoot() != null)
		
			sb.append("(" + IntTree.getRoot().data + ",");
		
		if (IntTree.getRoot().left != null) {
			sb.append(IntTree.getRoot().left.toString() + ",");
		} else {
			sb.append("empty");
		}
		
		if (IntTree.getRoot().right != null) {
			sb.append(IntTree.getRoot().right.toString() + "," + ")" );
		} else {
			sb.append("empty" + ")");
		}
		return sb.toString();
	}
	
	public static class IntTree {
	
		private static IntTreeNode overallRoot = null;
       
		public static IntTreeNode getRoot() {
			return overallRoot;
		}
	}
  

	public class IntTreeNode {
       
		public int data; // data stored in this node
		public IntTreeNode left; // reference to left subtree
		public IntTreeNode right; // reference to right subtree
		
		public IntTreeNode() {
			data = 0;
			this.left = left;
			this.right = right;
		}
	}
	
	public static void main (String[] args) {
		IntTree t = new IntTree();
		t.overallRoot.data = 2;
		t.overallRoot.left.data = 8;
		t.overallRoot.left.left.data = 2;
		t.overallRoot.left.right = null;
		t.overallRoot.right.data = 1;
		t.overallRoot.right.left.data = 7;
		t.overallRoot.right.left.left.data = 4;
		t.overallRoot.right.left.right = null;
		t.overallRoot.right.right.data = 6;
		t.overallRoot.right.right.right.data = 9;
		t.overallRoot.right.right.left = null;
		t.toString();
	}

} //end of class
