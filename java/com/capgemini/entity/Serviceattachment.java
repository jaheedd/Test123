package com.capgemini.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the serviceattachment database table.
 * 
 */
@Entity
@NamedQuery(name="Serviceattachment.findAll", query="SELECT s FROM Serviceattachment s")
public class Serviceattachment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int attachmentID;

	private String attachemntName;

	private String attachmentSize;

	private String attachmenttype;

	private Timestamp createdDate;

	//bi-directional many-to-one association to Attachmentdetail
	@OneToMany(mappedBy="serviceattachment")
	private List<Attachmentdetail> attachmentdetails;

	//bi-directional many-to-one association to Solution
	@ManyToOne
	@JoinColumn(name="SolutionID")
	private Solution solution;

	public Serviceattachment() {
	}

	public int getAttachmentID() {
		return this.attachmentID;
	}

	public void setAttachmentID(int attachmentID) {
		this.attachmentID = attachmentID;
	}

	public String getAttachemntName() {
		return this.attachemntName;
	}

	public void setAttachemntName(String attachemntName) {
		this.attachemntName = attachemntName;
	}

	public String getAttachmentSize() {
		return this.attachmentSize;
	}

	public void setAttachmentSize(String attachmentSize) {
		this.attachmentSize = attachmentSize;
	}

	public String getAttachmenttype() {
		return this.attachmenttype;
	}

	public void setAttachmenttype(String attachmenttype) {
		this.attachmenttype = attachmenttype;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public List<Attachmentdetail> getAttachmentdetails() {
		return this.attachmentdetails;
	}

	public void setAttachmentdetails(List<Attachmentdetail> attachmentdetails) {
		this.attachmentdetails = attachmentdetails;
	}

	public Attachmentdetail addAttachmentdetail(Attachmentdetail attachmentdetail) {
		getAttachmentdetails().add(attachmentdetail);
		attachmentdetail.setServiceattachment(this);

		return attachmentdetail;
	}

	public Attachmentdetail removeAttachmentdetail(Attachmentdetail attachmentdetail) {
		getAttachmentdetails().remove(attachmentdetail);
		attachmentdetail.setServiceattachment(null);

		return attachmentdetail;
	}

	public Solution getSolution() {
		return this.solution;
	}

	public void setSolution(Solution solution) {
		this.solution = solution;
	}

}