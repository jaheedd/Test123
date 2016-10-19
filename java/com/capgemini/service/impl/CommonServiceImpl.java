package com.capgemini.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.constants.Status;
import com.capgemini.dao.CategoryDao;
import com.capgemini.dao.IncidentStatusDao;
import com.capgemini.dao.SolutionStatusDao;
import com.capgemini.entity.Applicationcategory;
import com.capgemini.entity.Incidentstatus;
import com.capgemini.entity.Solutionstatus;
import com.capgemini.entity.User;
import com.capgemini.service.CommonService;

@Service
public class CommonServiceImpl implements
		CommonService {

	private Logger logger = Logger
			.getLogger(CommonServiceImpl.class);

	@Autowired
	private SolutionStatusDao solutionStatusDao;
	
	@Autowired
	private IncidentStatusDao incidentStatusDao;
	
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public Iterable<Incidentstatus> findAllIncidentStatus() {
		try {
			Iterable<Incidentstatus>  incidentStatus = incidentStatusDao.findAll();
			if (incidentStatus != null ) {
				return incidentStatus;
			}
		} catch (Exception e) {
			logger.error("Exception while retrieving incident status:", e);

		}
		return null;
	}
	
	@Override
	public Iterable<Solutionstatus> findAllSolutionStatus() {
		try {
			Iterable<Solutionstatus>  solutionStatus = solutionStatusDao.findAll();
			if (solutionStatus != null ) {
				return solutionStatus;
			}
		} catch (Exception e) {
			logger.error("Exception while retrieving incident status:", e);

		}
		return null;
	}
	
	@Override
	public Iterable<Applicationcategory> findAllCategory() {
		try {
			Iterable<Applicationcategory>  applicationcategory = categoryDao.findAll();
			if (applicationcategory != null ) {
				return applicationcategory;
			}
		} catch (Exception e) {
			logger.error("Exception while retrieving Application Category:", e);

		}
		return null;
	}
}
