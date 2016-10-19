package com.capgemini.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the incidents database table.
 * 
 */
@Entity
@Table(name="incidents")
@NamedQuery(name="Incident.findAll", query="SELECT i FROM Incident i")
public class Incident implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String ticketNumberId;

	private String callType;

	private int categoryID;

	private String createdBy;

	private Timestamp fixDate;

	private Timestamp openDate;

	private String priority;

	private String problemDetails;

	private String problemSummary;

	private String queue;

	private int statusId;

	//bi-directional many-to-one association to Linkedincident
	@OneToMany(mappedBy="incident")
	private List<Linkedincident> linkedincidents;

	public Incident() {
	}

	public String getTicketNumberId() {
		return this.ticketNumberId;
	}

	public void setTicketNumberId(String ticketNumberId) {
		this.ticketNumberId = ticketNumberId;
	}

	public String getCallType() {
		return this.callType;
	}

	public void setCallType(String callType) {
		this.callType = callType;
	}

	public int getCategoryID() {
		return this.categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getFixDate() {
		return this.fixDate;
	}

	public void setFixDate(Timestamp fixDate) {
		this.fixDate = fixDate;
	}

	public Timestamp getOpenDate() {
		return this.openDate;
	}

	public void setOpenDate(Timestamp openDate) {
		this.openDate = openDate;
	}

	public String getPriority() {
		return this.priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getProblemDetails() {
		return this.problemDetails;
	}

	public void setProblemDetails(String problemDetails) {
		this.problemDetails = problemDetails;
	}

	public String getProblemSummary() {
		return this.problemSummary;
	}

	public void setProblemSummary(String problemSummary) {
		this.problemSummary = problemSummary;
	}

	public String getQueue() {
		return this.queue;
	}

	public void setQueue(String queue) {
		this.queue = queue;
	}

	public int getStatusId() {
		return this.statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public List<Linkedincident> getLinkedincidents() {
		return this.linkedincidents;
	}

	public void setLinkedincidents(List<Linkedincident> linkedincidents) {
		this.linkedincidents = linkedincidents;
	}

	public Linkedincident addLinkedincident(Linkedincident linkedincident) {
		getLinkedincidents().add(linkedincident);
		linkedincident.setIncident(this);

		return linkedincident;
	}

	public Linkedincident removeLinkedincident(Linkedincident linkedincident) {
		getLinkedincidents().remove(linkedincident);
		linkedincident.setIncident(null);

		return linkedincident;
	}

}