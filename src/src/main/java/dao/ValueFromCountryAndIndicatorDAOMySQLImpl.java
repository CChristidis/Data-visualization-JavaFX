package main.java.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ValueFromCountryAndIndicatorDAOMySQLImpl implements ValueFromCountryAndIndicatorDAO {
	private Connector connection;
	private ResultSet queryResult;
	
	public ValueFromCountryAndIndicatorDAOMySQLImpl() {
		connection = new Connector();
	}
	
	@Override
	public double readValueFromCountryAndIndicator(int id_country, int id_ind, int year) {
		String query = "SELECT value FROM indicates WHERE id_country = " + id_country 
				+ " AND id_ind = " + id_ind + " AND year = " + year + ";";
		System.out.println(query);
		double value = 0;
	
		try {
			connection.connectWithDB();
			queryResult = connection.executeQuery(query);
			if (queryResult.next()) {
				value = queryResult.getDouble("value");
			} 
			
			}catch (SQLException ex) {
				connection.perrSQL(ex);
		 	}
		return value;
	}

	@Override
	public void delete(int id_country, int id_ind, int year) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(int id_country, int id_ind, int year) {
		// TODO Auto-generated method stub

	}

	@Override
	public void create(int id_country, int id_ind, int year, int value) {
		// TODO Auto-generated method stub

	}

}
