package controller;

import javax.swing.JOptionPane;

import boundary.TrianglePuzzleApp;


public class ExitController {
	TrianglePuzzleApp app;
	
	public ExitController(TrianglePuzzleApp app) {
		this.app = app;
	}

	// ask if user wants to quit the App
	public void exit() {
		int c = JOptionPane.showConfirmDialog(app, "Do you wish to exit application?");
		if (c == JOptionPane.OK_OPTION) {
			app.setVisible(false);
			app.dispose();
		}
	}
	
}
