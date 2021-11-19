package com.akash;

import java.time.LocalDate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.akash.Exception.BankException;
import com.akash.dto.CustomerDTO;
import com.akash.dto.CustomerType;
import com.akash.service.CustomerService;

@SpringBootApplication
public class SpringOrmCrudApplication implements CommandLineRunner {
	
	@Autowired
	CustomerService serv;
	
	@Autowired
	Environment env;
	
	private static final Log logger=LogFactory.getLog(SpringOrmCrudApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringOrmCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
	
//		// TODO Auto-generated method stub
		//Reading customer details with the id, Uncomment these below lines
//		try {
//			CustomerDTO dto=serv.getCustomer(12);
//			logger.info(dto);
//		}
//		catch(Exception e)
//		{
//			logger.info(env.getProperty(e.getMessage()));
//		}
		
		
		//for adding customer with details, uncomment the below line
			//addCustomer();
		
		//Deleting using customer ID
		deleteCustomer();
	}
	
	public void addCustomer()throws Exception
	{
		try {
			CustomerDTO dto=new CustomerDTO();
			dto.setCustomerId(2);
			dto.setCustomerType(CustomerType.GOLD);
			dto.setDateOfBirth(LocalDate.of(1997,04,03));
			dto.setEmailId("aakash@domain.com");
			dto.setName("Aakash Singh");
			Integer customerId=serv.addCustomer(dto);
			logger.info(customerId);
		}
		catch(Exception e)
		{
			logger.info(env.getProperty(e.getMessage()));
		}
	}
	
	public void deleteCustomer()
	{
		try {
			Integer customerId=serv.deleteCustomer(2);
			logger.info("Customer deleted with customer Id "+customerId);
		}
		catch(Exception e)
		{
			logger.info(env.getProperty(e.getMessage()));
		}
	}
	
	
}
