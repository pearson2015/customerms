package com.myhotel.customerms.controller;

import com.myhotel.customerms.entity.Customer;
import com.myhotel.customerms.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/customerms")
public class CustomerController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        logger.info("Getting all customers");
        return customerService.getAllCustomers();
    }

    @GetMapping("/customer/email/{email}")
    public Customer getCustomer(@PathVariable ("email") String email) {
        logger.info("Getting customer with email: " + email);
        return customerService.getCustomerById(email);
    }

    @PostMapping("/customer")
    public Customer createCustomer(@RequestBody Customer customer) {
        logger.info("Request for createCustomer " + customer);
        return customerService.createCustomer(customer);
    }

    @PutMapping("/customer")
    public Customer updateCustomer(@RequestBody Customer customer) {
        logger.info("Request for updateCustomer " + customer);
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/customer/{email}")
    public void deleteCustomer(@PathVariable ("id") String email) {
        logger.info("Deleting customer with email: " + email);
        customerService.deleteCustomer(email);
    }

}
