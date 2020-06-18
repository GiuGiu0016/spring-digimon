package it.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.spring.model.Digimon;


public interface DigimonRepository extends CrudRepository<Digimon, Long> {
	
	@Query(value = "SELECT digimon FROM Digimon digimon WHERE digimon.name LIKE '%' || :keyword || '%'"
			+ " OR digimon.quantita LIKE '%' || :keyword || '%'"
			+ " OR digimon.categoria LIKE '%' || :keyword || '%'")
	public List<Digimon> search(@Param("keyword") String keyword);
}
