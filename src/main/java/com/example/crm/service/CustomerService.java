package com.example.crm.service;

import com.example.crm.entity.Customer;
import com.example.crm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Service layer handling business logic for Customer operations.
 *
 * Acts as an intermediary between Controller and Repository.
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Save or update a customer
     */
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }
    /**
     * Retrieve a customer by ID
     */
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    /**
     * Delete a customer by ID
     */
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    /**
     * Fetch customers with optional keyword filtering and pagination
     *
     * @param keyword search term (first name, last name, email)
     * @param pageable pagination + sorting info
     */
    public Page<Customer> getCustomers(String keyword, Pageable pageable) {

        if (keyword != null && !keyword.trim().isEmpty()) {
            return customerRepository
                    .findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
                            keyword, keyword, keyword, pageable);
        }

        return customerRepository.findAll(pageable);
    }

    public Customer saveAndReturn(Customer customer) {
        return customerRepository.save(customer);
    }
}