package com.akash.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.akash.Exception.BankException;
import com.akash.dto.CustomerDTO;
import com.akash.entity.Customer;


@Repository
public class CustomerRepositoryImpl implements CustomerRepository
{

	@PersistenceContext
	private EntityManager em;
	@Override
	public CustomerDTO customerInfo(Integer customerId) throws BankException 
	{
		// TODO Auto-generated method stub
		Customer customer = em.find(Customer.class, customerId);
		CustomerDTO dto=null;
		if(customer!=null)
		{
			dto=new CustomerDTO();
			dto.setCustomerId(customerId);
			dto.setCustomerType(customer.getCustomerType());
			dto.setDateOfBirth(customer.getDateOfBirth());
			dto.setEmailId(customer.getEmailId());
			dto.setName(customer.getName());
		}
		else
		{
			throw new BankException("CUSTOMER_NOT_FOUND");
		}
		return dto;
	}
	@Override
	public Integer addCustomer(CustomerDTO dto) throws BankException 
	{
		// TODO Auto-generated method stub
		Customer customerTest=em.find(Customer.class, dto.getCustomerId());
	
		if(customerTest==null)
		{
			Customer customer=new Customer();
			customer.setCustomerId(dto.getCustomerId());
			customer.setCustomerType(dto.getCustomerType());
			customer.setDateOfBirth(dto.getDateOfBirth());
			customer.setEmailId(dto.getEmailId());
			customer.setName(dto.getName());
			em.persist(customer);
			return customer.getCustomerId();
		}
		else
			throw new BankException("CUSTOMER_ALREADY_EXISTS");
	}
	@Override
	public Integer deleteCustomer(Integer customerId) throws BankException {
		// TODO Auto-generated method stub
		Customer customer=em.find(Customer.class, customerId);
		if(customer==null)
		{
			throw new BankException("CUSTOMER_DOESNOT_EXIST");
		}
		else
		{
			em.remove(customer);
		}
		return customer.getCustomerId();
	}

	
}
