package model;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import org.junit.Test;

import controller.AppTestCase;
import controller.SelectNodeController;



public class TestEdge extends AppTestCase {

	
	
	@Test
	public void testConstruction() {
		ArrayList<Node> nodeList = new ArrayList<Node>();
		Node n1 = new Node(2,1,1);
		Node n2 = new Node(2,1,2);
		nodeList.add(n1);
		nodeList.add(n2);
		Edge e1 = new Edge(Color.black,nodeList,1);
		
		assertEquals(Color.black,e1.getColor());
		assertEquals(nodeList,e1.getNodes());
		assertEquals(1,e1.getId());
		assertEquals(e1.getRow1(),nodeList.get(0).getRow());
		assertEquals(e1.getCol1(),nodeList.get(0).getCol());
		assertEquals(e1.getRow2(),nodeList.get(1).getRow());
		assertEquals(e1.getCol2(),nodeList.get(0).getCol());
		
	}
	
	@Test
	public void testCheck() {
		ArrayList<Node> nodeList = new ArrayList<Node>();
		Node n1 = new Node(2,1,1);
		Node n2 = new Node(2,1,2);
		nodeList.add(n1);
		nodeList.add(n2);
		Edge e1 = new Edge(Color.black,nodeList,1);
		
		assertFalse(e1.check());
		
		SelectNodeController snc = new SelectNodeController (model, app);
		TrianglePuzzle puzzle = model.getPuzzle();
		snc.Select(n1);
		snc.Select(n2);
		Point pt = coordinateToPoint(new Coordinate(1,4));
		snc.process(pt);
		assertTrue(e1.check());
		
	}
	
	@Test
	public void testSetColor() {
		ArrayList<Node> nodeList = new ArrayList<Node>();
		Node n1 = new Node(2,1,1);
		Node n2 = new Node(2,1,2);
		nodeList.add(n1);
		nodeList.add(n2);
		Edge e1 = new Edge(Color.black,nodeList,1);
		
		e1.setColor(Color.green);
		assertEquals(Color.green,e1.getColor());
	}
	
	@Test
	public void testGetTrianlge() {
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
		e1.setTriangle(t1);
		
		assertEquals(t1,e1.getTrianlge().get(0));
		
	}

}
