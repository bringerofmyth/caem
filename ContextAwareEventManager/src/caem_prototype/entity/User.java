package caem_prototype.entity;

import java.io.Serializable;

import caem_prototype.namingvalues.NamingValues;

public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6515616387216885728L;
	private Integer id;
	private String name;
	private String surname;
	private String userName;
	private String password;
	private NamingValues role;
	
	
	public Integer getID() {
		return id;
	}
	public void setID(Integer iD) {
		id = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public NamingValues getRole() {
		return role;
	}
	public void setRole(NamingValues role) {
		this.role = role;
	}
	
	
	
	
	
}
