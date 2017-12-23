import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.concurrent.TimeUnit;
import javax.swing.event.*;

public class rw_problem2_GUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rw_problem2_GUI window = new rw_problem2_GUI();
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
	public rw_problem2_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblPressStartButton = new JLabel("Press START button to start.");
		lblPressStartButton.setBounds(136, 256, 183, 16);
		frame.getContentPane().add(lblPressStartButton);
			
		JLabel writerNum = new JLabel("");
		writerNum.setBounds(136, 48, 297, 16);
		frame.getContentPane().add(writerNum);
		
		JLabel readerNum = new JLabel("");
		readerNum.setBounds(90, 166, 256, 23);
		frame.getContentPane().add(readerNum);
		
		JButton btnSTART = new JButton("START");
		btnSTART.setBounds(170, 221, 117, 29);
		btnSTART.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writerNum.setText("There are"+" of us still writing now!"); //the number of writers who are reading now must be added 
				
				readerNum.setText("Okay, then I'll wait.");
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnSTART);
		
		
		
		JLabel lblBookWarm = new JLabel("BookWorm.jpg");
		lblBookWarm.setBounds(16, 6, 138, 121);
		frame.getContentPane().add(lblBookWarm);
	}
}
