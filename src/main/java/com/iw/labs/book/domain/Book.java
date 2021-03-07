package com.iw.labs.book.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import com.iw.labs.infrastructure.domain.BaseEntity;

@Entity
@Table(name = "book")
public class Book extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(name = "title")
	private String title;

	@NotNull
	@Column(name = "description", length = 5000)
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_on")
	private Date modifiedOn;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
