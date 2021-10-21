package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.lang.Math;
public class TrianglePuzzle implements Iterable<Triangle> , Comparator<Edge>  {
	
	ArrayList<Triangle> trianglesList =  new ArrayList<Triangle>();
	ArrayList<Triangle> solved =  new ArrayList<Triangle>();
	
	ArrayList<Node> nodesList =  new ArrayList<Node>();
	ArrayList<Node>selectedNodes = new ArrayList<Node>();
	
	ArrayList<Edge> selectedEdges = new ArrayList<Edge>();
	ArrayList<Edge> edgesList =  new ArrayList<Edge>();

	Boolean isSolved = false;
	
	
	
	public TrianglePuzzle() {}
	
	
	public boolean getIsSolved() {
		return isSolved;
	}
	
	
	
	public void setIsSolved(boolean b) {
		isSolved = b;
	}
	

	
	
	
	public ArrayList<Node> getSelectedNodes (){
		return selectedNodes;
	}
	
	public ArrayList<Edge> getSelectedEdges (){
		return selectedEdges;
	}
	

		
	
	public boolean SwapEdges(Edge e1, Edge e2) {
	
		Color tmp;
		tmp = e1.color;
		e1.color = e2.color;
		e2.color = tmp;
		System.out.println("Edges have been swapped");
		edgesList.set(edgesList.indexOf(e1),e1);
		edgesList.set(edgesList.indexOf(e2),e2);
		return true;
		
	}
	
	public boolean SwapClockWise(Edge e1, Edge e2, Edge e3) {
		
		ArrayList<Edge> edges = new ArrayList<Edge>();
		edges.add(e1);
		edges.add(e2);
		edges.add(e3);
		
		
		
		System.out.println("before" + edges.get(0).getId() +" " +  edges.get(1).getId() + " " + edges.get(2).getId());
		Collections.sort(edges,new TrianglePuzzle());
		System.out.println("after" + edges.get(0).getId() +" " +  edges.get(1).getId() + " " + edges.get(2).getId());
		
		
		if(edges.get(2).getId() - edges.get(0).getId() > 2  ) {
			System.out.println("different swap");
			Color tmp1;
			Color tmp2;
			tmp1 = edges.get(0).color;
			tmp2 = edges.get(2).color;
			edges.get(0).color = edges.get(1).color;
			edges.get(2).color = tmp1;
			edges.get(1).color = tmp2;
			edgesList.set(edgesList.indexOf(edges.get(0)),edges.get(0));
			edgesList.set(edgesList.indexOf(edges.get(1)),edges.get(1));
			edgesList.set(edgesList.indexOf(edges.get(2)),edges.get(2));
			
		}
		
		else {
		
			
			Color tmp1;
			Color tmp2;
			tmp1 = edges.get(0).color;
			tmp2 = edges.get(1).color;
			edges.get(0).color = edges.get(2).color;
			edges.get(1).color = tmp1;
			edges.get(2).color = tmp2;
			edgesList.set(edgesList.indexOf(edges.get(0)),edges.get(0));
			edgesList.set(edgesList.indexOf(edges.get(1)),edges.get(1));
			edgesList.set(edgesList.indexOf(edges.get(2)),edges.get(2));
		}
	
		
	
		
		
		return true;
	}
	
	public ArrayList<Triangle> getTrianglesList(){
		return trianglesList;
	}
	
	
	public void addTriangle(Triangle t) {
		trianglesList.add(t);
	}
	
	public ArrayList<Triangle> getSolved(){
		return solved;
	}
	
	public  void removeSolved(Triangle t){
		
		solved.remove(t);
	}
	
	public void addSolved(Triangle t){
		solved.add(t);
	}
	
	

	// check if every triangle in a puzzle is solved
	public boolean isEveryTriangleSolved() {
		
		Triangle t1 = trianglesList.get(0);
		Triangle t2 = trianglesList.get(1);
		Triangle t3 = trianglesList.get(2);
		Triangle t4 = trianglesList.get(3);
		Triangle t5 = trianglesList.get(4);
		Triangle t6 = trianglesList.get(5);
		
		
		if(t1.getColor() == Color.red &&  t2.getColor() == Color.blue  &&  t3.getColor() == Color.green &&  t4.getColor() == Color.green &&  t5.getColor() == Color.red &&  t6.getColor() == Color.blue){
			isSolved = true;
			System.out.println("salamm");
			return true;
		}
		
		else {
			System.out.println("zdarov");
			isSolved = false;
			return false;
		}
	}
	
	public void reset() {

		selectedEdges.clear();
		selectedNodes.clear();
		solved.clear();
		for(Node n : nodesList) {
			if(n.isSelected) {
				n.isSelected = false;
			}
		}
		
		
		for( Triangle t : trianglesList) {
			t.setColor(Color.black);
		}
		
		for(Edge e: edgesList) {
			e.color = e.defaultColor;
		}
		
	
	}
	
	public void addNode(Node n, int col, int row) {
		n.setCol(col);
		n.setRow(row);
		nodesList.add(n);
		
	}
	
	public ArrayList<Node> getNodesList(){
		return nodesList;
	}
	
	public void addEdge(Edge e) {
		edgesList.add(e);
	}
	
	public ArrayList<Edge> getEdgesList(){
		return edgesList;
	}




	@Override
	public Iterator<Triangle> iterator() {
		return  trianglesList.iterator();
	}

	@Override
	public int compare(Edge e1, Edge e2) {
		  if(e1.getId() > e2.getId()){
	            return 1;
	        } else {
	            return -1;
	        }
	}





	
	
}
