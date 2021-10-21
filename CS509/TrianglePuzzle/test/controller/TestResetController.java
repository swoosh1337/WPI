package controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.Coordinate;
import model.Edge;
import model.Node;
import model.Triangle;
import model.TrianglePuzzle;

public class TestResetController extends AppTestCase {

	@Test
	public void testReset() {
		TrianglePuzzle puzzle = model.getPuzzle();
		SelectNodeController snc = new SelectNodeController (model, app);
		ResetController rpc = new ResetController(model, app);
		
		Triangle t1 = model.getPuzzle().getTrianglesList().get(0);
		ArrayList<Edge> edgesOfT = t1.getEdges();
		ArrayList<Node> nodeList = puzzle.getNodesList();
		
		
		snc.Select(edgesOfT.get(0).getNodes().get(0));
		snc.Select(edgesOfT.get(0).getNodes().get(1));
		snc.Select(edgesOfT.get(1).getNodes().get(0));
		snc.Select(edgesOfT.get(1).getNodes().get(1));
		snc.Select(edgesOfT.get(2).getNodes().get(0));
		snc.Select(edgesOfT.get(2).getNodes().get(1));
		rpc.Reset();
		
		assertEquals (0, model.getMoves());
		assertEquals(0,model.getScore());
		
		assertEquals(app.getCongratzLabel().getText(),"");
		assertEquals(app.getPlayerScoreLabel().getText(),"0");
		assertEquals(app.getPlayerMovesLabel().getText(),"0");
	}
	
	@Test
	public void testProcess() {
		
			TrianglePuzzle puzzle = model.getPuzzle();
			SelectNodeController snc = new SelectNodeController (model, app);
			ResetController rpc = new ResetController(model, app);
			
			Triangle t1 = model.getPuzzle().getTrianglesList().get(0);
			ArrayList<Edge> edgesOfT = t1.getEdges();
			ArrayList<Node> nodeList = puzzle.getNodesList();
			
			
			snc.Select(edgesOfT.get(0).getNodes().get(0));
			snc.Select(edgesOfT.get(0).getNodes().get(1));
			snc.Select(edgesOfT.get(1).getNodes().get(0));
			snc.Select(edgesOfT.get(1).getNodes().get(1));
			snc.Select(edgesOfT.get(2).getNodes().get(0));
			snc.Select(edgesOfT.get(2).getNodes().get(1));
			rpc.process();
			assertEquals (0, model.getMoves());
			assertEquals(0,model.getScore());
			
			assertEquals(app.getCongratzLabel().getText(),"");
			assertEquals(app.getPlayerScoreLabel().getText(),"0");
			assertEquals(app.getPlayerMovesLabel().getText(),"0");
		}
	}


