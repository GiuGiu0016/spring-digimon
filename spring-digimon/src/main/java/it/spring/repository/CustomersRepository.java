package it.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.spring.model.Customers;


public class CustomersRepository {

	public interface DigimonRepository extends CrudRepository<Customers, Long> {
		
		@Query(value = "SELECT customers FROM Customers customers WHERE customers.name LIKE '%' || :keyword || '%'"
				+ " OR customers.quantita LIKE '%' || :keyword || '%'"
				+ " OR customers.categoria LIKE '%' || :keyword || '%'")
		public List<Customers> search(@Param("keyword") String keyword);
	}
	
}
