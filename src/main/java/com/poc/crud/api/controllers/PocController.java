package com.poc.crud.api.controllers;
/**
 * @author Sourabh Sarkar
 * Date - 01-09-2021
 * 
 */

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.crud.api.beans.PocBean;
import com.poc.crud.api.constants.UriConstants;
import com.poc.crud.api.services.PocServices;

@CrossOrigin(origins = {"http://localhost:3000/", "https://ah-reactpoc-react.azurewebsites.net", "https://reactadmin-poc.azurewebsites.net"})
@RestController
@RequestMapping(value = UriConstants.API_VERSION_1)
public class PocController {

	Logger logger = LoggerFactory.getLogger(PocController.class);

	@Autowired
	private PocServices pocServices;

	@GetMapping("/")
	public String home() {
		return "Welcome to Spring Boot REST API !";
	}

	//Method to get all the records
	@GetMapping(UriConstants.ALL_RECORDS)
	public ResponseEntity<List<PocBean>> getAllRecords() {
		List<PocBean> PocBeanList = new ArrayList<>();
		try {
			pocServices.getAll().forEach(PocBeanList::add);
			return PocBeanList.size() >= 1 ? new ResponseEntity<>(PocBeanList, HttpStatus.OK)
					: new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.info("Couldn't return anything as " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//Method to get single record
	@GetMapping(UriConstants.SINGLE_RECORD)
	public ResponseEntity<PocBean> getSingleRecords(@PathVariable("storeNumber") Long storeNumber) {
		Optional<PocBean> rec = Optional.ofNullable(pocServices.findByStoreNumber(storeNumber));
		return rec.isPresent() ? new ResponseEntity<>(rec.get(), HttpStatus.OK)
					: new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}

	//Method to create a single record
	@PostMapping(value=UriConstants.CREATE_RECORD)
	public ResponseEntity<PocBean> createRecord(@RequestBody PocBean pocBean) {
		try {
			pocServices.save(pocBean);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			logger.info("Couldn't create anything as " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//Method to update a single record
	@PutMapping(UriConstants.SINGLE_RECORD)
	public ResponseEntity<PocBean> updateRecord(
			@PathVariable("id") Long id, @RequestBody PocBean pocBean) {
		Optional<PocBean> rec = pocServices.findById(id);
		if (rec.isPresent()) {
			PocBean updatedRec = rec.get();
			updatedRec.setStoreNumber(pocBean.getStoreNumber());
			updatedRec.setDeliveryStreamNumber(pocBean.getDeliveryStreamNumber());
			updatedRec.setSupplyingDc(pocBean.getSupplyingDc());
			updatedRec.setStartDate(pocBean.getStartDate());
			updatedRec.setEndDate(pocBean.getEndDate());
			updatedRec.setReasonExclusion(pocBean.getReasonExclusion());
			updatedRec.setLastUpdateBy("SYSTEM");
			updatedRec.setLastUpdateTime(LocalDateTime.now());
			return new ResponseEntity<>(pocServices.save(updatedRec), HttpStatus.OK);
		} else {
			logger.info("Couldn't find the record in database with Store Number - " + pocBean.getStoreNumber());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	//Method to delete a single record
	@DeleteMapping(UriConstants.SINGLE_RECORD)
	public ResponseEntity<PocBean> deleteRecord(
			@PathVariable("storeNumber") Long storeNumber) {
		Optional<PocBean> rec = Optional.ofNullable(pocServices.findByStoreNumber(storeNumber));
		try {
			pocServices.delete(rec.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			logger.info("Bad request as " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Method to delete multiple records
	@DeleteMapping(UriConstants.MULTIPLE_RECORD)
	public ResponseEntity<PocBean> deleteMultipleRecords(@RequestBody List<Long> ids) {
		try {	
			pocServices.deleteMultiple(ids);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			logger.info("Bad request as " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	//Method to delete all the records
	@DeleteMapping(UriConstants.ALL_RECORDS)
	public ResponseEntity<PocBean> deleteAllRecords() {
		try {
			pocServices.deleteAll();
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			logger.info("Bad request as " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
