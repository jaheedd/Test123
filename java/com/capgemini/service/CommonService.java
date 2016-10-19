package com.capgemini.service;

import com.capgemini.entity.Applicationcategory;
import com.capgemini.entity.Incidentstatus;
import com.capgemini.entity.Solutionstatus;

public interface CommonService {

	public Iterable<Incidentstatus> findAllIncidentStatus();
	public Iterable<Solutionstatus> findAllSolutionStatus();
	public Iterable<Applicationcategory> findAllCategory();

}
