package com.capgemini.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the linkedincidents database table.
 * 
 */
@Entity
@Table(name="linkedincidents")
@NamedQuery(name="Linkedincident.findAll", query="SELECT l FROM Linkedincident l")
public class Linkedincident implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int linkedID;

	private Timestamp createdDate;

	//bi-directional many-to-one association to Solution
	@ManyToOne
	@JoinColumn(name="SolutionID")
	private Solution solution;

	//bi-directional many-to-one association to Incident
	@ManyToOne
	@JoinColumn(name="TicketNumberId")
	private Incident incident;

	public Linkedincident() {
	}

	public int getLinkedID() {
		return this.linkedID;
	}

	public void setLinkedID(int linkedID) {
		this.linkedID = linkedID;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Solution getSolution() {
		return this.solution;
	}

	public void setSolution(Solution solution) {
		this.solution = solution;
	}

	public Incident getIncident() {
		return this.incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

}