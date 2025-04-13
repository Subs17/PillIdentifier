package pupr.edu.pill_Identifier;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.AbstractListModel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.Font;
/*
 * displays Help tips on how to use program effectively
 */
@SuppressWarnings("serial")
public class HelpContentsFrame extends JFrame{

	private JFrame frmAbout;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpContentsFrame window = new HelpContentsFrame();
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
	public HelpContentsFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frmAbout = new JFrame();
		frmAbout.setTitle("Help Contents");
		frmAbout.setBounds(100, 100, 717, 394);
		frmAbout.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.BOLD, 14));
		textArea.setEditable(false);
		JList list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(list.getSelectedIndex() == 0) {
					//Getting Started description
					textArea.setText("Welcome to the Pill Identifier program!\nThis program saves user inputs to create a database of \npills. "
							+ "To get started, you must first use the FILE menu \nand press the Add Pill option. Once you have added the "
							+ "\npill's information, it remains within the database. If \nyou wish to make a change, use the FILE menu and "
							+ "press\nthe Modify Pill option. To search for a pill, use the\nPill Identifier option. To obtain the full list, "
							+ "press\nthe Pill Report option." );
				}
				
				if(list.getSelectedIndex() == 1) {
					//Add Pill description
					textArea.setText("Welcome to the Add Pill Menu! \nTo add a new pill into the database, "
							+ "firstly add all of \nthe relevant information. That means: "
							+ "Pill Imprint, Pill \nShape, Pill Color, the drug's commercial name and the \ndrug's strength. "
							+ "Once those text fields have been filled \nout, press the Upload Photo button to search for an \nappropriate "
							+ "image. Supported files are .gif and .jpg. \nNOTE: You cannot save a pill into the database "
							+ "without \nuploading a picture.\nOnce every field is filled, you may then press the Save Pill button. "
							+ "If you wish to exit,\n just press the X button to close the menu.");
				}
				
				if(list.getSelectedIndex() == 2) {
					//Modify Pill description
					textArea.setText("Welcome to the Modify Pill Menu! \nTo modify an existing pill, firstly press the "
							+ "Search \nbutton. A new window will open up asking for the database \nentry you wish to edit.\n"
							+ "NOTE: It is recommended you use the Pill Report menu \nalong with the Modify Pill menu. This way "
							+ "you will be \nable to determine the database entry #. \nOnce you got the desired database entry, only the\n"
							+ "following fields will be editable: Pill Shape, \nPill Color, Drug Name and Drug Strength. You may also \nchange "
							+ "the image with another. Once you upload the picture, \npress the Modify Pill button and the Pill will be added \nto the "
							+ "database. To confirm the pill's entry, use the \nPill Report to search for the newly inputted pill.");
				}
				
				if(list.getSelectedIndex() == 3) {
					//Pill Identifier description
					textArea.setText("Welcome to the Pill Identifier Menu! \nThis menu is used to find the information of a specific\n"
							+ "pill within the database. To search, firstly press the \nSearch Button in the bottom left corner. "
							+ "Once you press \nit, a popup frame will ask you to input the database \nentry # into the search bar. "
							+ "NOTE: It is recommended you \nuse the Pill Report menu along with the Pill Identifier \nmenu. This way you will be "
							+ "\nable to determine the database entry #. \nOnce the desired database entry is placed, the menu will \ndisplay"
							+ "the relevant information about the requested pill.");
				}
				
				if(list.getSelectedIndex() == 4) {
					//Pill Report description
					textArea.setText("Welcome to the Pill Report Menu! \nThis menu is used in conjuction with Modify Pill and Pill \nIdentifier "
							+ "to search for database entry #. It will \ndisplay all the information of each single pill within \nthe database. "
							+ "To generate a report, press the Display \nbutton and the Pill Report will display all available \ninfo. "
							+ "\nNOTE: The Pill Report does not update in real time. If \nyou wish to see the newly added pill or modified pill, "
							+ "\npress the Reset button first and then the Display button \nonce again to show all the information once again.");
				}
			}
		});
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Getting Started", "Add a Pill", "Modify a Pill", "Pill Identifier", "Pill Report"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(frmAbout.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 457, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(88, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
						.addComponent(list))
					.addContainerGap(152, Short.MAX_VALUE))
		);
		frmAbout.getContentPane().setLayout(groupLayout);
	}
}
