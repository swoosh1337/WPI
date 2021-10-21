package controller;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import boundary.TrianglePuzzleApp;
import boundary.UpdateButtons;
import model.Coordinate;
import model.Edge;
import model.Model;
import model.Node;
import model.Triangle;
import model.TrianglePuzzle;

public class SelectNodeController   {
	
	Model model;
	TrianglePuzzleApp app;
	

	
	public SelectNodeController(Model m, TrianglePuzzleApp p) {
		this.model = m;
		this.app = p;
	}
	
	public void process(Point p) {
		//getting necessary objects 
		Coordinate c = app.getPanel().pointToCoordiante(p);
		TrianglePuzzle puzzle = model.getPuzzle();
		ArrayList<Node> selectedNodes = puzzle.getSelectedNodes();
		ArrayList<Edge> selectedEdges = puzzle.getSelectedEdges();
		ArrayList<Edge> allEdges = puzzle.getEdgesList();
		ArrayList<Triangle> triangles = puzzle.getTrianglesList();
		
		for (Node n : puzzle.getNodesList()) { // if we press on a node that is not selected and the amount of selected nodes is less than 4 then select the node
			if (n.contains(c)  && n.isSelected == false && selectedNodes.contains(n) == false && selectedNodes.size() < 4 && puzzle.getIsSolved() == false) {
				
				Select(n);
				UpdateButtons.enableButtons(app);
				app.repaint();
	
			}
			
			else if (n.contains(c)  && n.isSelected == true){ // else if we press a node and it is already selected, unselect it

				Unselect(n);
				
				UpdateButtons.enableButtons(app);
				app.repaint();
			}
			
			
			else {
				UpdateButtons.enableButtons(app);
				app.repaint();
			}
			
			
			
		}
		
		for (Edge e : allEdges ) { // check edges, if nodes of edge is selected that means that edge is selected 
			if(e.getNodes().get(0).isSelected() == true && e.getNodes().get(1).isSelected() == true && selectedEdges.contains(e)  == false && selectedEdges.size()<3) {
				selectedEdges.add(e);
				System.out.println("adding edge...");
				app.repaint();
			}
			else if(selectedEdges.contains(e) && e.check() == false) { // if we unselect a node then edge should be removed from selected edges list
				System.out.println("removing edge...");
				selectedEdges.remove(e);
			}
			
		}
		
	
	}
	

	// selecting a node 
	public void  Select(Node n) {
		if(n.isSelected() == false) {
			n.setSelected(true);
			TrianglePuzzle puzzle = model.getPuzzle();
			ArrayList<Node> selectedNodes = puzzle.getSelectedNodes();
			selectedNodes.add(n);
			
		}
		
		
	}
	// unselecting a node
	public void Unselect(Node n) {
		if(n.isSelected() == true) {
			TrianglePuzzle puzzle = model.getPuzzle();
			ArrayList<Node> selectedNodes = puzzle.getSelectedNodes();
			n.setSelected(false);
			selectedNodes.remove(n);
			
		}
		
	
		
	}
	

}
