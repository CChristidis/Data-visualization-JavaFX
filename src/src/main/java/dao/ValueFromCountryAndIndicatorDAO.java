package main.java.dao;

public interface ValueFromCountryAndIndicatorDAO {
	public double readValueFromCountryAndIndicator(int id_country, int id_ind, int year);
	public void delete(int id_country, int id_ind, int year);
	public void update(int id_country, int id_ind, int year);
	public void create(int id_country, int id_ind, int year, int value);
}
