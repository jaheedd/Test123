package com.capgemini.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.entity.Solution;

@Transactional
public interface SolutionDao extends CrudRepository<Solution, Long> {

	

}