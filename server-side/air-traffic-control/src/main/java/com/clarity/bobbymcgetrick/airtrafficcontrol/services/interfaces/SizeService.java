package com.clarity.bobbymcgetrick.airtrafficcontrol.services.interfaces;

import java.util.List;

import com.clarity.bobbymcgetrick.airtrafficcontrol.entities.Size;

/**
* Size Service Interface for Air-Traffic-Control
* 
* @author Bobby McGetrick
*
*/
public interface SizeService {
	
	/************************************************************************************
	 * Create
	 ************************************************************************************/
	Size save(Size newSize);
	
	/************************************************************************************
	 * Retrieve
	 ************************************************************************************/
	Size findById(int id);
	List<Size> findAll();
	
	/************************************************************************************
	 * Update
	 ************************************************************************************/
	
	/************************************************************************************
	 * Delete
	 ************************************************************************************/
	void delete(int id);

}
