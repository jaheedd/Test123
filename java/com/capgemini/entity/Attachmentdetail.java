package com.capgemini.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the attachmentdetails database table.
 * 
 */
@Entity
@Table(name="attachmentdetails")
@NamedQuery(name="Attachmentdetail.findAll", query="SELECT a FROM Attachmentdetail a")
public class Attachmentdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int attachmentDetailID;

	@Lob
	private byte[] attachemntContent;

	//bi-directional many-to-one association to Serviceattachment
	@ManyToOne
	@JoinColumn(name="AttachmentID")
	private Serviceattachment serviceattachment;

	public Attachmentdetail() {
	}

	public int getAttachmentDetailID() {
		return this.attachmentDetailID;
	}

	public void setAttachmentDetailID(int attachmentDetailID) {
		this.attachmentDetailID = attachmentDetailID;
	}

	public byte[] getAttachemntContent() {
		return this.attachemntContent;
	}

	public void setAttachemntContent(byte[] attachemntContent) {
		this.attachemntContent = attachemntContent;
	}

	public Serviceattachment getServiceattachment() {
		return this.serviceattachment;
	}

	public void setServiceattachment(Serviceattachment serviceattachment) {
		this.serviceattachment = serviceattachment;
	}

}