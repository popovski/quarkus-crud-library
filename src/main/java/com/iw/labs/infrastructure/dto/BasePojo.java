package com.iw.labs.infrastructure.dto;

import java.util.Date;

public class BasePojo {
	private String uuid;
	private Date createdOn;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
}
