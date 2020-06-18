package it.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.spring.model.Digimon;


public interface DigimonRepository extends CrudRepository<Digimon, Long> {
	
	@Query(value = "SELECT digimon FROM Digimon digimon WHERE digimon.name LIKE '%' || :keyword || '%'"
			+ " OR digimon.hp LIKE '%' || :keyword || '%'"
			+ " OR digimon.atk LIKE '%' || :keyword || '%'"
			+ " OR digimon.def LIKE '%' || :keyword || '%'"
			+ " OR digimon.res LIKE '%' || :keyword || '%'"
			+ " OR digimon.evoluzione LIKE '%' || :keyword || '%'")
	public List<Digimon> search(@Param("keyword") String keyword);
}
