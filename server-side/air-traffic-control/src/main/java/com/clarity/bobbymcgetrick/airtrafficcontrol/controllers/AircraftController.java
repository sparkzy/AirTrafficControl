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

import com.clarity.bobbymcgetrick.airtrafficcontrol.entities.Aircraft;
import com.clarity.bobbymcgetrick.airtrafficcontrol.services.implementations.AircraftServiceImpl;
import com.clarity.bobbymcgetrick.airtrafficcontrol.services.interfaces.AircraftService;

/**
 * Aircraft Controller for Air-Traffic-Control Parses requests for Air-Traffic-Control Air-Traffic-Control
 * 
 * @author Bobby McGetrick
 *
 */
@RestController
@RequestMapping("aircraft")
@CrossOrigin(origins = "http://localhost:4200")
public class AircraftController {

	static Logger log = Logger.getLogger(AircraftServiceImpl.class.getName());
	
	/************************************************************************************
	 * Fields
	 ************************************************************************************/
	@Autowired
	private AircraftService acService;
	
	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	public AircraftController() {
		super();
	}

	/**
	 * Create new AircraftController with a pre-defined AircraftService
	 * 
	 * @param acService
	 */
	public AircraftController(AircraftService acService) {
		super();
		this.acService = acService;
	}
	
	/************************************************************************************
	 * Create & Update
	 ************************************************************************************/
	/**
	 * Call AircraftService's save() method and insert, or update if the Aircraft already
	 * exists, the given Aircraft into the Air-Traffic-Control database as a new Aircraft
	 * 
	 * @param newAircraft
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Aircraft> save(@RequestBody Aircraft newAircraft) {
		Aircraft savedAC = acService.save(newAircraft);
		if (savedAC != null) {
			return ResponseEntity.status(HttpStatus.OK).body(savedAC);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(savedAC);
		}
	}
	
	/************************************************************************************
	 * Read
	 ************************************************************************************/
	/**
	 * Call AircraftService's findById() method and return a Aircraft from the Air-Traffic-Control
	 * database with the corresponding aircraft_id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("id/{id}")
	public ResponseEntity<Aircraft> findById(@PathVariable int id) {
		Aircraft ac = acService.findById(id);
		if (ac != null) {
			return ResponseEntity.status(HttpStatus.OK).body(ac);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ac);
		}
	}
	
	/**
	 * Call AircraftService's findAll() method and return a List of Aircarft from the
	 * Air-Traffic-Control database
	 *  
	 * @return
	 */
	@GetMapping()
	public ResponseEntity<List<Aircraft>> findAll() {
		List<Aircraft> acs = acService.findAll();
		if (acs != null) {
			return ResponseEntity.status(HttpStatus.OK).body(acs);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(acs);
		}
	}
	
	/************************************************************************************
	 * Delete
	 ************************************************************************************/
	@DeleteMapping("id/{id}")
	public void delete(@PathVariable int id) {
		System.out.println("******************************************");
		System.out.println(id);
		System.out.println("******************************************");
		acService.delete(id);
	}
}
