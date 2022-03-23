package main.java.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IndicatorDAOMySQLImpl implements IndicatorDAO {
	private Connector connection;
	private ResultSet queryResult;
	
	public IndicatorDAOMySQLImpl() {
		this.connection = new Connector();	// TODO: maybe can me prototyped.
	}
	
	@Override
	public int readIndicatorIdFromName(String name) {
		String query = "SELECT id FROM indicator WHERE name  = '" + name + "';";
		int id = 0;
	
		try {
			connection.connectWithDB();
			queryResult = connection.executeQuery(query);
			if (queryResult.next()) {
				id = queryResult.getInt("id");
			} 
			
			}catch (SQLException ex) {
				connection.perrSQL(ex);
		 	}
		return id;
	}
	
	
	

	@Override
	public void delete(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(int id, String name, String code) {
		// TODO Auto-generated method stub
		
	}

	

}
