package com.akash.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.akash.Exception.BankException;
import com.akash.dto.CustomerDTO;
import com.akash.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService
{
	
	@Autowired
	private CustomerRepository repo;

	@Override
	public CustomerDTO getCustomer(Integer customerId) throws BankException
	{
		// TODO Auto-generated method stub
		CustomerDTO customerDto=repo.customerInfo(customerId);
		return customerDto;
		
	}

	@Override
	public Integer addCustomer(CustomerDTO dto) throws BankException {
		// TODO Auto-generated method stub
		Integer id=repo.addCustomer(dto);
		return id;
	}

	@Override
	public Integer deleteCustomer(Integer customerId) throws BankException {
		// TODO Auto-generated method stub
		Integer cId=repo.deleteCustomer(customerId);
		return cId;
	}	
		
	
}
