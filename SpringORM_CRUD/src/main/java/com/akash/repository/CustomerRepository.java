package com.akash.repository;

import com.akash.Exception.BankException;
import com.akash.dto.CustomerDTO;

public interface CustomerRepository
{
	public CustomerDTO customerInfo(Integer customerId)throws BankException;
	public Integer addCustomer(CustomerDTO dto)throws BankException;
	public Integer deleteCustomer(Integer customerId) throws BankException;
}
