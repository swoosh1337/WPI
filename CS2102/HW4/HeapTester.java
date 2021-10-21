import java.util.LinkedList;

public class HeapTester {
	
	  boolean addEltTester(IHeap hOrig, int elt, IBinTree hAdded) {
		  //return true;
		  HeapTester H2 = new HeapTester();
		  if((hAdded).areBothHeaps((DataBT) hOrig.addElt(elt)))
		  { //System.out.println("ak var1");
		  
			  if(((IBinTree)hOrig.addElt(elt)).size()==hAdded.size()) {

				  //.out.println("ak var");
				  if(hAdded.compareLists(hOrig.addElt(elt)))
			   { 
					  //System.out.println("kvemot");
				   return true;
				   }
			  }
	  }
		  
		  return false;
}
	  

		 boolean remMinEltTester(IHeap hOrig, IBinTree hRemoved) {

			  if(hRemoved.areBothHeaps(hOrig.remMinElt()))
			  { //System.out.println("ak var11");
			  
				  if(((IBinTree)hOrig.remMinElt()).size()==hRemoved.size()) {

					  //System.out.println("ak varrrr");
					  //System.out.println(hOrig.remMinElt().Convert());
					  //System.out.println(hRemoved.Convert());
					 if((((DataBT)hOrig).compareLists2(hRemoved, hOrig)))
				   { 
						  
						  //System.out.println("kvemotttt");
						  
					   return true;
					   }
				  }
		  }
			  
			  return false;
			    
			  }
		 

		
		
		 
		 
		 
		 
		 
		 
		 
		 
		 LinkedList<Integer> listadder(DataBT j){
			 LinkedList<Integer> list1 = new LinkedList<Integer>();
			 list1.add(j.data);
				// leftlistadder
				 list1.add(((DataBT)j.left).data);
				 list1.add(((DataBT)j.right).data);
				 //listadder();
				 return list1;
		 }
		 
		 
	
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 /* Given two trees, return true if they are
	       structurally identical */
	    boolean newequals(DataBT a, DataBT b) 
	    {
	    	System.out.println("!!");
	    	
	        /*1. both empty */
	        if ((IBinTree)a instanceof MtBT  && (IBinTree)b instanceof MtBT)
	            return true;
	        System.out.println("1  " + a.data);
	    	     
	        /* 2. both non-empty -> compare them */
	        if ( !((IBinTree)a instanceof MtBT) && !((IBinTree)b instanceof MtBT)) {

	        	boolean check = (a.data == b.data);
		        System.out.println("1112");
		        
		        if(a.left instanceof MtBT && b.left instanceof MtBT);else
		        if((a.left instanceof MtBT) != (a.left instanceof MtBT))check = false;else
	        	if(!newequals((DataBT)a.left, (DataBT)b.left))check = false;
		        
		        
		        System.out.println("1113");
		        
		        
		        if(a.right instanceof MtBT && b.right instanceof MtBT);else
			    if((a.right instanceof MtBT) != (a.right instanceof MtBT))check = false;else
		        if(!newequals((DataBT)a.right, (DataBT)b.right))check = false;

		        System.out.println("112");

		        return (check);
	        }
	        System.out.println("2");
	  
	        /* 3. one empty, one not -> false */
	        if ( ((IBinTree)a instanceof  MtBT) && (!((IBinTree)b instanceof MtBT))) {
	        	return false;
	        }
	        System.out.println("3");
	        return false;
	    }
		 boolean addEltTester1(IHeap hOrig, int elt, IBinTree hAdded) {
			 return (checker((DataBT)hAdded,(DataBT)hOrig.addElt(elt)));
			 
		 }
		 boolean checker(DataBT a, DataBT b) {
			 if(a.size()!=b.size())
				 return false;
			 if(a.data!=b.data)
				 return false;
			// if(((DataBT) a.left).left)
				// return true;
			 boolean c= true;
			 LinkedList<Integer> list1 = listadder(a);
			return true;
		 }
}
