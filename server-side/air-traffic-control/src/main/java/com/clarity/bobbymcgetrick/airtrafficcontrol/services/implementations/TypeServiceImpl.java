package com.clarity.bobbymcgetrick.airtrafficcontrol.services.implementations;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clarity.bobbymcgetrick.airtrafficcontrol.entities.Type;
import com.clarity.bobbymcgetrick.airtrafficcontrol.repos.TypeRepo;
import com.clarity.bobbymcgetrick.airtrafficcontrol.services.interfaces.TypeService;

/**
* Type Spring Service for Air-Traffic-Control
* Implements TypeService
* Handles business logic for Air-Traffic-Control Type
* 
* @author Bobby McGetrick
*
*/
@Service
public class TypeServiceImpl implements TypeService {
	
static Logger log = Logger.getLogger(TypeServiceImpl.class.getName());
	
	/************************************************************************************
	 * Fields
	 ************************************************************************************/
	@Autowired
	private TypeRepo typeRepo;
	
	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	public TypeServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}	

	/**
	 * Create new TypeServiceImpl with a pre-defined TypeRepo
	 * 
	 * @param typeRepo
	 */
	public TypeServiceImpl(TypeRepo typeRepo) {
		super();
		this.typeRepo = typeRepo;
	}

	/************************************************************************************
	* Overrides
	************************************************************************************/
	/**
	 * Call TypeRepos' save() method and insert, or update if the type already exists,
	 * the given Type into the Air-Traffic-Control database as a new Type
	 * 
	 * @param newType
	 * 
	 * @return Type
	 */
	@Override
	public Type save(Type newType) {
		return typeRepo.save(newType);
	}
	
	/**
	 * Call TypeRepo's findById() method and return a Type in the Air-Traffic-Control database
	 * with the corresponding id
	 * 
	 * @param id
	 * 
	 * @return Type
	 */
	@Override
	public Type findById(int id) {
		log.info("Getting Type with id " + id);
		return typeRepo.findById(id);
	}

	/**
	 * Call TypeRepo's findAll() method and return a List of all Types in
	 * the Air-Traffic-Control database
	 * 
	 * @return List<Types>
	 */
	@Override
	public List<Type> findAll() {
		return typeRepo.findAll();
	}

	/**
	 * Call TypeRepo's delete() method and delete a Type from the Air-Traffic-Control
	 * database with the corresponding type_id
	 * 
	 * @param id
	 */
	@Override
	public void delete(int id) {
		log.info("Deleting Type with id " + id);
		typeRepo.deleteById(id);;
	}

}
