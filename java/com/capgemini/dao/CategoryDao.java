package com.capgemini.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.entity.Applicationcategory;
import com.capgemini.entity.Incidentstatus;

@Transactional
public interface CategoryDao extends CrudRepository<Applicationcategory, Long> {

	public Iterable<Applicationcategory> findAll();

}