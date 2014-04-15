package caem_prototype.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import caem_prototype.namingvalues.NamingValues.Role.EventType;

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

	private List<Tag> tags;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public EventType getEventType() {
		return this.eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getFinishTime() {
		return this.finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public Boolean isRecurrent() {
		return this.isRecurrent;
	}

	public void setRecurrent(Boolean isRecurrent) {
		this.isRecurrent = isRecurrent;
	}

	public Date getRecurrentUntil() {
		return this.recurrentUntil;
	}

	public void setRecurrentUntil(Date recurrentUntil) {
		this.recurrentUntil = recurrentUntil;
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
