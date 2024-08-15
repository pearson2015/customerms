package com.myhotel.customerms.service;

import com.myhotel.customerms.entity.Customer;
import com.myhotel.customerms.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.List;
import java.util.UUID;
import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CustomerServiceTests {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    private static Customer customer;

    @BeforeAll
    public static void setUp() {
        customer = new Customer("test@test.com",
                "First",
                "Last",
                "1234567890",
                "address") {
        };
    }

    @Test
    @DisplayName("Test get all customers")
    public void testGetAllCustomers() {
        when(customerRepository.findAll()).thenReturn(List.of(customer));
        List<Customer> customers = customerService.getAllCustomers();
        logger.info("Customers: {}", customers);
        assert customers.size() == 1;
    }

    @Test
    @DisplayName("Test get customer by id")
    public void testGetCustomerById() {
        UUID id = UUID.randomUUID();
        when(customerRepository.findById("test@test.com")).thenReturn(ofNullable(customer));
        Customer customer = customerService.getCustomerById("test@test.com");
        logger.info("Customer: {}", customer);
        assert customer != null;
        assert customer.getEmail().equals("test@test.com");
    }

    @Test
    @DisplayName("Test get customer by id not found")
    public void testGetCustomerByIdNotFound() {
        when(customerRepository.findById(anyString())).thenReturn(empty());
        Customer customer = customerService.getCustomerById("test@test.com");
        logger.info("Customer: {}", customer);
        assert customer == null;
    }

}
