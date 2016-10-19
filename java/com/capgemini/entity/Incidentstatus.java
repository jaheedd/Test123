package com.capgemini.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the incidentstatus database table.
 * 
 */
@Entity
public class Incidentstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="status_id")
	private int statusId;

	private String status_desc;

	@Column(name="status_name")
	private String statusName;

	public Incidentstatus() {
	}

	public int getStatusId() {
		return this.statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatus_desc() {
		return this.status_desc;
	}

	public void setStatus_desc(String status_desc) {
		this.status_desc = status_desc;
	}

	public String getStatusName() {
		return this.statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

}