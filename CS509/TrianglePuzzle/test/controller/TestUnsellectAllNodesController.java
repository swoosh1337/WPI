package controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.Node;
import model.TrianglePuzzle;

public class TestUnsellectAllNodesController extends AppTestCase {

	@Test
	public void testUnselectAll() {
		TrianglePuzzle puzzle = model.getPuzzle();
		UnselectAllNodesController unc = new UnselectAllNodesController(model,app);
		ArrayList<Node> allNodes = puzzle.getNodesList();
		
		SelectNodeController snc = new SelectNodeController (model, app);
		snc.Select(allNodes.get(0));
		snc.Select(allNodes.get(1));
		assertTrue(puzzle.getSelectedNodes().size() != 0);
		unc.UnselectAll();
		
		assertTrue(puzzle.getSelectedNodes().size() == 0);
		
		
		
	}
	
	@Test
	public void testProcess() {
		TrianglePuzzle puzzle = model.getPuzzle();
		UnselectAllNodesController unc = new UnselectAllNodesController(model,app);
		ArrayList<Node> allNodes = puzzle.getNodesList();
		
		SelectNodeController snc = new SelectNodeController (model, app);
		snc.Select(allNodes.get(0));
		snc.Select(allNodes.get(1));
		snc.Select(allNodes.get(2));
		snc.Select(allNodes.get(3));
		assertTrue(puzzle.getSelectedNodes().size() != 0);
		unc.process();
		
		assertTrue(puzzle.getSelectedNodes().size() == 0);
		
		
		
	}

}
