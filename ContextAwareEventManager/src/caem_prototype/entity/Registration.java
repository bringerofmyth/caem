package caem_prototype.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "Registration")
public class Registration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5108109609317586171L;
	private Integer id;
	private Event event;
	private User user;
	private Date timeOfRegistration;
	private String status;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JoinColumn(name = "event")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@JoinColumn(name = "user")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "time_of_registration")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getTimeOfRegistration() {
		return this.timeOfRegistration;
	}

	public void setTimeOfRegistration(Date timeOfRegistration) {
		this.timeOfRegistration = timeOfRegistration;
	}

	@Column(name = "status")
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		Registration other = (Registration) obj;
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
