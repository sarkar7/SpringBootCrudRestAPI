package com.poc.crud.api.repositories;

/**
 * @author Sourabh Sarkar
 * Date - 01-09-2021
 * 
 */
import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.crud.api.beans.PocBean;

public interface PocRepository extends JpaRepository<PocBean, Long> {

	public PocBean findByStoreNumber(Long storeNumber);

}
