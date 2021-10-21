import java.util.LinkedList;

public interface IBinTree {
	 // determines whether element is in the tree
	 boolean hasElt(int e);
	 // returns number of nodes in the tree; counts duplicate elements as separate items
	 int size();
	 // returns depth of longest branch in the tree
	 int height();
	 boolean isBigger(int e);
	 //get left
	 //get right
	 
	 int getLeft();
	 
	 int getRight();
	 int getData();
	 IBinTree getLeftIB();
	 IBinTree getRightIB();
	 boolean checker1(IBinTree a);
	 boolean checker1();

	// public boolean doesThisHaveThis(IBinTree b);
	// public boolean doesThisHaveThis( IHeap b);
	 //public boolean doesThisHaveThis( IBinTree b);
	 //public int howManyOfThis(int k);
	 public LinkedList<Integer> Convert();
	 public boolean compareLists(IHeap b);
	 
	 public boolean areBothHeaps(DataBT b);
	 public boolean areBothHeaps(IHeap b);
	}