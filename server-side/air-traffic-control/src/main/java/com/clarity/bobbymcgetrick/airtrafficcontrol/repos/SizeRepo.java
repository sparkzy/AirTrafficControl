package com.clarity.bobbymcgetrick.airtrafficcontrol.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clarity.bobbymcgetrick.airtrafficcontrol.entities.Size;

/**
* Size Repository Interface for Air-Traffic-Control
* Extends JpaReopsitory<Size, Integer>
* 
* @author Bobby McGetrick
*
*/
public interface SizeRepo extends JpaRepository<Size, Integer> {
	
	Size findById(int id);

}
