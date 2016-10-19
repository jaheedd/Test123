package com.capgemini.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.entity.Solutionstatus;

@Transactional
public interface SolutionStatusDao extends CrudRepository<Solutionstatus, Long> {

	public Iterable<Solutionstatus> findAll();

}