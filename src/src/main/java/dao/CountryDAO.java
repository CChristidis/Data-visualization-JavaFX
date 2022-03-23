package main.java.dao;


// TODO: return selected country's id, by Name field.
public interface CountryDAO {
	public int readCountryIdFromName(String name);
	public void delete(String name);
	public void update(String name);
	public void create(int id, String name, String code);
}
