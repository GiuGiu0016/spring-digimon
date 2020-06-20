package it.spring.repository;

import org.springframework.data.repository.CrudRepository;

import it.spring.model.Digimon;


public interface DigimonRepository extends CrudRepository<Digimon, Long> {
	
}
