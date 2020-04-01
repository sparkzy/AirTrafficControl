package com.clarity.bobbymcgetrick.airtrafficcontrol.services.implementations;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clarity.bobbymcgetrick.airtrafficcontrol.entities.Size;
import com.clarity.bobbymcgetrick.airtrafficcontrol.repos.SizeRepo;
import com.clarity.bobbymcgetrick.airtrafficcontrol.services.interfaces.SizeService;

/**
* Size Spring Service for Air-Traffic-Control
* Implements SizeService
* Handles business logic for Air-Traffic-Control Size
* 
* @author Bobby McGetrick
*
*/
@Service
public class SizeServiceImpl implements SizeService {
	
static Logger log = Logger.getLogger(SizeServiceImpl.class.getName());
	
	/************************************************************************************
	 * Fields
	 ************************************************************************************/
	@Autowired
	private SizeRepo sizeRepo;
	
	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	public SizeServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}	

	/**
	 * Create new SizeServiceImpl with a pre-defined SizeRepo
	 * 
	 * @param sizeRepo
	 */
	public SizeServiceImpl(SizeRepo sizeRepo) {
		super();
		this.sizeRepo = sizeRepo;
	}

	/************************************************************************************
	* Overrides
	************************************************************************************/
	/**
	 * Call SizeRepos' save() method and insert, or update if the size already exists,
	 * the given Size into the Air-Traffic-Control database as a new Size
	 * 
	 * @param newSize
	 * 
	 * @return Size
	 */
	@Override
	public Size save(Size newSize) {
		return sizeRepo.save(newSize);
	}
	
	/**
	 * Call SizeRepo's findById() method and return a Size in the Air-Traffic-Control database
	 * with the corresponding id
	 * 
	 * @param id
	 * 
	 * @return Size
	 */
	@Override
	public Size findById(int id) {
		log.info("Getting Size with id " + id);
		return sizeRepo.findById(id);
	}

	/**
	 * Call SizeRepo's findAll() method and return a List of all Sizes in
	 * the Air-Traffic-Control database
	 * 
	 * @return List<Sizes>
	 */
	@Override
	public List<Size> findAll() {
		log.info("Getting all Sizes");
		return sizeRepo.findAll();
	}

	/**
	 * Call SizeRepo's delete() method and delete a Size from the Air-Traffic-Control
	 * database with the corresponding size_id
	 * 
	 * @param id
	 */
	@Override
	public void delete(int id) {
		log.info("Deleting Size with id " + id);
		sizeRepo.deleteById(id);;
	}

}
