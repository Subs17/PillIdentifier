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
 * This is the Frame that modifies any given entry in the database
 */
public class ModifyPillFrame extends JFrame{

	private JFrame frame;
	private JPanel contentPane;
	private JTextField txtPillImprint;
	private JTextField txtDrugName;
	private JFileChooser chooseFile;
	private JLabel pill_Image_1;
	private JTextField txtDrugStrength;
	private String searchImprint; //search variable

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyPillFrame window = new ModifyPillFrame();
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
	
	
	/**
	 * Create the application.
	 */
	public ModifyPillFrame() {
		setTitle("Modify Pill");
		
		setBounds(100, 100, 500, 421);
		
		
		
		txtPillImprint = new JTextField();
		txtPillImprint.setEditable(false);
		txtPillImprint.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtPillImprint.selectAll();
			}
		});
		txtPillImprint.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtPillImprint.setText("Pill Imprint:");
		txtPillImprint.setColumns(10);
		
		JComboBox shapeComboBox = new JComboBox();
		shapeComboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		shapeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Round", "Capsule", "Oval", "Egg", "Barrel", "Rectangle"}));
		
		JComboBox colorComboBox = new JComboBox();
		colorComboBox.setModel(new DefaultComboBoxModel(new String[] {"White", "Blue", "Red", "Brown", "Pink", "Purple", "Orange", "Peach", "Blue/Red"}));
		colorComboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtDrugName = new JTextField();
		txtDrugName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtDrugName.selectAll();
			}
		});
		txtDrugName.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtDrugName.setText("Drug Name:");
		txtDrugName.setColumns(10);
		
		/*
		 * Drug Strength 
		 */
		txtDrugStrength = new JTextField();
		txtDrugStrength.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtDrugStrength.selectAll();
			}
		});
		txtDrugStrength.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtDrugStrength.setText("Drug Strength: ");
		txtDrugStrength.setColumns(10);
		
		JLabel timeDateLbl = new JLabel("Time/Date: ");
		timeDateLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		/*
		 * Add Button
		 * Adds all info into database
		 */
		JButton modifyPillBttn = new JButton("Modify Pill");
		modifyPillBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * Grabs time and date from system and saves it
				 * into a string variable
				 */
				Date date = Calendar.getInstance().getTime();  
				Format formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
				String img = chooseFile.getSelectedFile().getAbsolutePath();
				String timeN_Date = formatter.format(date);
				
				PillDatabase pill = new PillDatabase();
				timeDateLbl.setText(timeN_Date);
				
					int updatedPill = pill.modifyPill(searchImprint, shapeComboBox.getSelectedItem().toString(), 
							colorComboBox.getSelectedItem().toString(),txtDrugName.getText(), txtDrugStrength.getText(), img, timeN_Date);
					txtPillImprint.setText("Pill Imprint:");
					txtDrugName.setText("Drug Name:");
					txtDrugStrength.setText("Drug Strength: ");
					
					System.out.println(updatedPill);
					if(updatedPill == 1) {
						JOptionPane.showMessageDialog(null, "UPDATE SUCCESSFUL!");
					} else {
						
						JOptionPane.showMessageDialog(null, "UPDATE UNSUCCESSFUL!");
					}
					dispose();
				
			}
		});
		modifyPillBttn.setFont(new Font("Tahoma", Font.BOLD, 12));
		/*
		 * Allows user to press Upload Photo Button
		 * and open up JFileChooser to upload selected photo 
		 * from within system
		 */
		JButton photoBttn = new JButton("Upload Photo");
		photoBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				createFileChooser();
				chooseFile.showOpenDialog(contentPane);
				String imagePath = chooseFile.getSelectedFile().getAbsolutePath();
				BufferedImage pill = null;
				try {
					//reads path where image is stored
					pill = ImageIO.read(new File(imagePath));
				}catch(IOException e) { //verifies image has correct parameters
					e.printStackTrace();
				}
				
				Image pillImg = pill.getScaledInstance(pill_Image_1.getHeight(), pill_Image_1.getWidth(),
															Image.SCALE_SMOOTH);
				pill_Image_1.setIcon(new ImageIcon(pillImg));
			}
		});
		
		photoBttn.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		pill_Image_1 = new JLabel("IMAGE");
		pill_Image_1.setHorizontalAlignment(SwingConstants.CENTER);
		pill_Image_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		pill_Image_1.setForeground(Color.DARK_GRAY);
		pill_Image_1.setBackground(Color.DARK_GRAY);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PillDatabase pill = new PillDatabase();
				
				String tempImprint = JOptionPane.showInputDialog("Enter Database entry# ");
				
				int integerImp = Integer.parseInt(tempImprint);
				int arrayPill = Integer.parseInt(tempImprint);
				List<Pill> pillImp = pill.getPillByImp(tempImprint);
				
				Pill pills = (Pill) pillImp.get(--arrayPill);
				receiveImprint(pills);
				//txtPillImprint.setText(pills.getPillImp().toString());
				
			}
		});
		
		
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(48)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(photoBttn)
								.addPreferredGap(ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
								.addComponent(modifyPillBttn)
								.addGap(146))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(pill_Image_1, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
								.addGap(39)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(txtDrugName)
									.addComponent(txtPillImprint, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
									.addComponent(colorComboBox, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(shapeComboBox, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(txtDrugStrength, Alignment.LEADING)
									.addComponent(timeDateLbl, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
								.addContainerGap(70, Short.MAX_VALUE)))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(53)
							.addComponent(txtPillImprint, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(shapeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(colorComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtDrugName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(64)
							.addComponent(pill_Image_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(18)
					.addComponent(txtDrugStrength, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(timeDateLbl)
					.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(modifyPillBttn)
						.addComponent(photoBttn))
					.addGap(18)
					.addComponent(btnNewButton)
					.addGap(41))
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
	 * receives the imprint and passes the values into
	 * text fields
	 * parameter imprint
	 */
	public void receiveImprint(Pill imprint) {
		searchImprint = imprint.getPillImp();
		
		txtPillImprint.setText(imprint.getPillImp().toString());
		txtDrugName.setText(imprint.getDrugNm());
		txtDrugStrength.setText(imprint.getDrugStrngth());
		
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
