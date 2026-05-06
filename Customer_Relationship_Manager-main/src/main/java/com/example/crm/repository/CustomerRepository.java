package com.example.crm.repository;

import com.example.crm.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Customer entity.
 *
 * Extends JpaRepository to provide:
 * - CRUD operations
 * - Pagination and sorting
 *
 * Includes custom search query methods.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
     Page<Customer> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
            String firstName, String lastName, String email, Pageable pageable);
}


