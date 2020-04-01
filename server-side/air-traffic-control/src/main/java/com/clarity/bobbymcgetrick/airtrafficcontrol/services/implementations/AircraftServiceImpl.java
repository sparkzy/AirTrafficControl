package com.clarity.bobbymcgetrick.airtrafficcontrol.services.implementations;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clarity.bobbymcgetrick.airtrafficcontrol.entities.Aircraft;
import com.clarity.bobbymcgetrick.airtrafficcontrol.repos.AircraftRepo;
import com.clarity.bobbymcgetrick.airtrafficcontrol.services.interfaces.AircraftService;

/**
* Aircraft Spring Service for Air-Traffic-Control
* Implements AircraftService
* Handles business logic for Air-Traffic-Control Aircraft
* 
* @author Bobby McGetrick
*
*/
@Service
public class AircraftServiceImpl implements AircraftService {

	static Logger log = Logger.getLogger(AircraftServiceImpl.class.getName());
	
	/************************************************************************************
	 * Fields
	 ************************************************************************************/
	@Autowired
	private AircraftRepo acRepo;
	
	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	public AircraftServiceImpl() {
		super();
		log.trace("Creating new AircraftServiceImlp");
	}
	
	/**
	 * Create new AircraftServiceImpl with a pre-defined AircraftRepo
	 * 
	 * @param acRepo
	 */
	public AircraftServiceImpl(AircraftRepo acRepo) {
		super();
		log.trace("Creating new AircraftServiceImlp with pre-defined Repository " + acRepo);
		this.acRepo = acRepo;
	}
	
	/************************************************************************************
	* Overrides
	************************************************************************************/
	/**
	 * Call AircraftRepos' save() method and insert, or update if the aircraft already exists,
	 * the given Aircraft into the Air-Traffic-Control database as a new Aircraft
	 * 
	 * @param newAircraft
	 * 
	 * @return Aircraft
	 */
	@Override
	public Aircraft save(Aircraft newAircraft) {
		log.info("Saving new Aircraft " + newAircraft);
		return acRepo.save(newAircraft);
	}

	/**
	 * Call AircraftRepo's findById() method and return a Aircraft in the Air-Traffic-Control database
	 * with the corresponding id
	 * 
	 * @param id
	 * 
	 * @return Aircraft
	 */
	@Override
	public Aircraft findById(int id) {
		log.info("Getting Aircraft with id " + id);
		return acRepo.findById(id);
	}

	/**
	 * Call AircraftRepo's findAll() method and return a List of all Aircrafts in
	 * the Air-Traffic-Control database
	 * 
	 * @return List<Aircrafts>
	 */
	@Override
	public List<Aircraft> findAll() {
		log.info("Getting all Aircraft");
		return acRepo.findAll();
	}

	/**
	 * Call AircraftRepo's delete() method and delete a Aircraft from the Air-Traffic-Control
	 * database with the corresponding aircraft_id
	 * 
	 * @param id
	 */
	@Override
	public void delete(int id) {
		log.info("Deleting Aircraft with id " + id);
		acRepo.deleteById(id);
	}

}
