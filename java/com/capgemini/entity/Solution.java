package com.capgemini.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the solutions database table.
 * 
 */
@Entity
@Table(name="solutions")
@NamedQuery(name="Solution.findAll", query="SELECT s FROM Solution s")
public class Solution implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String solutionID;

	private int categoryID;

	private String createdBy;

	private Timestamp createdDate;

	private Timestamp lastUpdateDate;

	private String searchKeyword;

	private String solutionDescription;

	private int statusId;

	private String technology;

	//bi-directional many-to-one association to Linkedincident
	@OneToMany(mappedBy="solution")
	private List<Linkedincident> linkedincidents;

	//bi-directional many-to-one association to Serviceattachment
	@OneToMany(mappedBy="solution")
	private List<Serviceattachment> serviceattachments;

	public Solution() {
	}

	public String getSolutionID() {
		return this.solutionID;
	}

	public void setSolutionID(String solutionID) {
		this.solutionID = solutionID;
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

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getSearchKeyword() {
		return this.searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public String getSolutionDescription() {
		return this.solutionDescription;
	}

	public void setSolutionDescription(String solutionDescription) {
		this.solutionDescription = solutionDescription;
	}

	public int getStatusId() {
		return this.statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getTechnology() {
		return this.technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public List<Linkedincident> getLinkedincidents() {
		return this.linkedincidents;
	}

	public void setLinkedincidents(List<Linkedincident> linkedincidents) {
		this.linkedincidents = linkedincidents;
	}

	public Linkedincident addLinkedincident(Linkedincident linkedincident) {
		getLinkedincidents().add(linkedincident);
		linkedincident.setSolution(this);

		return linkedincident;
	}

	public Linkedincident removeLinkedincident(Linkedincident linkedincident) {
		getLinkedincidents().remove(linkedincident);
		linkedincident.setSolution(null);

		return linkedincident;
	}

	public List<Serviceattachment> getServiceattachments() {
		return this.serviceattachments;
	}

	public void setServiceattachments(List<Serviceattachment> serviceattachments) {
		this.serviceattachments = serviceattachments;
	}

	public Serviceattachment addServiceattachment(Serviceattachment serviceattachment) {
		getServiceattachments().add(serviceattachment);
		serviceattachment.setSolution(this);

		return serviceattachment;
	}

	public Serviceattachment removeServiceattachment(Serviceattachment serviceattachment) {
		getServiceattachments().remove(serviceattachment);
		serviceattachment.setSolution(null);

		return serviceattachment;
	}

}