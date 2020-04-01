package com.clarity.bobbymcgetrick.airtrafficcontrol.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clarity.bobbymcgetrick.airtrafficcontrol.entities.Aircraft;

/**
* Aircraft Repository Interface for Air-Traffic-Control
* Extends JpaReopsitory<Aircraft, Integer>
* 
* @author Bobby McGetrick
*
*/
public interface AircraftRepo extends JpaRepository<Aircraft, Integer>{
	
	Aircraft findById(int id);
	void deleteById(int id);
	
}
