package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.Test;

public class TestNode {

	@Test
	public void testConstruction() {
		Node node = new Node(2,1,1);
		assertEquals (1, node.getWidth());
		assertEquals (2, node.getHeight());
		assertEquals (1, node.getID());
		assertFalse(node.isSelected());
		
	}
	
	@Test
	public void testContains() {
		Node n = new Node(2,1,1);
		n.setRow(0);
		n.setCol(0);
		
		/**
		 * (0,0)
		 * (0,1)
		 */
		assertTrue(n.contains(new Coordinate(0,0)));
		assertTrue(n.contains(new Coordinate(0,1)));
		assertFalse(n.contains(new Coordinate(1,1)));
	}
	
	@Test
	public void testSetAndGetEdges() {
		Node n1 = new Node(2,2,1);
		Node n2 = new Node(2,2,2);
		
		ArrayList<Node> One_Two = new ArrayList<Node>();
		One_Two.add(n1);
		One_Two.add(n2);
		Edge e1 = new Edge(Color.red,One_Two,1);
		ArrayList<Edge> edge_list = new ArrayList<Edge>();
		edge_list.add(e1);
		
		n1.setEdges(edge_list);
		
		assertEquals(edge_list,n1.getEdges());
		
		
		
	}
	
	@Test
	public void testSetSelected() {
		Node n1 = new Node(2,2,1);
		n1.setSelected(true);
		assertTrue(n1.isSelected());
	}
	
	
	@Test
	public void testSetAndGetTriangle() {
		Node n1 = new Node(2,2,1);
		Node n2 = new Node(2,2,2);
		Node n3 = new Node(2,2,3);
		
		ArrayList<Node> One_Two = new ArrayList<Node>();
		One_Two.add(n1);
		One_Two.add(n2);
		
		ArrayList<Node> One_Three = new ArrayList<Node>();
		One_Three.add(n1);
		One_Three.add(n3);
		
		ArrayList<Node> Two_Three = new ArrayList<Node>();
		Two_Three.add(n2);
		Two_Three.add(n3);
		
		Edge e1 = new Edge(Color.red,One_Two,1);
		Edge e2 = new Edge(Color.red,One_Three,2);
		Edge e3 = new Edge(Color.green,Two_Three,3);
		
		ArrayList<Edge> t1_edges = new ArrayList<Edge>();
		t1_edges.add(e1);
		t1_edges.add(e2);
		t1_edges.add(e3);
		Triangle t1 = new Triangle(t1_edges,1);
		ArrayList<Triangle> t_list = new ArrayList<Triangle>();
		t_list.add(t1);
		n1.setTriangles(t_list);
		assertEquals(t_list,n1.getTriangle());
		
	}
	

	
	
	
	
}
