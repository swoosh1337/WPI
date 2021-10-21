package controller;

import boundary.TrianglePuzzleApp;
import model.Model;

public class ResetController {
	Model model;
	TrianglePuzzleApp app;
	
	public ResetController(Model m, TrianglePuzzleApp p) {
		this.model = m;
		this.app = p;
		
	}
	public void process() {
		Reset();
		
	}
	// reseting the puzzle
	public void Reset() {
		model.resetPuzzle();
		app.getPlayerMovesLabel().setText("" + model.getMoves());
		app.getPlayerScoreLabel().setText("" + model.getScore());
		app.getCongratzLabel().setText("");
		app.repaint();	
	}
}
