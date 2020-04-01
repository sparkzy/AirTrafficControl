package com.clarity.bobbymcgetrick.airtrafficcontrol.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clarity.bobbymcgetrick.airtrafficcontrol.entities.Type;
import com.clarity.bobbymcgetrick.airtrafficcontrol.services.implementations.TypeServiceImpl;
import com.clarity.bobbymcgetrick.airtrafficcontrol.services.interfaces.TypeService;

/**
 * Type Controller for Air-Traffic-Control Parses requests for Air-Traffic-Control Air-Traffic-Control
 * 
 * @author Bobby McGetrick
 *
 */
@RestController
@RequestMapping("type")
@CrossOrigin(origins = "http://localhost:4200")
public class TypeController {
	
	static Logger log = Logger.getLogger(TypeServiceImpl.class.getName());

	/************************************************************************************
	 * Fields
	 ************************************************************************************/
	@Autowired
	private TypeService typeService;

	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	public TypeController() {
		super();
	}

	/**
	 * Create new TypeController with a pre-defined TypeService
	 * 
	 * @param acService
	 */
	public TypeController(TypeService typeService) {
		super();
		this.typeService = typeService;
	}

	/************************************************************************************
	 * Create & Update
	 ************************************************************************************/
	/**
	 * Call TypeService's save() method and insert, or update if the Type already
	 * exists, the given Type into the Air-Traffic-Control database as a new Type
	 * 
	 * @param newType
	 * @return
	 */
	@PostMapping
	public ResponseEntity<String> save(@RequestBody Type newType) {
		if (typeService.save(newType) != null) {
			return ResponseEntity.status(HttpStatus.OK).body("Type save/updated successfully.");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Type was not able to be saved/updated.");
		}
	}

	/************************************************************************************
	 * Read
	 ************************************************************************************/
	/**
	 * Call TypeService's findById() method and return a Type from the
	 * Air-Traffic-Control database with the corresponding type_id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("id/{id}")
	public ResponseEntity<Type> findById(@PathVariable int id) {
		Type type = typeService.findById(id);
		if (type != null) {
			return ResponseEntity.status(HttpStatus.OK).body(type);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(type);
		}
	}

	/**
	 * Call TypeService's findAll() method and return a List of Types from the
	 * Air-Traffic-Control database
	 * 
	 * @return
	 */
	@GetMapping()
	public ResponseEntity<List<Type>> findAll() {
		List<Type> types = typeService.findAll();
		if (types != null) {
			return ResponseEntity.status(HttpStatus.OK).body(types);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(types);
		}
	}

	/************************************************************************************
	 * Delete
	 ************************************************************************************/
	@DeleteMapping("id/{id}")
	public void delete(@PathVariable int id) {
		typeService.delete(id);
	}

}
