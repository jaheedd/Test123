package com.capgemini.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the applicationcategory database table.
 * 
 */
@Entity
public class Applicationcategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="category_id")
	private int categoryId;

	@Column(name="category_desc")
	private String categoryDesc;

	@Column(name="category_name")
	private String categoryName;

	public Applicationcategory() {
	}

	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryDesc() {
		return this.categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}