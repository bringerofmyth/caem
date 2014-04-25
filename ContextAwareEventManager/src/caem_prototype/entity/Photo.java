package caem_prototype.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "Photo")
public class Photo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4221105999439014372L;
	private Integer id;
	private String url;
	private String diskUrl;
	private Boolean isOwner;
	private Place place;
	@Id
	@GeneratedValue
	@Column(name = "id")
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "url")
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "disk_url")
	public String getDiskUrl() {
		return this.diskUrl;
	}

	public void setDiskUrl(String diskUrl) {
		this.diskUrl = diskUrl;
	}

	@Column(name = "is_owner", columnDefinition = "SMALLINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	public Boolean getIsOwner() {
		return this.isOwner;
	}

	public void setIsOwner(Boolean isOwner) {
		this.isOwner = isOwner;
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
		Photo other = (Photo) obj;
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "place_id", nullable = false)
	public Place getPlace() {
		return this.place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

}
