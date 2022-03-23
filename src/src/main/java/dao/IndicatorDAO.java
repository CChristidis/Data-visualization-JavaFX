package main.java.dao;

public interface IndicatorDAO {
	public int readIndicatorIdFromName(String name);
	public void delete(String name);
	public void update(String name);
	public void create(int id, String name, String code);

}
