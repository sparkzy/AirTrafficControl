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

import com.clarity.bobbymcgetrick.airtrafficcontrol.entities.Size;
import com.clarity.bobbymcgetrick.airtrafficcontrol.services.implementations.SizeServiceImpl;
import com.clarity.bobbymcgetrick.airtrafficcontrol.services.interfaces.SizeService;

/**
 * Size Controller for Air-Traffic-Control Parses requests for
 * Air-Traffic-Control Air-Traffic-Control
 * 
 * @author Bobby McGetrick
 *
 */
@RestController
@RequestMapping("size")
@CrossOrigin(origins = "http://localhost:4200")
public class SizeController {

	static Logger log = Logger.getLogger(SizeServiceImpl.class.getName());

	/************************************************************************************
	 * Fields
	 ************************************************************************************/
	@Autowired
	private SizeService sizeService;

	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	public SizeController() {
		super();
	}

	/**
	 * Create new SizeController with a pre-defined SizeService
	 * 
	 * @param acService
	 */
	public SizeController(SizeService sizeService) {
		super();
		this.sizeService = sizeService;
	}

	/************************************************************************************
	 * Create & Update
	 ************************************************************************************/
	/**
	 * Call SizeService's save() method and insert, or update if the Size already
	 * exists, the given Size into the Air-Traffic-Control database as a new Size
	 * 
	 * @param newSize
	 * @return
	 */
	@PostMapping
	public ResponseEntity<String> save(@RequestBody Size newSize) {
		if (sizeService.save(newSize) != null) {
			return ResponseEntity.status(HttpStatus.OK).body("Size save/updated successfully.");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Size was not able to be saved/updated.");
		}
	}

	/************************************************************************************
	 * Read
	 ************************************************************************************/
	/**
	 * Call SizeService's findById() method and return a Size from the
	 * Air-Traffic-Control database with the corresponding size_id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("id/{id}")
	public ResponseEntity<Size> findById(@PathVariable int id) {
		Size size = sizeService.findById(id);
		if (size != null) {
			return ResponseEntity.status(HttpStatus.OK).body(size);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(size);
		}
	}

	/**
	 * Call SizeService's findAll() method and return a List of Sizes from the
	 * Air-Traffic-Control database
	 * 
	 * @return
	 */
	@GetMapping()
	public ResponseEntity<List<Size>> findAll() {
		List<Size> sizes = sizeService.findAll();
		if (sizes != null) {
			return ResponseEntity.status(HttpStatus.OK).body(sizes);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sizes);
		}
	}

	/************************************************************************************
	 * Delete
	 ************************************************************************************/
	@DeleteMapping("id/{id}")
	public void delete(@PathVariable int id) {
		sizeService.delete(id);
	}

}
