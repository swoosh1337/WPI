package controller;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import boundary.TrianglePuzzleApp;
import boundary.UpdateButtons;
import model.Coordinate;
import model.Edge;
import model.Model;
import model.Node;
import model.Triangle;
import model.TrianglePuzzle;

public class TestSelectNodeController extends AppTestCase  {

	

	@Test
	public void testProcess() {
		SelectNodeController snc = new SelectNodeController (model, app);
		TrianglePuzzle puzzle = model.getPuzzle();
		
		
		Point pt = coordinateToPoint(new Coordinate(1,4));
		assertEquals (new Coordinate(1,4), app.getPanel().pointToCoordiante(pt));
		assertEquals (new Coordinate(1,4), app.getPanel().pointToCoordiante(pt));
	
		snc.process(pt);
		Node n = getNode(new Coordinate(20, 2)).get(); 
		
		ArrayList<Node> nodeList = puzzle.getNodesList();
		assertEquals (n, nodeList.get(0));
		assertFalse (app.getBtnUnselectAll().isEnabled());
		assertTrue (app.getBtnReset().isEnabled());
		assertFalse (app.getBtnSwap().isEnabled());
		
	
		
		
		
		

		
	}
	@Before
	public void setUP() {
		SelectNodeController snc = new SelectNodeController (model, app);
		TrianglePuzzle puzzle = model.getPuzzle();
	
	
		ArrayList<Node> nodeList = puzzle.getNodesList();
		puzzle.getSelectedEdges().clear();
		puzzle.getSelectedNodes().clear();
		for(Node n : nodeList){
			if(n.isSelected) {
				snc.Unselect(n);
			}
		}
		
		for(Edge e : puzzle.getEdgesList()) {
			if(e.check() == true) {
				snc.Unselect(e.getNodes().get(0));
				snc.Unselect(e.getNodes().get(1));
			}
		}
	
		
	}
	
	@Test
	public void testProcess2() {
		SelectNodeController snc = new SelectNodeController (model, app);
		TrianglePuzzle puzzle = model.getPuzzle();
		Triangle t1 = model.getPuzzle().getTrianglesList().get(0);
		ArrayList<Edge> edgesOfT = t1.getEdges();
		ArrayList<Node> nodeList = puzzle.getNodesList();
		
		
		snc.Select(edgesOfT.get(0).getNodes().get(0));
		snc.Select(edgesOfT.get(0).getNodes().get(1));
		snc.Select(edgesOfT.get(1).getNodes().get(0));
		snc.Select(edgesOfT.get(1).getNodes().get(1));
		snc.Select(edgesOfT.get(2).getNodes().get(0));
		snc.Select(edgesOfT.get(2).getNodes().get(1));
		
		
//		assertTrue(t1.IsSolved());
//		
//		snc.Select(nodeList.get(0));
//		ArrayList<Node> selected = puzzle.getSelectedNodes();
//		assertEquals (nodeList.get(0).getID(), selected.get(0).getID());
//		UpdateButtons.enableButtons(app);
//		assertTrue (app.getBtnUnselectAll().isEnabled());
//		assertTrue (app.getBtnReset().isEnabled());
//		assertTrue (app.getBtnSwap().isEnabled());
//		
//		ArrayList<Edge> selectedEdges = puzzle.getSelectedEdges();
//		Point pt1 = coordinateToPoint(new Coordinate(15,12));
//		snc.process(pt1);
//		Node n2 = getNode(new Coordinate(15, 12)).get(); 
//		
//		assertFalse(t1.IsSolved());
		
	}
	
	@Test
	public void testSelect() {
		SelectNodeController snc = new SelectNodeController (model, app);
		TrianglePuzzle puzzle = model.getPuzzle();
		ArrayList<Node> nodeList = puzzle.getNodesList();
		ArrayList<Node> selected = puzzle.getSelectedNodes();
		snc.Select(nodeList.get(0));
		assertEquals(selected.get(0),nodeList.get(0));
	}
	
	
	@Test
	public void testUnSelcet() {
		SelectNodeController snc = new SelectNodeController (model, app);
		TrianglePuzzle puzzle = model.getPuzzle();
		ArrayList<Node> nodeList = puzzle.getNodesList();
		ArrayList<Node> selected = puzzle.getSelectedNodes();
		snc.Select(nodeList.get(0));
		snc.Unselect(nodeList.get(0));
		assertEquals(selected.size(),0);
	}
}
