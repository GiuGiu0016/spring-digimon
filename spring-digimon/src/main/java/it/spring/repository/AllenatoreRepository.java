package it.spring.repository;

import org.springframework.data.repository.CrudRepository;

import it.spring.model.Allenatore;

public interface AllenatoreRepository extends CrudRepository<Allenatore, Long> {
	
}