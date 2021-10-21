package controller;

import java.util.ArrayList;

import boundary.TrianglePuzzleApp;
import boundary.UpdateButtons;
import model.Edge;
import model.Model;
import model.Node;
import model.TrianglePuzzle;

public class UnselectAllNodesController {

	Model model;
	TrianglePuzzleApp app;
	
	public UnselectAllNodesController(Model m, TrianglePuzzleApp p) {
		this.model = m;
		this.app = p;
		
	}
	// get selected nodes and unselect them
	public void process() {
		ArrayList<Node> nodes = model.getPuzzle().getSelectedNodes();
		if(nodes.size() !=0) {
			UnselectAll();
			UpdateButtons.enableButtons(app);
			app.repaint();	
			
		}
		
		
		
	}
			
		
		
	
	
	public  boolean UnselectAll() {
		
		TrianglePuzzle puzzle = model.getPuzzle();
		ArrayList<Node> nodes = puzzle.getNodesList();
		ArrayList<Node> selectedNodes = puzzle.getSelectedNodes();
		ArrayList<Edge> selectedEdges = puzzle.getSelectedEdges();
		
		//get selected edges ,go through them and make them unselected, also update selected edges list
		
		for(Node n : nodes) {
			if(n.isSelected) {
				n.isSelected = false;
			}
		}
		
		selectedNodes.clear();
		selectedEdges.clear();
		return true;
		
	}
}
