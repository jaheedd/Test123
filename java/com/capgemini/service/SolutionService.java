package com.capgemini.service;

public interface SolutionService {

	boolean saveSolution(String solutionID, String descriptionID, String keywordID,
			String technologyID, String linkedIncidentID, String categoryID);

}