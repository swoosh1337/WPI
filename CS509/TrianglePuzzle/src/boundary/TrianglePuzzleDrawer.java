package boundary;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.Coordinate;
import model.Edge;
import model.Model;
import model.Node;
import model.TrianglePuzzle;

public class TrianglePuzzleDrawer extends JPanel {

	/**
	 * Create the panel.
	 */
	
	Model model;
	public static final int size = 10;
	public static final int offset = 11;
	
	public TrianglePuzzleDrawer(Model model) {
		this.model = model;

	}
	
	
	public Rectangle computeRectangle(Node n) {
		int col = n.getCol();
		int row = n.getRow();
		int width = n.width;
		int height = n.height;
		
		Rectangle rect = new Rectangle(col*size  ,row*size ,width*(size ), height*(size ));
		return rect;
	}
	

	public Coordinate pointToCoordiante(Point p) {
		return new Coordinate(p.x/size, p.y/size);
		
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(model == null) {return;} // nothing to draw. only here for window builder
		
		TrianglePuzzle puzzle = model.getPuzzle();
		ArrayList<Node> selectedNodes = puzzle.getSelectedNodes();
		ArrayList<Edge> selectedEdges = puzzle.getSelectedEdges();
		ArrayList<Node> Nodes = puzzle.getNodesList();
		ArrayList<Edge> Edges = puzzle.getEdgesList();
		
		
		
		
		
		for(Edge e: Edges) {
			
			if(selectedEdges.contains(e)) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setColor(e.color);
	            g2.setStroke(new BasicStroke(5));
	            g2.draw(new Line2D.Float(e.getCol1()*size+offset, e.getRow1()*size+ offset, e.getCol2()*size +offset, e.getRow2()*size+offset));
				
			}
			
			else {

				Graphics2D g2 = (Graphics2D) g;
				g2.setColor(e.color);
	            g2.setStroke(new BasicStroke(5));
	            g2.draw(new Line2D.Float(e.getCol1()*size+offset, e.getRow1()*size+ offset, e.getCol2()*size +offset, e.getRow2()*size+offset));
			}
			
				
		}
		
//		for(Edge a: selectedEdges) {
//			
//			//col*size + offset ,row*size + offset,width*(size - 2*offset), height*(size - 2*offset)
//			//g.setColor(e.color);
//			
//			Graphics2D g3 = (Graphics2D) g;
//			g3.setColor(a.color);
//            g3.setStroke(new BasicStroke(5));
//            g3.draw(new Line2D.Float(a.getCol1()*size+offset,a.getRow1()*size+ offset, a.getCol2()*size +offset, a.getRow2()*size+offset));
////			g.drawLine(e.getCol1()*size, e.getRow1()*size, e.getCol2()*size, e.getRow2()*size);
//			
//			System.out.println("salam bratva" + selectedEdges.size());
//			
//		}
//		



		for(Node n : Nodes) {
					
					if (n.isSelected == true ) {
						
						g.setColor(Color.black);
//						System.out.println(selectedNodes.size() + "<=== selcted size ");
						
					}
					else if (n.isSelected == false){
						g.setColor(Color.white);
//						System.out.println(selectedNodes.size() + " <=size");
					}
					
		
					Rectangle r = computeRectangle(n);
					g.fillRect(r.x, r.y, r.width, r.height);
					
					
				}
					
//		
		
		
		
		
	}




}
