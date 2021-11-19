package com.akash.service;

import com.akash.Exception.BankException;
import com.akash.dto.CustomerDTO;

public interface CustomerService
{
	public CustomerDTO getCustomer(Integer customerId)throws BankException;
	public Integer addCustomer(CustomerDTO dto)throws BankException;
	public Integer deleteCustomer(Integer customerId)throws BankException;
}
