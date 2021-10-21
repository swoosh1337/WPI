package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

public class Triangle  implements Iterable<Edge>{
	ArrayList<Edge> Edges;

	java.awt.Color color = Color.black;
	int id;
	
	public Triangle(ArrayList<Edge> edges, int id) {
		this.Edges = edges;
		this.id = id;
		
	}
	
	public ArrayList<Edge> getEdges(){
		return Edges;
		
	}
	
	
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(java.awt.Color color) {
		this.color = color;
	}
	
	public int getId() {
		return id;
	}
	

	
	public boolean IsSolved() {
		if((Edges.get(0).color == Edges.get(1).color) && (Edges.get(2).color == Edges.get(0).color)) {
			setColor(Edges.get(0).color);
			return true;
		}
		else {
			
			return false;
		}
		
	}

	@Override
	public Iterator<Edge> iterator() {
		return  Edges.iterator();

	}
	
	

}
