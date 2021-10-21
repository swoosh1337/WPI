package controller;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import org.junit.Test;

import model.Coordinate;
import model.Edge;
import model.Node;
import model.Triangle;
import model.TrianglePuzzle;

public class TestSwapEdgesController extends AppTestCase {

	@Test
	public void testIsSolved() {
		SwapEdgesController sc = new SwapEdgesController(model, app);
		assertFalse(sc.CheckIfSolved());
	}
	
	
	@Test
	public void testProcess1() {
		TrianglePuzzle puzzle = model.getPuzzle();
		
		ArrayList<Node> selectedNodes = puzzle.getSelectedNodes();
		ArrayList<Triangle> triangles = puzzle.getTrianglesList();
		
		ArrayList<Edge> edges = puzzle.getEdgesList();
		ArrayList<Node> nodes = puzzle.getNodesList();
		
		SelectNodeController snc = new SelectNodeController(model,app);
		
		snc.Select(nodes.get(0));
		snc.Select(nodes.get(1));
		snc.Select(nodes.get(4));
		Point pt = coordinateToPoint(new Coordinate(1,4));
		snc.process(pt);
		ArrayList<Edge> selectedEdges = puzzle.getSelectedEdges();
		System.out.println(selectedEdges + "selectedEDg4ess");
		
		
		SwapEdgesController  swc = new SwapEdgesController(model,app);
		swc.process();
		assertEquals(Color.blue,edges.get(0).getColor());
		assertEquals(app.getCongratzLabel().getText(),"");
		
		snc.Select(nodes.get(1));
		snc.Select(nodes.get(3));
		snc.Select(nodes.get(4));
		
		Point pt2 = coordinateToPoint(new Coordinate(1,4));
		snc.process(pt2);
		swc.process();
		
		
		
		model.getPuzzle().setIsSolved(true);
		
		
		Point pt3 = coordinateToPoint(new Coordinate(1,4));
		snc.process(pt3);
		swc.process();
//		assertEquals(app.getCongratzLabel().getText(),"Congratulations, You Won!");
		
		
		
		
	
		
	}

}
