package com.capgemini.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.entity.Incidentstatus;

@Transactional
public interface IncidentStatusDao extends CrudRepository<Incidentstatus, Long> {

	public Iterable<Incidentstatus> findAll();

}