package com.ab.myonlinedairy.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
//@Table(name = "dairy")
@Table(name = "dairy")//, uniqueConstraints = {@UniqueConstraint(columnNames = { "added_by", "entry_on" })})
public class Dairy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "added_by")
	private int addedBy;

	@Column(name = "entry_on")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date entryOn;

	@Column(name = "subject")
	private String subject;

	@Column(name = "description")
	private String description;

	@Column(name = "last_updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdatedAt;

	@Column(name = "is_current")
	private Boolean isCurrent;

	public Dairy() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(int addedBy) {
		this.addedBy = addedBy;
	}

	public Date getEntryOn() {
		return entryOn;
	}

	public void setEntryOn(Date entryOn) {
		this.entryOn = entryOn;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getLastUpdatedAt() {
		return lastUpdatedAt;
	}

	public void setLastUpdatedAt(Date lastUpdatedAt) {
		this.lastUpdatedAt = lastUpdatedAt;
	}

	public Boolean getIsCurrent() {
		return isCurrent;
	}

	public void setIsCurrent(Boolean isCurrent) {
		this.isCurrent = isCurrent;
	}

	@Override
	public String toString() {
		return "Dairy [id=" + id + ", addedBy=" + addedBy + ", entryOn=" + entryOn + ", subject=" + subject
				+ ", description=" + description + ", lastUpdatedAt=" + lastUpdatedAt + ", isCurrent=" + isCurrent
				+ "]";
	}

}
