package com.capgemini.kedb.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.constants.Constants;
import com.capgemini.constants.GlobalResponse;
import com.capgemini.constants.RequestStatus;
import com.capgemini.entity.User;
import com.capgemini.service.AuthenticationService;
import com.capgemini.service.SolutionService;

@RestController
public class SolutionController {
	
	private Logger logger = Logger.getLogger(SolutionController.class);

	@Autowired
	private SolutionService solutionService;

	
	
	
	@RequestMapping("/savesolution")
	public GlobalResponse saveSolution(
			HttpServletRequest request,
			@NotNull @RequestParam(value = "solutionID", defaultValue = "") String solutionID,
			@NotNull @RequestParam(value = "descriptionID", defaultValue = "") String descriptionID,
	@NotNull @RequestParam(value = "keywordID", defaultValue = "") String keywordID,
	@NotNull @RequestParam(value = "technologyID", defaultValue = "") String technologyID, 
@NotNull @RequestParam(value = "linkedIncidentID", defaultValue = "") String linkedIncidentID,
@NotNull @RequestParam(value = "categoryID", defaultValue = "") String categoryID) 
	
	
	{

		GlobalResponse response = new GlobalResponse();
		try {
			boolean flag = solutionService.saveSolution(solutionID,descriptionID,keywordID,technologyID,linkedIncidentID,categoryID);
		
				response.setStatus(RequestStatus.STATUS_SUCCESS);
				response.setStatusDesc("Solution Successfully Created");
			
		} catch (Exception e) {
			response.setStatus(RequestStatus.STATUS_FAILURE);
			response.setStatusDesc("Error while creating Solution");
			logger.error(e);
		}
		return response;
	}
}