import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import boundary.TrianglePuzzleApp;
import controller.ExitController;
import model.Edge;
import model.Model;
import model.Node;
import model.Triangle;
import model.TrianglePuzzle;
import model.Model;

public class Main {
	public static void main(String[] args) {

		// creating model and triangle puzzle
		Model m = new Model();
		TrianglePuzzle puzzle = new TrianglePuzzle();
		
		// creating nodes
		
	
		

		// adding nodes to puzzle
	
	
		
		
	
//		
		m.setPuzzle(puzzle);
		TrianglePuzzleApp tpa = new TrianglePuzzleApp(m);
		
		tpa.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				new ExitController(tpa).exit();
			}
		});
		tpa.setVisible(true);
		
	}
}
