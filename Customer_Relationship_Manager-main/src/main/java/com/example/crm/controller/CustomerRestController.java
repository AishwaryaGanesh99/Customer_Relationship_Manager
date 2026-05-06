package com.example.crm.controller;

import com.example.crm.entity.Customer;
import com.example.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller for Customer APIs.
 *
 * Provides:
 * - CRUD operations
 * - Pagination + Search support
 * - JSON-based responses for API clients (Postman, frontend apps)
 */

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    /**
     * Fetch all customers with optional search and pagination
     */
    @GetMapping
    public Page<Customer> getAllCustomers(
            @RequestParam(required = false) String keyword,
            Pageable pageable) {

        return customerService.getCustomers(keyword, pageable);
    }

    /**
     * Fetch a customer by ID
     */
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    /**
     * Create a new customer
     */
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return customer;
    }

    /**
     * Update an existing customer
     */

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer updatedCustomer) {
        Customer existing = customerService.getCustomerById(id);

        existing.setFirstName(updatedCustomer.getFirstName());
        existing.setLastName(updatedCustomer.getLastName());
        existing.setEmail(updatedCustomer.getEmail());

        customerService.saveCustomer(existing);

        return existing;
    }

    /**
     * Delete a customer by ID
     */
    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return "Customer deleted successfully!";
    }
}