package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Edge;
import model.Model;
import model.Node;
import model.Triangle;
import model.TrianglePuzzle;
import controller.ResetController;
import controller.SelectNodeController;
import controller.SwapEdgesController;
import controller.UnselectAllNodesController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class TrianglePuzzleApp extends JFrame {

	private JPanel contentPane;
	Model model;
	TrianglePuzzleDrawer panel;
	JButton btnSwap,btnUnselectAll,btnReset;
	JLabel lblMoves,lblScore,playerMovesLabel,playerScoreLabel,congratzLabel;
	
	public JButton getBtnSwap() { return btnSwap; }
	public JButton getBtnUnselectAll() { return btnUnselectAll; }
	public JButton getBtnReset() { return btnReset;}

	
	public JLabel getPlayerMovesLabel() { return playerMovesLabel; }
	public JLabel getPlayerScoreLabel() { return playerScoreLabel; }
	public JLabel getCongratzLabel() { return congratzLabel; }
	public TrianglePuzzleDrawer  getPanel() { return panel; }

	/**
	 * Create the frame.
	 */
	public TrianglePuzzleApp(Model model) {
		super();
		setResizable(false);
		this.model = model;
		setTitle("Triangle Puzzle App  (c) 2021 Irakli Grigolia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new TrianglePuzzleDrawer(model);
		panel.setBackground(Color.GRAY);
		
		TrianglePuzzle puzzle = model.getPuzzle();
		ArrayList<Edge> selectedEdges = puzzle.getSelectedEdges();
		ArrayList<Node> selectedNodes = puzzle.getSelectedNodes();
		ArrayList<Triangle> triangles = puzzle.getTrianglesList();
		
	
		
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				new SelectNodeController(model,TrianglePuzzleApp.this).process(me.getPoint());
			}
		});
		
		
		btnSwap = new JButton("Swap ");
		btnSwap.setEnabled(false);
		
		btnSwap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new SwapEdgesController(model, TrianglePuzzleApp.this).process();
			}
		});
		
		btnUnselectAll = new JButton("Unselect All");
		btnUnselectAll.setEnabled(false);
		btnUnselectAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new UnselectAllNodesController(model, TrianglePuzzleApp.this).process();
			}
		});
		btnReset = new JButton("Reset");
		btnReset.setEnabled(false);
		btnReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ResetController(model, TrianglePuzzleApp.this).process();
			}
		});
		
		lblMoves = new JLabel("Moves:");
		
		lblScore = new JLabel("Score:");
		
		playerMovesLabel = new JLabel("" + model.getMoves());
		
		playerScoreLabel = new JLabel("0");
		
		congratzLabel = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnSwap, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnUnselectAll, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblMoves)
										.addComponent(lblScore))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(playerScoreLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(playerMovesLabel, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED, 92, Short.MAX_VALUE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(congratzLabel, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMoves)
								.addComponent(playerMovesLabel))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblScore)
								.addComponent(playerScoreLabel))
							.addGap(102)
							.addComponent(congratzLabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnUnselectAll)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSwap)
								.addComponent(btnReset))))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
