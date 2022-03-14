import java.sql.*;

public class ExtractQuery {
	static Connection connect_me = null;
	

	public static void filterQuery() {}
	
	public static void executeQuery(String query) {
		ResultSet rs = null;
		Statement stmt = null;

        try {
        	stmt = connect_me.createStatement();
        	rs = stmt.executeQuery(query);
        	
        	while (rs.next()) {
        		System.out.println(rs.getInt("id_country"));

        	}
        }
        catch (SQLException ex){
        	// handle any errors
        	System.out.println("SQLException: " + ex.getMessage());
        	System.out.println("SQLState: " + ex.getSQLState());
        	System.out.println("VendorError: " + ex.getErrorCode());
       }
        finally {
        	if (rs != null) {
        		try {
        			rs.close();
        		} catch (SQLException sqlEx) { } // ignore

        	}
        }
        
        // return rs;
	}
        
	
	
	
	public static void main(String[] args) { 
	
		try {
			String userName = "root";
            String password = "christos";
            String url = "jdbc:MySQL://localhost/mye030";        
            connect_me = DriverManager.getConnection (url, userName, password);
            executeQuery("SELECT id_country FROM indicates WHERE year = 2020;");
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	
}
