package caem_prototype.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import caem_prototype.namingvalues.NamingValues.EventType;

@Entity
@Table(name = "Event")
public class Event implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -834852140666678477L;


	private Integer id;
	private String title;

	private EventType eventType;
	private Date startTime;
	private Date finishTime;
	private Boolean isRecurrent;
	private Date recurrentUntil;
	private Set<Tag> tags = new HashSet<Tag>(0);

	@Id
	@GeneratedValue
	@Column(name = "id")
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "title")
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "event_type")
	@Enumerated(EnumType.STRING)
	public EventType getEventType() {
		return this.eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	@Column(name = "start_time")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@Column(name = "finish_time")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getFinishTime() {
		return this.finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	@Column(name = "is_recurrent", columnDefinition = "SMALLINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	public Boolean getIsRecurrent() {
		return this.isRecurrent;
	}

	public void setIsRecurrent(Boolean isRecurrent) {
		this.isRecurrent = isRecurrent;
	}

	@Column(name = "recurrent_until")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getRecurrentUntil() {
		return this.recurrentUntil;
	}

	public void setRecurrentUntil(Date recurrentUntil) {
		this.recurrentUntil = recurrentUntil;
	}

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinTable(name = "Event_Tag", joinColumns = { @JoinColumn(name = "event_id") }, 
	inverseJoinColumns = { @JoinColumn(name = "tag_id") })
	public Set<Tag> getTags() {
		return this.tags;
	}

	public void setTags(Set<Tag> tags) {
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
		Event other = (Event) obj;
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
