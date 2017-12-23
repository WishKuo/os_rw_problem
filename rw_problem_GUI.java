import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;

public class rw_problem_GUI {

	private JFrame frame;
	private JTextField txtCenter;
	private JTextField txtLeftside;
	private JTextField txtRightside;
	private JTextField txtBottom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rw_problem_GUI window = new rw_problem_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public rw_problem_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblTop = new JLabel("Top");
		frame.getContentPane().add(lblTop, BorderLayout.NORTH);
		
		txtCenter = new JTextField();
		txtCenter.setText("Center");
		frame.getContentPane().add(txtCenter, BorderLayout.CENTER);
		txtCenter.setColumns(10);
		
		txtLeftside = new JTextField();
		txtLeftside.setText("LeftSide");
		frame.getContentPane().add(txtLeftside, BorderLayout.WEST);
		txtLeftside.setColumns(10);
		
		txtRightside = new JTextField();
		txtRightside.setText("RightSide");
		frame.getContentPane().add(txtRightside, BorderLayout.EAST);
		txtRightside.setColumns(10);
		
		txtBottom = new JTextField();
		txtBottom.setText("Bottom");
		frame.getContentPane().add(txtBottom, BorderLayout.SOUTH);
		txtBottom.setColumns(10);
	}

}
