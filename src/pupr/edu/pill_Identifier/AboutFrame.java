package pupr.edu.pill_Identifier;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;

/*
 * This frame display information
 * about the program, including version and creators name
 */
@SuppressWarnings("serial")
public class AboutFrame extends JFrame{

	private JFrame frmAbout;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutFrame window = new AboutFrame();
					window.frmAbout.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AboutFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAbout = new JFrame();
		frmAbout.setResizable(false);
		frmAbout.getContentPane().setBackground(new Color(255, 255, 255));
		frmAbout.setTitle("About ");
		frmAbout.setBounds(100, 100, 595, 225);
		frmAbout.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pill Identifier");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Version 1.0.0");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_2 = new JLabel("(c) Copyright Eclipse contributors and others 2000, 2007.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel lblNewLabel_3 = new JLabel("All rights reserved");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel lblNewLabel_4 = new JLabel("Made By: ");
		lblNewLabel_4.setFont(new Font("Cambria Math", Font.PLAIN, 12));
		
		JLabel lblNewLabel_5 = new JLabel("Daryl Zambrana Feliciano");
		lblNewLabel_5.setFont(new Font("Cambria Math", Font.PLAIN, 12));
		
		JLabel lblNewLabel_6 = new JLabel("For Support Contact zambrana_127641@students.pupr.edu");
		lblNewLabel_6.setFont(new Font("Cambria Math", Font.PLAIN, 10));
		
		JLabel lblNewLabel_7 = new JLabel("Release (8.1.7)");
		GroupLayout groupLayout = new GroupLayout(frmAbout.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(226)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(220)
							.addComponent(lblNewLabel_1)))
					.addContainerGap(253, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(240)
					.addComponent(lblNewLabel_7)
					.addContainerGap(264, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(247)
					.addComponent(lblNewLabel_4)
					.addContainerGap(281, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(208)
					.addComponent(lblNewLabel_5)
					.addContainerGap(239, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(241)
					.addComponent(lblNewLabel_3)
					.addContainerGap(257, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(159, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_6)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE))
					.addGap(156))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_5)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_7)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_6)
					.addContainerGap(64, Short.MAX_VALUE))
		);
		frmAbout.getContentPane().setLayout(groupLayout);
	}
}
