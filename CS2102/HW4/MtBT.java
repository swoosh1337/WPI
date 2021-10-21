import java.util.LinkedList;

public class MtBT implements IBinTree {
	MtBT(){}

	 // returns false since empty tree has no elements
	 public boolean hasElt(int e) {
	  return false;
	 }

	 // returns 0 since enpty tree has no elements
	 public int size() {
	  return 0;
	 }

	 // returns 0 since empty tree has no branches
	 public int height() {
	  return 0;
	 }
	 public boolean isBigger(int e) {
	 return true;
	 }
	 
	 public int getLeft() {
		 return 0; //emptybinarytree
	 }
	 public int getRight() {
		 return 0;
	 }
	 public int getData() {
		 return 0;
	 }

	@Override
	public IBinTree getLeftIB() {
		// TODO Auto-generated method stub
		return new MtBT();
	}

	@Override
	public IBinTree getRightIB() {
		// TODO Auto-generated method stub
		//IBinTree a= new DataBT(new MtBT);
		return new MtBT();
	}
	public boolean checker1(IBinTree a) {
		return true;
	}
	public boolean checker1() {
		return true;
	}

	 public LinkedList<Integer> listmaker(LinkedList<Integer> a){
		 return a;
	 }
	 public boolean doesThisHaveThis(IBinTree b) {
		 return true;
	 }
	 public int howManyOfThis(int k) {
		 return 0;
	 }
	 public boolean areBothHeaps(DataBT b) {
		 return true;
	 }
	 public boolean areBothHeaps(IHeap b) {
		 return true; 
	}
	 public boolean doesThisHaveThis(IHeap b) {
		 return true;
	 }

	 public LinkedList<Integer> Convert(){
			LinkedList<Integer>empty=new LinkedList<Integer>();
			return empty;
		 }
	 public boolean compareLists(IHeap b) {
		 if(this instanceof MtBT && b instanceof MtHeap)
			 return true;
		 return false;
	 }

}

