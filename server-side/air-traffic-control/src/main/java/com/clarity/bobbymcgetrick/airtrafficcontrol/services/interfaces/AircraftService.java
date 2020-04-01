package com.clarity.bobbymcgetrick.airtrafficcontrol.services.interfaces;

import java.util.List;

import com.clarity.bobbymcgetrick.airtrafficcontrol.entities.Aircraft;

/**
* Aircraft Service Interface for Air-Traffic-Control
* 
* @author Bobby McGetrick
*
*/
public interface AircraftService {
	
	/************************************************************************************
	 * Create
	 ************************************************************************************/
	Aircraft save(Aircraft newAircraft);
	
	/************************************************************************************
	 * Retrieve
	 ************************************************************************************/
	Aircraft findById(int id);
	List<Aircraft> findAll();
	
	/************************************************************************************
	 * Update
	 ************************************************************************************/
	
	/************************************************************************************
	 * Delete
	 ************************************************************************************/
	void delete(int id);

}
