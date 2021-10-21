import java.lang.Math;
import java.util.LinkedList;

public class DataBT implements IBinTree {

	int data;
	IBinTree left;
	IBinTree right;

	DataBT(int data, IBinTree left, IBinTree right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	// an alternate constructor for when both subtrees are empty
	DataBT(int data) {
		this.data = data;
		this.left = new MtBT();
		this.right = new MtBT();
	}

	// returns the data of DataBT
	@Override
	public int getData() {
		return data;
	}

	// returns the data of left IBinTree of DataBT
	public int getLeft() {
		return ((DataBT) this.left).data;
	}

	// returns the data of right IBinTree of DataBT
	public int getRight() {
		return ((DataBT) this.right).data;
	}

	// returns the left IBinTree of DataBT
	public IBinTree getLeftIB() {
		return this.left;
	}

	// returns the right IBinTree of DataBT
	public IBinTree getRightIB() {
		return this.right;
	}

	// determines whether this node or node in subtree has given element
	public boolean hasElt(int e) {
		return this.data == e || this.left.hasElt(e) || this.right.hasElt(e);
	}

	// adds 1 to the number of nodes in the left and right subtrees
	public int size() {
		return 1 + this.left.size() + this.right.size();
	}

	// adds 1 to the height of the taller subtree
	public int height() {
		return 1 + Math.max(this.left.height(), this.right.height());
	}

	@Override
	public boolean isBigger(int e) {
		// TODO Auto-generated method stub
		return this.data > e;
	}

	// checks if heap is a heap
	public boolean checker1(IBinTree a) {
		if (!((IBinTree) a instanceof MtBT))
			//
		{

			int k = a.getData();
			// int leftint = ((DataBT)a.left).data;
			// int rightint = ((DataBT)a.right).data;
			if (a.getLeftIB().isBigger(k) && a.getRightIB().isBigger(k)) {
				return checker1(a.getLeftIB()) && checker1(a.getRightIB());
			}

			return false;
		}

		return true;
	}

	// checks if heap is a heap
	public boolean checker1() {
		if (!((IBinTree) this instanceof MtBT))
			//
		{

			int k = ((IBinTree) this).getData();
			// int leftint = ((DataBT)a.left).data;
			// int rightint = ((DataBT)a.right).data;
			if (((IBinTree) this).getLeftIB().isBigger(k) && ((IBinTree) this).getRightIB().isBigger(k)) {
				return checker1(((IBinTree) this).getLeftIB()) && checker1(((IBinTree) this).getRightIB());
			}

			return false;
		}

		return true;
	}
	public LinkedList<Integer> Convert() {
	    
    	
	  	LinkedList<Integer>List1 = new LinkedList<Integer>();
	  	
             if (((IBinTree)this instanceof MtBT)){
            	 LinkedList<Integer>empty = new LinkedList<Integer>();
            	 return empty;} else
            		
            		 
	    	List1.add(this.data);
         
         
	     List1.addAll(((IBinTree)this.left).Convert());
         List1.addAll(((IBinTree)this.right).Convert());
         return List1;
	    
	    }

public boolean compareLists(IHeap b) {
	System.out.println("here123");
	if ((IBinTree) this instanceof MtBT || (IBinTree) b instanceof MtBT) {
		System.out.println("here123");
		return false;
	}
if (((IBinTree) this instanceof MtBT) &&  (b instanceof MtHeap)) {
		
		return true;
	}
	System.out.println("here");
	LinkedList<Integer> a = this.Convert();
	System.out.println(a);
	LinkedList<Integer> c = b.Convert();
	System.out.println(c);
	int k=0;
	int p=0;
	for(int i=0; i<a.size(); i++) {
		//System.out.println(a.size());
		//System.out.println(a.get(i));
		
		for(int j=0; j<a.size(); j++) {
			if(a.get(i).equals(a.get(j))) {
			k=k+1;}
			//System.out.println("i   "+a.get(i)+ "   j " +a.get(j));
			//System.out.println("j   "+ j+ "   k " +k);
		}
		
		for(int j=0; j<c.size(); j++) {
			if(a.get(i)== c.get(j))
				p++;
		}
		if(p!=k) {
			return false;
		}
	}
	return true;
}
public boolean compareLists2(IBinTree b, IHeap l) {
	System.out.println("here123");

if (((IBinTree) this instanceof MtBT) &&  (b instanceof MtBT)) {
		
		return true;
	}
	System.out.println("here");
	//IHeap var = l.remMinElt();
	IHeap u= ((IHeap)this).remMinElt();
	LinkedList<Integer> a = u.Convert();
	System.out.println(a);
	LinkedList<Integer> c = b.Convert();
	System.out.println(c);
	int k=0;
	int p=0;
	for(int i=0; i<a.size(); i++) {
		//System.out.println(a.size());
		//System.out.println(a.get(i));
		
		for(int j=0; j<a.size(); j++) {
			if(a.get(i).equals(a.get(j))) {
			k=k+1;}
			//System.out.println("i   "+a.get(i)+ "   j " +a.get(j));
			//System.out.println("j   "+ j+ "   k " +k);
		}
		
		for(int j=0; j<c.size(); j++) {
			if(a.get(i)== c.get(j))
				p++;
		}
		if(p!=k) {
			return false;
		}
	}
	return true;
}
	
	public boolean areBothHeaps(DataBT b) {
		return (this.checker1() && b.checker1());
	}
	public boolean areBothHeaps(IHeap b) {
		 return (this.checker1() && b.checker1()); 


}


	





	/*public int howManyOfThis(int k) {
		int count = 0;
		if (!((IBinTree) this instanceof MtBT)) {

		
		if (k==this.getData()) {
			count++; 
		}
		//if (!(this.getLeftIB() instanceof MtBT)) {
			
			count= count + (this.getLeftIB()).howManyOfThis( k);
		//}
		//if (!(this.getRightIB() instanceof MtBT)) {
			
			count= count+ (this.getRightIB()).howManyOfThis(k);
		}
		//System.out.println(count +" "+this.getData());
		return count;

	}
	public boolean doesThisHaveThis(IHeap b, int a) {

		if(b.howManyOfThis(a)== this.howManyOfThis(a)){
System.out.println(b.howManyOfThis(this.getData())+" "+this.getData());
			return ((this.getLeftIB().doesThisHaveThis(b, this.getLeft()))
					&& (this.getRightIB().doesThisHaveThis(b, this.getRight())));

		}
		return false;


	}
	public boolean doesThisHaveThis(IBinTree k) {

		if(k.howManyOfThis(this.getData())== this.howManyOfThis(this.getData())){
			
			return (this.getLeftIB().doesThisHaveThis(k))
					&& (this.getRightIB().doesThisHaveThis(k));
			

		}
	
		return false;
	//}
		//return true;


	}
	
	public boolean areBothHeaps(DataBT b) {
		return (this.checker1() && b.checker1());
	}
	public boolean areBothHeaps(IHeap b) {
		 return (this.checker1() && b.checker1()); 


}
	public int checkYours(int k, int c) {

		if(this.getData()==k){
			c++;
			return c+ ((DataBT)this.getLeftIB()).checkYours(k, c)
					+((DataBT)this.getRightIB()).checkYours(k, c);

		}
		return 0;


	}
*/


}