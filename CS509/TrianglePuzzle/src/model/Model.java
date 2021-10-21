package model;

import java.awt.Color;
import java.util.ArrayList;

public class Model {
	
	TrianglePuzzle puzzle;
	int score = 0;
	int moves = 0;
	
	
	public Model () {
	
		
	}
	
	
	
	public void setPuzzle(TrianglePuzzle p) { 
		
		puzzle = p;
		score = 0;
		moves = 0;
		Node n1 = new Node(2,2,1);
		Node n2 = new Node(2,2,2);
		Node n3 = new Node(2,2,3);
		Node n4 = new Node(2,2,4);
		Node n5 = new Node(2,2,5);
		Node n6 = new Node(2,2,6);
		Node n7= new Node(2,2,7);
		Node n8 = new Node(2,2,8);
		Node n9 = new Node(2,2,9);
		Node n10 = new Node(2,2,10);
	
	
		//creating list of nodes
		ArrayList<Node> One_Two = new ArrayList<Node>();
		One_Two.add(n1);
		One_Two.add(n2);
		
		ArrayList<Node> One_Three = new ArrayList<Node>();
		One_Three.add(n1);
		One_Three.add(n3);
		
		ArrayList<Node> Two_Three = new ArrayList<Node>();
		Two_Three.add(n2);
		Two_Three.add(n3);
		
		ArrayList<Node> Two_Four = new ArrayList<Node>();
		Two_Four.add(n2);
		Two_Four.add(n4);
		
		ArrayList<Node> Four_Five = new ArrayList<Node>();
		Four_Five.add(n4);
		Four_Five.add(n5);
		
		ArrayList<Node> Two_Five = new ArrayList<Node>();
		Two_Five.add(n2);
		Two_Five.add(n5);
		
		ArrayList<Node> Three_Five = new ArrayList<Node>();
		Three_Five.add(n3);
		Three_Five.add(n5);
		
		ArrayList<Node> Five_Six = new ArrayList<Node>();
		Five_Six.add(n5);
		Five_Six.add(n6);
		
		ArrayList<Node> Three_Six = new ArrayList<Node>();
		Three_Six.add(n3);
		Three_Six.add(n6);
		
		ArrayList<Node> Four_Seven = new ArrayList<Node>();
		Four_Seven.add(n4);
		Four_Seven.add(n7);
		
		ArrayList<Node> Seven_Eight = new ArrayList<Node>();
		Seven_Eight.add(n7);
		Seven_Eight.add(n8);
		
		ArrayList<Node> Four_Eight = new ArrayList<Node>();
		Four_Eight.add(n4);
		Four_Eight.add(n8);
		
		ArrayList<Node> Five_Eight = new ArrayList<Node>();
		Five_Eight.add(n5);
		Five_Eight.add(n8);
		
		ArrayList<Node> Eight_Nine = new ArrayList<Node>();
		Eight_Nine.add(n8);
		Eight_Nine.add(n9);
		
		ArrayList<Node> Five_Nine = new ArrayList<Node>();
		Five_Nine.add(n5);
		Five_Nine.add(n9);
		
		ArrayList<Node> Six_Nine = new ArrayList<Node>();
		Six_Nine.add(n6);
		Six_Nine.add(n9);
		
		ArrayList<Node> Nine_Ten = new ArrayList<Node>();
		Nine_Ten.add(n9);
		Nine_Ten.add(n10);
		
		ArrayList<Node> Six_Ten = new ArrayList<Node>();
		Six_Ten.add(n6);
		Six_Ten.add(n10);
		puzzle.addNode(n1, 20,  2);
		puzzle.addNode(n2, 15, 12);
		puzzle.addNode(n3, 25, 12);
		
		puzzle.addNode(n4, 10, 22);
		puzzle.addNode(n5, 20, 22);
		puzzle.addNode(n6, 30, 22);
		
		puzzle.addNode(n7, 5,  32);
		puzzle.addNode(n8, 15, 32);
		puzzle.addNode(n9, 25, 32);
		puzzle.addNode(n10,35, 32);
		
		
		// creating edges with existing nodes
		Edge e1 = new Edge(Color.red,One_Two,1);
		Edge e2 = new Edge(Color.red,One_Three,2);
		Edge e3 = new Edge(Color.green,Two_Three,3);
		
     	Edge e4 = new Edge(Color.red,Two_Four,4);
		Edge e5 = new Edge(Color.green,Four_Five,6);
	    Edge e6 = new Edge(Color.blue,Two_Five,5);
	    
		Edge e7 = new Edge(Color.blue,Three_Five,7);
		Edge e8 = new Edge(Color.green,Five_Six,9);
	    Edge e9 = new Edge(Color.red,Three_Six,8);
	    
	    Edge e10 = new Edge(Color.red,Four_Seven,10);
		Edge e11 = new Edge(Color.green,Seven_Eight,12);
		Edge e12 = new Edge(Color.blue,Four_Eight,11);
	    
	    Edge e13 = new Edge(Color.blue,Five_Eight,13);
		Edge e14= new Edge(Color.green,Eight_Nine,15);
	    Edge e15 = new Edge(Color.blue,Five_Nine,14);
	    
	    Edge e16 = new Edge(Color.blue,Six_Nine,16);
		Edge e17 = new Edge(Color.green,Nine_Ten,18);
	    Edge e18 = new Edge(Color.red,Six_Ten,17);
//		
	    
	    //adding edges to puzzl
		puzzle.addEdge(e1);
		puzzle.addEdge(e2);
		puzzle.addEdge(e3);
		puzzle.addEdge(e4);
		puzzle.addEdge(e5);
		puzzle.addEdge(e6);
		puzzle.addEdge(e7);
		puzzle.addEdge(e8);
		puzzle.addEdge(e9);
		puzzle.addEdge(e10);
		puzzle.addEdge(e11);
		puzzle.addEdge(e12);
		puzzle.addEdge(e13);
		puzzle.addEdge(e14);
		puzzle.addEdge(e15);
		puzzle.addEdge(e16);
		puzzle.addEdge(e17);
		puzzle.addEdge(e18);
	    
		//creating triangles
		ArrayList<Edge> t1_edges = new ArrayList<Edge>();
		t1_edges.add(e1);
		t1_edges.add(e2);
		t1_edges.add(e3);
		Triangle t1 = new Triangle(t1_edges,1);
		
		ArrayList<Edge> t2_edges = new ArrayList<Edge>();
		t2_edges.add(e4);
		t2_edges.add(e5);
		t2_edges.add(e6);
		Triangle t2 = new Triangle(t2_edges,2);
		
		ArrayList<Edge> t3_edges = new ArrayList<Edge>();
		t3_edges.add(e7);
		t3_edges.add(e8);
		t3_edges.add(e9);
		Triangle t3 = new Triangle(t3_edges,3);
		
		ArrayList<Edge> t4_edges = new ArrayList<Edge>();
		t4_edges.add(e10);
		t4_edges.add(e11);
		t4_edges.add(e12);
		Triangle t4 = new Triangle(t4_edges,4);
		
		ArrayList<Edge> t5_edges = new ArrayList<Edge>();
		t5_edges.add(e13);
		t5_edges.add(e14);
		t5_edges.add(e15);
		Triangle t5 = new Triangle(t5_edges,5);
		
		ArrayList<Edge> t6_edges = new ArrayList<Edge>();
		t6_edges.add(e16);
		t6_edges.add(e17);
		t6_edges.add(e18);
		Triangle t6 = new Triangle(t6_edges,6);
		
		//adding triangles to puzzle
	    puzzle.addTriangle(t1);
	    puzzle.addTriangle(t2);
	    puzzle.addTriangle(t3);
	    puzzle.addTriangle(t4);
	    puzzle.addTriangle(t5);
	    puzzle.addTriangle(t6);
		
		
		
		
		
		
	}
	public TrianglePuzzle getPuzzle() { 
		return puzzle;
		
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int s) {
		this.score = this.score + s;
	}
	
	public int getMoves() {
		return moves;
	}
	
	public void setMoves(int m) {
		this.moves = this.moves + m;
	}
	
	public void resetPuzzle() {
		
		score = 0;
		moves = 0;
		puzzle.reset();
	}
	// check if puzzle is solved
	public boolean isSolved() {
		if(puzzle.isEveryTriangleSolved() == true) {
			return true;
		}else {
			return false;
		}
	}

}
