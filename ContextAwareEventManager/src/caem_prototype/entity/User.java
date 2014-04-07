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
		return this.id;
	}
	public void setID(Integer iD) {
		this.id = iD;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return this.surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public NamingValues getRole() {
		return this.role;
	}
	public void setRole(NamingValues role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		User other = (User) obj;
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		return true;
	}





}
