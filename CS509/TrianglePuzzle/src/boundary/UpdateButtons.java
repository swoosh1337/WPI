package boundary;

import java.util.ArrayList;

import model.Edge;
import model.Node;
import model.Triangle;
import model.TrianglePuzzle;

public class UpdateButtons {
	public static void enableButtons(TrianglePuzzleApp app ) {
		
		// enabling and disabling buttons based on different situations
		
		app.getBtnSwap().setEnabled(false);
		app.getBtnReset().setEnabled(false);
		app.getBtnUnselectAll().setEnabled(false);
	
		TrianglePuzzle puzzle = app.model.getPuzzle();
		ArrayList<Edge> selectedEdges = puzzle.getSelectedEdges();
		ArrayList<Node> selectedNodes = puzzle.getSelectedNodes();
		ArrayList<Triangle> triangles = puzzle.getTrianglesList();
		
		
		if(selectedNodes.size() == 0 && app.model.getMoves() !=0) {
			
			app.getBtnSwap().setEnabled(false);
			app.getBtnReset().setEnabled(true);
			app.getBtnUnselectAll().setEnabled(false);
		}
		
		else if (selectedNodes.size() == 0) {
			app.getBtnSwap().setEnabled(false);
			app.getBtnReset().setEnabled(true);
			app.getBtnUnselectAll().setEnabled(false);
		}
		
		
		else if (selectedNodes.size() <3 || selectedNodes.size() >3 ) {
			
			app.getBtnSwap().setEnabled(false);
			app.getBtnReset().setEnabled(true);
			app.getBtnUnselectAll().setEnabled(true);
		}
		
		
		else if (selectedNodes.size() == 0 || selectedNodes.size() >3 ) {
			app.getBtnSwap().setEnabled(false);
			app.getBtnReset().setEnabled(true);
			app.getBtnUnselectAll().setEnabled(true);
		}
		
	
		
		
		else if(app.model.getPuzzle().getIsSolved()) {
			app.getBtnSwap().setEnabled(false);
			app.getBtnReset().setEnabled(true);
			app.getBtnUnselectAll().setEnabled(false);
		}
		
		
		
		
		else {

			app.getBtnSwap().setEnabled(true);
			app.getBtnReset().setEnabled(true);
			app.getBtnUnselectAll().setEnabled(true);
		
			
		}
		
		
	
	}
}
