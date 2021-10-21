package controller;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import boundary.TrianglePuzzleApp;
import boundary.UpdateButtons;
import model.Coordinate;
import model.Edge;
import model.Model;
import model.Node;
import model.Triangle;
import model.TrianglePuzzle;

public class SwapEdgesController {
	Model model;
	TrianglePuzzleApp app;
	
	public SwapEdgesController(Model m, TrianglePuzzleApp p) {
		this.model = m;
		this.app = p;
	
	}
	
	public void process() {
		   app.repaint();
		//getting necessary objects  
		TrianglePuzzle puzzle = model.getPuzzle();
		ArrayList<Edge> selectedEdges = puzzle.getSelectedEdges();
		ArrayList<Node> selectedNodes = puzzle.getSelectedNodes();
		ArrayList<Triangle> triangles = puzzle.getTrianglesList();
		
	
		// if 3 edges have been selected, it means they form a triangle so we need to swap them clockwise
		if(selectedEdges.size()==3) {
			puzzle.SwapClockWise(selectedEdges.get(0), selectedEdges.get(1), selectedEdges.get(2));
			app.repaint();
			System.out.println("swapping edges clockwise... "); 
			
		}
		
		else if(selectedEdges.size() == 2){ // if 2 edges are selected we perform the regular swap
			puzzle.SwapEdges(selectedEdges.get(0),selectedEdges.get(1));
			app.repaint();
			System.out.println("swapping edges normal...");
			
		}
		
	
		
	
		// after swap we unselect selected nodes
		for(Node n : puzzle.getNodesList()) {
			if(n.isSelected) {
				n.isSelected = false;
			}
		}
		// update UI and then clear selected edges and node lists
		app.repaint();
		selectedEdges.clear();
		selectedNodes.clear();
		UpdateButtons.enableButtons(app);
		
		
		// after a swap operation we go through triangles and check if they are solved( have the same color)
		for(Triangle t: triangles) {
			if(t.IsSolved() && puzzle.getSolved().contains(t) == false) {
				puzzle.addSolved(t);
				model.setScore(10); // update score
				
			}
			
			
			else if(puzzle.getSolved().contains(t) && t.IsSolved() == false) {
				puzzle.removeSolved(t);
				t.setColor(Color.black);
				model.setScore(-10); // if triangle is no longer solved ( edge has been swapped) then decrease the score by 10
				
				
			}
		}
	   
		   // after every move increase move count by 1 and decrease the score by 1
		 	model.setScore(-1);
		    model.setMoves(1);
		    app.getPlayerMovesLabel().setText("" + model.getMoves());
		    app.getPlayerScoreLabel().setText("" + model.getScore());
		    
		    if(CheckIfSolved()) { // check if puzzle has been solved, if yes display msg
		    	app.getCongratzLabel().setText("Congratulations, You Won!");
		    	
		    }
		    
		    else {
		    	app.getCongratzLabel().setText("");
		    }
	}
	


	public boolean CheckIfSolved() {
		if(model.isSolved()) {
			return true;
		} else {
			return false;
		}
	}
	

	

}
