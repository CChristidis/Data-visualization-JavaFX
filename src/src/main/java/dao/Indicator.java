package main.java.dao;

public class Indicator extends Entity{
	private int id;
	private String name;
	private String code;
	
	
	public Indicator(String name) {
		this.name = name;
	}
	
	
	/* for upgrade-delete cases.
	 * 
	 */
	public Indicator(int id, String name, String code) {
		this.id = id;
		this.name = name;
		this.code = code;
	}
	
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCode() {
		return code;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
