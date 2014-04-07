package caem_prototype.entity;

import java.io.Serializable;
import java.util.List;

public class Place implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6304581360212594470L;
	private Integer id;
	private String name;
	private String address;
	private String phone;
	private String position;
	private String description;
	private String openHours;
	private String imageURL1;
	private String imageURL2;
	private String imageURL3;
	private List<String> userPhotos;
	private List<Tag> tags;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOpenHours() {
		return this.openHours;
	}

	public void setOpenHours(String openHours) {
		this.openHours = openHours;
	}

	public String getImageURL1() {
		return this.imageURL1;
	}

	public void setImageURL1(String imageURL1) {
		this.imageURL1 = imageURL1;
	}

	public String getImageURL2() {
		return this.imageURL2;
	}

	public void setImageURL2(String imageURL2) {
		this.imageURL2 = imageURL2;
	}

	public String getImageURL3() {
		return this.imageURL3;
	}

	public void setImageURL3(String imageURL3) {
		this.imageURL3 = imageURL3;
	}

	public List<String> getUserPhotos() {
		return this.userPhotos;
	}

	public void setUserPhotos(List<String> userPhotos) {
		this.userPhotos = userPhotos;
	}

	public List<Tag> getTags() {
		return this.tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
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
		Place other = (Place) obj;
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
