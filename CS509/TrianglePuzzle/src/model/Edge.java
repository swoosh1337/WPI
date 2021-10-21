package model;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Edge  {
	
	public java.awt.Color color;
	public java.awt.Color defaultColor;
	public ArrayList<Node> Nodes = new ArrayList<Node>();
	public ArrayList<Triangle> Triangle = new ArrayList<Triangle>();
	public  int  row1;
	public  int  col1;
	public  int  row2;
	public  int  col2 ;
	public int id;
	
	
	public Edge(java.awt.Color color, ArrayList<Node> nodes, int id) {
		this.color = color;
		this.Nodes = nodes;
		this.defaultColor = color;
		this.id = id;
		
		row1 = Nodes.get(0).row;
		col1 = Nodes.get(0).col;
		row2 = Nodes.get(1).row;
		col2 = Nodes.get(1).col;
		
		
	}
	
	// check if edge is selected
	public boolean check() {
		for(Node n : Nodes) {
			if(n.isSelected == false) {
				return false;
			}
		}
		
		return true;
	}
	
	
	public int getId() {
		return id;
	}
	
	public java.awt.Color getColor() {
		return color;
	}
	
	 public int getRow1() {
		 return row1;
		 
	 }
	
	 public int getCol1() {
		 return col1;
		 
	 }
	 

	 
	 public int getRow2() {
		 return row2;
		 
	 }
	 
	
	 
	 public int getCol2() {
		 return col2;
		 
	 }
	 
	
	
	public void setColor(java.awt.Color c) {
		this.color = c;
	}
	
	public ArrayList<Node> getNodes(){
		return Nodes;
	}
	
	public ArrayList<Triangle> getTrianlge(){
		return Triangle;
	
	}
	
	public void setTriangle(Triangle t) {
		Triangle.add(t);
	}


	
	
	



	

}
