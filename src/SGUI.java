

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class SGUI {

	public JFrame frmSudokuSolver;
	public JTable table;
	public JLabel invalidExceptionLabel;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SGUI window = new SGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the application.
	 */
	public SGUI() {
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
		boardPanel.setLayout(null);
		
		table = new JTable();
		table.setBounds(6, 16, 296, 296);
		boardPanel.add(table);
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"0", "1", "2", "3", "4", "5", "6", "7", "8"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(33);
		table.getColumnModel().getColumn(0).setMinWidth(33);
		table.getColumnModel().getColumn(0).setMaxWidth(33);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(33);
		table.getColumnModel().getColumn(1).setMinWidth(33);
		table.getColumnModel().getColumn(1).setMaxWidth(33);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(33);
		table.getColumnModel().getColumn(2).setMinWidth(33);
		table.getColumnModel().getColumn(2).setMaxWidth(33);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(33);
		table.getColumnModel().getColumn(3).setMinWidth(33);
		table.getColumnModel().getColumn(3).setMaxWidth(33);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(33);
		table.getColumnModel().getColumn(4).setMinWidth(33);
		table.getColumnModel().getColumn(4).setMaxWidth(33);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(33);
		table.getColumnModel().getColumn(5).setMinWidth(33);
		table.getColumnModel().getColumn(5).setMaxWidth(33);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(6).setPreferredWidth(33);
		table.getColumnModel().getColumn(6).setMinWidth(33);
		table.getColumnModel().getColumn(6).setMaxWidth(33);
		table.getColumnModel().getColumn(7).setResizable(false);
		table.getColumnModel().getColumn(7).setPreferredWidth(33);
		table.getColumnModel().getColumn(7).setMinWidth(33);
		table.getColumnModel().getColumn(7).setMaxWidth(33);
		table.getColumnModel().getColumn(8).setResizable(false);
		table.getColumnModel().getColumn(8).setPreferredWidth(33);
		table.getColumnModel().getColumn(8).setMinWidth(33);
		table.getColumnModel().getColumn(8).setMaxWidth(33);
		table.setRowHeight(33);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						table.setValueAt(null, i, j);
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
}