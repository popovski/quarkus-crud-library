package com.iw.labs.book.dto;

import java.util.Date;
import com.iw.labs.infrastructure.dto.BasePojo;

public class BookPojo extends BasePojo {
	private String title;
	private String description;
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
}
