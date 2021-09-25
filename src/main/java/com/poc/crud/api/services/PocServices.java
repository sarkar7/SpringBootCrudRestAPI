package com.poc.crud.api.services;
/**
 * @author Sourabh Sarkar
 * Date - 01-09-2021
 * 
 */
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poc.crud.api.beans.PocBean;
import com.poc.crud.api.repositories.PocRepository;

@Service
public class PocServices {

	@Autowired
	private PocRepository pocRepository;

	@Transactional
	public List<PocBean> getAll() {
		return pocRepository.findAll();
	}

	@Transactional
	public PocBean findByStoreNumber(Long storeNumber) {
		return pocRepository.findByStoreNumber(storeNumber);
	}
	
	@Transactional
	public Optional<PocBean> findById(Long id) {
		return pocRepository.findById(id);
	}

	@Transactional
	public PocBean save(PocBean sccStoreExclusion) {
		return pocRepository.save(sccStoreExclusion);
	}

	@Transactional
	public void delete(PocBean rec) {
		pocRepository.delete(rec);
	}

	@Transactional
	public void deleteAll() {
		pocRepository.deleteAll();
	}

	@Transactional
	public void deleteMultiple(List<Long> ids) {
		pocRepository.deleteAllById(ids);
	}

}
