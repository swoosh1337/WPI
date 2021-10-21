package model;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.Test;



public class TestTriangle {

	@Test
	public void testConstruction() {
		ArrayList<Node> nodeList = new ArrayList<Node>();
		ArrayList<Node> nodeList2 = new ArrayList<Node>();
		ArrayList<Node> nodeList3 = new ArrayList<Node>();
		Node n1 = new Node(2,1,1);
		Node n2 = new Node(2,1,2);
		Node n3 = new Node(2,1,3);
		nodeList.add(n1);
		nodeList.add(n2);
		nodeList2.add(n1);
		nodeList2.add(n3);
		nodeList3.add(n2);
		nodeList3.add(n3);
		
		Edge e1 = new Edge(Color.black,nodeList,1);
		Edge e2 = new Edge(Color.black,nodeList2,2);
		Edge e3 = new Edge(Color.black,nodeList3,3);
		
		ArrayList<Edge> t1_edges = new ArrayList<Edge>();
		t1_edges.add(e1);
		t1_edges.add(e2);
		t1_edges.add(e3);
		
		Triangle t1 = new Triangle(t1_edges,1);
		
		assertEquals(Color.black,t1.getColor());
		assertEquals(1,t1.getId());
		assertEquals(t1_edges,t1.getEdges());
	
		
		
	}
	
	@Test
	public void testIsSolved() {
		ArrayList<Node> nodeList = new ArrayList<Node>();
		ArrayList<Node> nodeList2 = new ArrayList<Node>();
		ArrayList<Node> nodeList3 = new ArrayList<Node>();
		Node n1 = new Node(2,1,1);
		Node n2 = new Node(2,1,2);
		Node n3 = new Node(2,1,3);
		nodeList.add(n1);
		nodeList.add(n2);
		nodeList2.add(n1);
		nodeList2.add(n3);
		nodeList3.add(n2);
		nodeList3.add(n3);
		
		Edge e1 = new Edge(Color.green,nodeList,1);
		Edge e2 = new Edge(Color.blue,nodeList2,2);
		Edge e3 = new Edge(Color.red,nodeList3,3);
		
		ArrayList<Edge> t1_edges = new ArrayList<Edge>();
		t1_edges.add(e1);
		t1_edges.add(e2);
		t1_edges.add(e3);
		
		Triangle t1 = new Triangle(t1_edges,1);
		
		assertFalse(t1.IsSolved());
		
		e1.setColor(Color.green);
		e2.setColor(Color.green);
		e3.setColor(Color.green);
		
		assertTrue(t1.IsSolved());
		
		
	}
	

		
	

}
