package it.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.spring.model.Customers;


public interface CustomersRepository extends CrudRepository<Customers, Long> {
		
		@Query(value = "SELECT customers FROM Customers customers WHERE customers.name LIKE '%' || :keyword || '%'"
				+ " OR customers.cognome LIKE '%' || :keyword || '%'"
				+ " OR customers.eta LIKE '%' || :keyword || '%'")
		public List<Customers> search(@Param("keyword") String keyword);
	
}
