package pupr.edu.pill_Identifier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*
 * This class communicates with an SQL server to save pill information into a table
 * and also calls upon the saved information to display it
 */

public class PillDatabase {
	private static final String URL = "jdbc:mysql://localhost:3306/pill"; //URL to connect to the SQL server containing the table
    private static final String USERNAME = "USERNAME";	
    private static final String PASSWORD = "PASSWORD";	

    private Connection connection = null;
    private PreparedStatement selectAllPills = null;
    private PreparedStatement selectPillImp = null;
    private PreparedStatement insertNewPill = null;
    private PreparedStatement updatePill = null;
    
    
    /*
     * DEFAULT CONSTRUCTOR
     */
    public PillDatabase() {
    	try {
    		connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    		
    		selectAllPills = connection.prepareStatement("Select * From pill.info");
    		
    		selectPillImp = connection.prepareStatement("Select * From pill.info Where pillImprint = ?");
    		
    		insertNewPill = connection.prepareStatement("Insert Into pill.info "
    				+ "(pillImprint, pillShape, pillColor,"
    				+ "drugName, drugStrngth, pillImgName, entryDate)"
    				+ "Values (?, ?, ?, ?, ?, ?, ?)");
    		
    		updatePill = connection.prepareStatement("Update pill.info SET pillImprint = ?,"
    				+ " pillShape = ?, pillColor = ?, "
    				+ "drugName = ?, drugStrngth = ?, pillImgName = ?, "
    				+ "entryDate = ? WHERE pillImprint = ?");
    		
    	}catch(SQLException e) {
    		System.err.println(e);
    		e.printStackTrace();
    		System.err.println("Connect error to DB!");
    		System.exit(1);
    	}
    }// end of constructor
    
    
    /*
     * Obtains all the information within the database 
     * returns results
     */
    public List<Pill> getAllPills(){
    	List<Pill> results = null;
    	ResultSet resultSet = null;
    	
    	try {
    		resultSet = selectAllPills.executeQuery();
    		results = new ArrayList<>();
    		
    		while(resultSet.next()) {
    			results.add(new Pill(resultSet.getString("pillImprint"),
        				resultSet.getString("pillShape"),
        				resultSet.getString("pillColor"),
        				resultSet.getString("drugName"),
        				resultSet.getString("drugStrngth"),
        				resultSet.getString("pillImgName"),
        				resultSet.getString("entryDate")));
    		}//end while
    		
    	}catch(SQLException ex) {
    		System.err.println("Error in DB: " + ex.getMessage());
			close();
    	}//end catch
    	finally {
    		try {
    			resultSet.close();
    		}catch(SQLException ex) {
    			ex.printStackTrace();
    			close();
    		}//end catch
    	}//end finally
    	
    	return results;	
    }
    
    /*
     * Retrieves pill imprint
     * parameter pillImprint
     * return results
     */
    
    public List<Pill> getPillByImp(String pillImprint){
    	List<Pill> results = null;
    	ResultSet resultSet = null;
    	
    	try {
    		selectPillImp.setString(1, pillImprint);
    		
    		resultSet = selectAllPills.executeQuery();
    		results = new ArrayList<>();
    		
    		while(resultSet.next()) {
    			results.add(new Pill(resultSet.getString("pillImprint"),
        				resultSet.getString("pillShape"),
        				resultSet.getString("pillColor"),
        				resultSet.getString("drugName"),
        				resultSet.getString("drugStrngth"),
        				resultSet.getString("pillImgName"),
        				resultSet.getString("entryDate")));
    		}//end while
    	}catch(SQLException ex) {
    		System.err.println("Error in DB: " + ex.getMessage());
    		close();
    	}
    	finally {
    		try {
				resultSet.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}//end catch
		}//end finally 
    	
		return results;
    	
    }
    
    /*
     * Adds an entry 
     * parameters: 
     * pillImprint
     * pillShape
     * pillColor
     * drugName
     * drugStrngth
     * pillImgName
     * entryDate
     * returns result 
     */
    
    public int addPill(String pillImprint, String pillShape, String pillColor,
    		String drugName, String drugStrngth, String pillImgName, String entryDate) {
    	int result = 0;
    	
    	try {
    		insertNewPill.setString(1, pillImprint);
    		insertNewPill.setString(2, pillShape);
    		insertNewPill.setString(3, pillColor);
    		insertNewPill.setString(4, drugName);
    		insertNewPill.setString(5, drugStrngth);
    		insertNewPill.setString(6, pillImgName);
    		insertNewPill.setString(7, entryDate);
    		
    		result = insertNewPill.executeUpdate();
    	}catch(SQLException ex) {
    		System.err.println("Error in DB: " + ex.getMessage());
			close();
    	}//end catch
    	
    	return result;
    }//end of addPill method
    
    /*
     * Updates an entry 
     * parameters: 
     * pillImprint
     * pillShape
     * pillColor
     * drugName
     * drugStrngth
     * pillImgName
     * entryDate
     * returns result 
     */
    public int modifyPill(String imprint, String pillShape, String pillColor,
    		String drugName, String drugStrngth, String pillImgName, String entryDate) {
    	int result = 0;
    	
    	try {
    	
    		updatePill.setString(1, imprint);
    		updatePill.setString(2, pillShape);
    		updatePill.setString(3, pillColor);
    		updatePill.setString(4, drugName);
    		updatePill.setString(5, drugStrngth);
    		updatePill.setString(6, pillImgName);
    		updatePill.setString(7, entryDate);
    		updatePill.setString(8, imprint);
    		
    		result = updatePill.executeUpdate();
    	}catch(SQLException ex) {
    		System.err.println("Error in DB: " + ex.getMessage());
			close();
    	}//end catch
    	
    	return result;
    }//end of modifyPill method
    
    /*
     * Closes SQL database connection
     */
    public void close() 
    {
        try 
        {
            connection.close();
        } // end try
        catch (SQLException sqlException) 
        {
            sqlException.printStackTrace();
        } // end catch
     } // end method close 
}
