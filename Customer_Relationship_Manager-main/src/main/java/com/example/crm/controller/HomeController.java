package com.example.crm.controller;

import com.example.crm.entity.Customer;
import com.example.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller responsible for handling UI requests.
 *
 * Features:
 * - Displays customer list
 * - Supports pagination
 * - Supports sorting
 * - Supports keyword-based search
 */

@Controller
public class HomeController {

    @Autowired
    private CustomerService customerService;

    /**
     * Loads the homepage with paginated and filtered customer data.
     *
     * @param page current page number
     * @param keyword search keyword (optional)
     * @param sortField field to sort by
     * @param sortDir sort direction (asc/desc)
     */

    @GetMapping("/")
    public String home(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(required = false) String keyword,
            @RequestParam(defaultValue = "firstName") String sortField,
            @RequestParam(defaultValue = "asc") String sortDir,
            Model model) {

        int pageSize = 5;

        Sort sort = sortDir.equals("asc") ?
                Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(page, pageSize, sort);
        Page<Customer> customerPage = customerService.getCustomers(keyword, pageable);

        model.addAttribute("customers", customerPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", customerPage.getTotalPages());
        model.addAttribute("keyword", keyword);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("pageSize", pageSize);

        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}