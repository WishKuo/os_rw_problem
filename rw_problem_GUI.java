import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.*;
//import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class rw_problem_GUI {

	private JFrame frame;

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
		


		JLabel lblPressStartButton = new JLabel("Press START button to start.");
		lblPressStartButton.setBounds(136, 256, 183, 16);
		frame.getContentPane().add(lblPressStartButton);
			
		JLabel readerNum = new JLabel("");
		readerNum.setBounds(177, 34, 256, 37);
		frame.getContentPane().add(readerNum);
		
		JLabel writerNum = new JLabel("");
		writerNum.setBounds(90, 155, 256, 23);
		frame.getContentPane().add(writerNum);
		
	
		
		JButton btnSTART = new JButton("START");
		btnSTART.setBounds(170, 221, 117, 29);
		btnSTART.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int readerNumber=2;
				if(readerNumber==0){
					readerNum.setText("Now, it's writer's turn!"); 
					writerNum.setText("Oh yeah~ It's time for me to write.");
				}
				else{
				readerNum.setText("There are "+readerNumber+" of us still reading now!"); 
				//readerNumber = the number of readers who are reading now must be added 
				writerNum.setText("Okay, then I'll wait.");
				}
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnSTART);
		
		
		ImageIcon png2 = new ImageIcon("DialogSpace.png");
		JLabel lblDialogspace = new JLabel(png2);//The space for words
		lblDialogspace.setBounds(125, 6, 319, 94);
		frame.getContentPane().add(lblDialogspace);
		
		ImageIcon png4 = new ImageIcon("DialogSpace2.png");
		JLabel lblDialogspace_1 = new JLabel(png4);
		lblDialogspace_1.setBounds(56, 129, 277, 80);
		frame.getContentPane().add(lblDialogspace_1);
	
		ImageIcon png1 = new ImageIcon("BookWorm.png");
		JLabel lblBookWarm = new JLabel(png1);
		lblBookWarm.setBounds(16, 6, 142, 123);
		frame.getContentPane().add(lblBookWarm);
		
		ImageIcon png3 = new ImageIcon("pen.png");
		JLabel lblPen = new JLabel(png3);
		lblPen.setBounds(299, 106, 145, 166);
		frame.getContentPane().add(lblPen);
		

	}
}
