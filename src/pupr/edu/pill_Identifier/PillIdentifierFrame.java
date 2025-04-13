package pupr.edu.pill_Identifier;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.filechooser.FileSystemView;


import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.Format;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.SwingConstants;
/*
 * Gives the user the requested pill's information
 */
@SuppressWarnings("serial")
public class PillIdentifierFrame extends JFrame{

	private JFrame frame;
	private JPanel contentPane;
	private JFileChooser chooseFile;
	private JLabel pill_Image_1;
	private String searchImprint; //search variable

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PillIdentifierFrame window = new PillIdentifierFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/*
	 * Allows user to search for files within their system
	 */
	public void createFileChooser() {
		chooseFile = new JFileChooser();
		chooseFile.setCurrentDirectory(new java.io.File("."));
	}
	
	public void thrower() throws SQLException{
		PillDatabase pill = new PillDatabase();
		
	}
	/**
	 * Create the application.
	 */
	public PillIdentifierFrame() {
		setTitle("Pill Identifier");
		
		setBounds(100, 100, 500, 421);
		
		JLabel pillReportLbl = new JLabel("Pill Report: ");
		pillReportLbl.setVerticalAlignment(SwingConstants.TOP);
		pillReportLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		pill_Image_1 = new JLabel(" Image");
		pill_Image_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		pill_Image_1.setHorizontalAlignment(SwingConstants.CENTER);
		pill_Image_1.setForeground(Color.DARK_GRAY);
		pill_Image_1.setBackground(Color.DARK_GRAY);
		
		JLabel imprintLbl = new JLabel("Pill Imprint: ");
		imprintLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel shapeLbl = new JLabel("Pill Shape: ");
		shapeLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel colorLbl = new JLabel("Pill Color: ");
		colorLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel nameLbl = new JLabel("Drug Name: ");
		nameLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel strengthLbl = new JLabel("Drug Strength: ");
		strengthLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel timeDateLbl = new JLabel("Time /Date: ");
		timeDateLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PillDatabase pill = new PillDatabase();
				
				String tempImprint = JOptionPane.showInputDialog("Input Database entry#");
				
				int integerImp = Integer.parseInt(tempImprint);
				int arrayPill = Integer.parseInt(tempImprint);
				List<Pill> pillImp = pill.getPillByImp(tempImprint);
				
				Pill pills = (Pill) pillImp.get(--arrayPill);
				
				receiveImprint(pills);
				imprintLbl.setText("Pill Imprint: " + pills.getPillImp());
				shapeLbl.setText("Pill Shape: " + pills.getPillShp());
				colorLbl.setText("Pill Color: " + pills.getPillClr());
				nameLbl.setText("Drug Name: " + pills.getDrugNm());
				strengthLbl.setText("Drug Strength: " + pills.getDrugStrngth());
				timeDateLbl.setText("Time /Date: " + pills.getEntryDate());
			}
		});
		
		
		
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(48)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(pill_Image_1, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(timeDateLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(strengthLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(nameLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(colorLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(imprintLbl, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
						.addComponent(pillReportLbl, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
						.addComponent(shapeLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(38))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(64)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(pill_Image_1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(pillReportLbl)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(imprintLbl)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(shapeLbl)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(colorLbl)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(nameLbl)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(strengthLbl)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(timeDateLbl)))
					.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(82))
		);
		getContentPane().setLayout(groupLayout);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 226, 343);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/*
	 * 
	 */
	public void receiveImprint(Pill imprint) {
		searchImprint = imprint.getPillImp();
		
		BufferedImage photo = null;
		try {
			photo = ImageIO.read(new File(imprint.getPillImg()));
		}catch(IOException e) {
			e.printStackTrace();
		}//end catch
		Image pill = photo.getScaledInstance(pill_Image_1.getWidth(), 
				pill_Image_1.getHeight(), Image.SCALE_SMOOTH);
		pill_Image_1.setIcon(new ImageIcon(pill));
		chooseFile = new JFileChooser();
		chooseFile.setSelectedFile(new File(imprint.getPillImg()));
	}
}
