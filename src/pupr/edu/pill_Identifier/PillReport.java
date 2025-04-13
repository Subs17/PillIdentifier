package pupr.edu.pill_Identifier;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Font;

/*
 * This class is the pill report frame that displays 
 * all the pills within the database
 */
public class PillReport extends JFrame {
	
	private static final String URL = "jdbc:mysql://localhost:3306/pill"; //
    private static final String USERNAME = "Subs";	
    private static final String PASSWORD = "103017";	

	private JPanel contentPane;
	private JTable table;
	private JTable tblData;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PillReport frame = new PillReport();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PillReport() {
		setTitle("Pill Report");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1254, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 258, 424, -255);
		contentPane.add(table);
		
		/*
		 * Displays all the information in a JTable
		 */
		JButton Displaybtn = new JButton("Display");
		Displaybtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		Displaybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
					Statement statement = connection.createStatement();
					String Query="Select * from pill.info";
					ResultSet rs = statement.executeQuery(Query);
					ResultSetMetaData rsmd = rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) tblData.getModel();
					
					int cols=rsmd.getColumnCount();
					String[] colName = new String[cols];
					for(int i=0;i<cols;i++) {
						colName[i]=rsmd.getColumnName(i+1);
					}
					model.setColumnIdentifiers(colName);
					
					String Pillimp, Pillclr,Pillshp,PillImgName,DrugName,DrugStrength,TimeOfRecord;
					while(rs.next()) {
						Pillimp = rs.getString(1);
						Pillclr = rs.getString(2);
						Pillshp = rs.getString(3);
						PillImgName = rs.getString(4);
						DrugName = rs.getString(5);
						DrugStrength = rs.getString(6);
						TimeOfRecord = rs.getString(7);
						
						String[] row = {Pillimp, Pillclr,Pillshp,PillImgName,DrugName,DrugStrength,TimeOfRecord};
						model.addRow(row);
					}
					statement.close();
					connection.close();
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		Displaybtn.setBounds(10, 160, 107, 51);
		contentPane.add(Displaybtn);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(147, 14, 1081, 378);
		contentPane.add(scrollPane);
		
		tblData = new JTable();
		scrollPane.setViewportView(tblData);
		
		/*
		 * resets the JTable to prevent clutter
		 */
		JButton resetBttn = new JButton("Reset");
		resetBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) tblData.getModel();
				model.getDataVector().removeAllElements();
				model.fireTableDataChanged();
			}
		});
		resetBttn.setFont(new Font("Tahoma", Font.BOLD, 14));
		resetBttn.setBounds(10, 238, 107, 51);
		contentPane.add(resetBttn);
	}
}
