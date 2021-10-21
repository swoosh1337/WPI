package model;

import java.util.ArrayList;

public class Node {
	 public boolean isSelected = false;
	 public final int id;
	 public  int  row;
	 public  int  col;
	 public final int  height;
	 public final int width;
	 
	 
	 ArrayList<Edge> Edges  = new ArrayList<Edge>();
	 ArrayList<Triangle> Triangles = new ArrayList<Triangle>();
	 
	 public Node(int h, int w, int id) {
		 this.id = id;
		 this.height = h;
		 this.width = w;
	 }
	 
	 public boolean isSelected() {
		 return isSelected;
	 }
	 
	 public void setSelected(boolean v) {
		 isSelected = v;
	 }
	 
	 public int getID() {
		 return id;
	 }
	
	 public int getRow() {
		 return row;
		 
	 }
	 
	 public void setRow(int x) {
		 this.row = x;
	 }
	 
	 public int getCol() {
		 return col;
		 
	 }
	 
	 public void setCol(int y) {
		 this.col = y;
	 }
	 
	 public ArrayList<Edge> getEdges(){
		 return Edges;
	 }
	 
	 public void setEdges(ArrayList<Edge> e) {
		 this.Edges = e;
	 }
	 
	 public void setTriangles(ArrayList<Triangle> t) {
		 this.Triangles = t;
	 }
	 
	 public ArrayList<Triangle> getTriangle(){
		 return Triangles;
	 }
	 
	 
	public int getHeight() {
		return height;
	}
	 
	public int getWidth() {
		return width;
	}
	
	public boolean contains(Coordinate c) {
		if(c.col >= col && c.col < col + width && c.row >= row && c.row < row + height ) {
			return true;
		}
		return false;
	}
		
}
