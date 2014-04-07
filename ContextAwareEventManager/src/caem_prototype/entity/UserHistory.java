package caem_prototype.entity;

import java.io.Serializable;
import java.util.List;

public class UserHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8580212237159527957L;
	private Integer id;
	private List<Registration> registrations;
	private List<UserLocation> userLocation;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Registration> getRegistrations() {
		return this.registrations;
	}

	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}

	public List<UserLocation> getUserLocation() {
		return this.userLocation;
	}

	public void setUserLocation(List<UserLocation> userLocation) {
		this.userLocation = userLocation;
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
		UserHistory other = (UserHistory) obj;
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
