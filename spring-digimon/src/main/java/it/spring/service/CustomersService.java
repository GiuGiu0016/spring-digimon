package it.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.spring.model.Customers;


@Service
@Transactional
public class CustomersService {

	public void save(Customers customer) {
		repo.save(customer);
	}
	
}
