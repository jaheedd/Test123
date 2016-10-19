package com.capgemini.service.impl;

import java.sql.Timestamp;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.SolutionDao;
import com.capgemini.entity.Applicationcategory;
import com.capgemini.entity.Solution;
import com.capgemini.service.SolutionService;


	@Service
	public class SolutionServiceImpl implements SolutionService {

		private Logger logger = Logger
				.getLogger(SolutionServiceImpl.class);

		@Autowired
		private SolutionDao solutionDao;

	
		@Override
		public boolean saveSolution(String solutionID, String descriptionID, String keywordID, 
				String technologyID, String linkedIncidentID, String categoryID) {
			try {
				Solution s=new Solution();
				s.setCategoryID(Integer.parseInt(categoryID));
				s.setCreatedDate(new Timestamp(System.currentTimeMillis()));
				s.setSearchKeyword(keywordID);
				s.setSolutionDescription(descriptionID);
				s.setTechnology(technologyID);
				s.setCreatedBy("srikanth");
				s.setSolutionID(solutionID);
				/*Applicationcategory apc=new Applicationcategory();
				apc.setCategoryId(1);
				s.setCategoryID(apc);	*/		
				Solution s1= solutionDao.save(s);
				
			} catch (Exception e) {
				logger.error("Exception while creating Soultion:", e);

			}
			return true;
		}
	}



