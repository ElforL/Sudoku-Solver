

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;

public class GUI2 {

	public JFrame frmSudokuSolver;
	public JLabel invalidExceptionLabel;
	private JLabel lblNewLabel;
	JTextField[][] table = new JTextField[9][9];
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI2 window = new GUI2();
					window.frmSudokuSolver.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public GUI2() {
		initialize();
		frmSudokuSolver.setVisible(true);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		frmSudokuSolver = new JFrame();
		frmSudokuSolver.setTitle("Sudoku Solver");
		frmSudokuSolver.setResizable(false);
		frmSudokuSolver.setBounds(100, 100, 450, 559);
		frmSudokuSolver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSudokuSolver.getContentPane().setLayout(null);
		
		JButton btnSolve = new JButton("Solve");
		btnSolve.setFocusPainted(false);
		btnSolve.setContentAreaFilled(false);
		btnSolve.setFont(new Font("Cairo light", Font.PLAIN, 15));
		btnSolve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invalidExceptionLabel.setText("");
				Sudoku.solve();
			}
		});
		btnSolve.setBounds(71, 486, 110, 23);
		frmSudokuSolver.getContentPane().add(btnSolve);
		
		JPanel boardPanel = new JPanel();
		boardPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Board: ", TitledBorder.LEFT, TitledBorder. TOP,new Font("Cairo SemiBold", Font.PLAIN, 10), new Color(0, 0, 0)));
		boardPanel.setBounds(71, 126, 308, 319);
		frmSudokuSolver.getContentPane().add(boardPanel);
		boardPanel.setLayout(new GridLayout(9, 9, 0, 0));
		
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table.length; j++) {
				table[i][j] = new JTextField();
				table[i][j].setHorizontalAlignment(JTextField.CENTER);
				boardPanel.add(table[i][j]);
			}
		}
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						table[i][j].setText("");;
					}
				}
			}
		});
		btnReset.setBounds(269, 486, 110, 23);
		btnReset.setFocusPainted(false);
		btnReset.setContentAreaFilled(false);
		btnReset.setFont(new Font("Cairo light", Font.PLAIN, 15));
		frmSudokuSolver.getContentPane().add(btnReset);
		
		invalidExceptionLabel = new JLabel("");
		invalidExceptionLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		invalidExceptionLabel.setForeground(Color.RED);
		invalidExceptionLabel.setBounds(40, 102, 370, 14);
		invalidExceptionLabel.setHorizontalAlignment(JLabel.CENTER);
		frmSudokuSolver.getContentPane().add(invalidExceptionLabel);
		
		lblNewLabel = new JLabel("Sudoku Solver");
		lblNewLabel.setFont(new Font("Cairo Light", Font.PLAIN, 23));
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel.setBounds(92, 39, 266, 52);
		frmSudokuSolver.getContentPane().add(lblNewLabel);
	}
	
	public void loadNums(int[][] arr_board) {
		for (int i = 0; i < arr_board.length; i++) {
			for (int j = 0; j < arr_board[i].length; j++) {
				table[i][j].setText(""+arr_board[i][j]);
			}
		}
	}
	
}