package com.myhotel.customerms.service;

import com.myhotel.customerms.entity.Customer;
import com.myhotel.customerms.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        logger.info("Getting all customers from service layer");
        return customerRepository.findAll();
    }

    public Customer getCustomerById(String email) {
        logger.info("Getting customer with email: " + email + " from service layer");
        return customerRepository.findById(email).orElse(null);
    }

    public Customer createCustomer(Customer customer) {
        logger.info("Creating customer: " + customer + " from service layer");
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer) {
        logger.info("Updating customer: " + customer + " from service layer");
        return customerRepository.save(customer);
    }

    public void deleteCustomer(String email) {
        logger.info("Deleting customer with email: " + email + " from service layer");
        customerRepository.deleteById(email);
    }

}
