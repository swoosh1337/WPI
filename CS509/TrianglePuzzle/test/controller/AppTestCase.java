package controller;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import boundary.TrianglePuzzleApp;
import boundary.TrianglePuzzleDrawer;
import model.Coordinate;
import model.ModelTestCase;

public abstract class AppTestCase extends ModelTestCase {

protected TrianglePuzzleApp app;
	
	@Before
	public void createApp() {
		app = new TrianglePuzzleApp(model);
		app.setVisible(true);
	}
	
	@After
	public void tearDown() throws Exception {
		app.setVisible(false);
	}
	
	/** 
	 * Map a Coordinate in puzzle to mouse point at center of square.
	 * 
	 * @param  c       Desired Coordinate.
	 * @return Point   Associated with the center of a square with given coordinate. 
	 */
	public static Point coordinateToPoint(Coordinate c){
		return new Point(c.col * TrianglePuzzleDrawer.size + TrianglePuzzleDrawer.size/2, c.row * TrianglePuzzleDrawer.size + TrianglePuzzleDrawer.size/2);
	}


}
