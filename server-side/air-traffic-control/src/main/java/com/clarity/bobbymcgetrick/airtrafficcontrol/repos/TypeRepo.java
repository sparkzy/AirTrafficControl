package com.clarity.bobbymcgetrick.airtrafficcontrol.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clarity.bobbymcgetrick.airtrafficcontrol.entities.Type;

/**
* Type Repository Interface for Air-Traffic-Control
* Extends JpaReopsitory<Type, Integer>
* 
* @author Bobby McGetrick
*
*/
public interface TypeRepo extends JpaRepository<Type, Integer> {
	
	Type findById(int id);

}
