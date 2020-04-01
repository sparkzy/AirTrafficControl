package com.clarity.bobbymcgetrick.airtrafficcontrol.services.interfaces;

import java.util.List;

import com.clarity.bobbymcgetrick.airtrafficcontrol.entities.Type;

/**
* Type Service Interface for Air-Traffic-Control
* 
* @author Bobby McGetrick
*
*/
public interface TypeService {
	
	/************************************************************************************
	 * Create
	 ************************************************************************************/
	Type save(Type newType);
	
	/************************************************************************************
	 * Retrieve
	 ************************************************************************************/
	Type findById(int id);
	List<Type> findAll();
	
	/************************************************************************************
	 * Update
	 ************************************************************************************/
	
	/************************************************************************************
	 * Delete
	 ************************************************************************************/
	void delete(int id);

}
