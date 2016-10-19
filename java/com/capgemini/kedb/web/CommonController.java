package com.capgemini.kedb.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.constants.GlobalResponse;
import com.capgemini.constants.RequestStatus;
import com.capgemini.entity.Applicationcategory;
import com.capgemini.entity.Incidentstatus;
import com.capgemini.entity.Solutionstatus;
import com.capgemini.service.CommonService;
import com.google.common.collect.Lists;

@RestController
public class CommonController {

	private Logger logger = Logger.getLogger(CommonController.class);

	@Autowired
	private CommonService commonService;

	@RequestMapping("/findSolutionStatus")
	public GlobalResponse findAllIncidentStatus() {

		GlobalResponse response = new GlobalResponse();
		try {
			Iterable<Solutionstatus> solutionStatus = commonService.findAllSolutionStatus();
			response.setResponse(Lists.newArrayList(solutionStatus));

		} catch (Exception e) {
			response.setStatus(RequestStatus.STATUS_FAILURE);
			response.setStatusDesc("Error while fetching Solution Status");
			logger.error(e);
		}
		return response;
	}
	
	@RequestMapping("/findIncidentStatus")
	public GlobalResponse findAllSolutionStatus() {

		GlobalResponse response = new GlobalResponse();
		try {
			Iterable<Incidentstatus> incidentStatus = commonService.findAllIncidentStatus();
			response.setResponse(Lists.newArrayList(incidentStatus));

		} catch (Exception e) {
			response.setStatus(RequestStatus.STATUS_FAILURE);
			response.setStatusDesc("Error while fetching Incident Status");
			logger.error(e);
		}
		return response;
	}
	
	@RequestMapping("/findCategory")
	public GlobalResponse findCategory() {

		GlobalResponse response = new GlobalResponse();
		try {
			Iterable<Applicationcategory> applicationcategory = commonService.findAllCategory();
			response.setResponse(Lists.newArrayList(applicationcategory));

		} catch (Exception e) {
			response.setStatus(RequestStatus.STATUS_FAILURE);
			response.setStatusDesc("Error while fetching Solution Status");
			logger.error(e);
		}
		return response;
	}

	
}
