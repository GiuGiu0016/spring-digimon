package it.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.spring.model.Customers;
import it.spring.repository.CustomersRepository;


@Service
@Transactional
public class CustomersService {

	@Autowired CustomersRepository repo;
	
	public void save(Customers customer) {
		repo.save(customer);
	}
	
	public List<Customers> listAll() {
		return (List<Customers>) repo.findAll();
	}
	
	public Customers get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public List<Customers> search(String keyword) {
		return repo.search(keyword);
	}
	
}
