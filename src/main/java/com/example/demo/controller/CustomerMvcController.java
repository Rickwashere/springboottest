package com.example.demo.controller;

import com.example.demo.dto.CustomerDto;
import com.example.demo.model.Customer;
import com.example.demo.services.CustomerRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Optional;

@Controller
public class CustomerMvcController {
    @Autowired
    CustomerRepositoryService customerRepositoryService;

    @RequestMapping
    public String getAllCustomers(Model model,
                                  @RequestParam(defaultValue = "0") Integer pageNo,
                                  @RequestParam(defaultValue = "5") Integer pageSize,
                                  @RequestParam(defaultValue = "id") String sortBy) {
        Collection<CustomerDto> list = customerRepositoryService.customerQueryList();

        model.addAttribute("customers", list);
        return "list-customers";
    }

    @RequestMapping(path = {"/edit", "/edit/{id}"})
    public String editEmployeeById(Model model, @PathVariable("id") Optional<Long> id) {
        if (id.isPresent()) {
            Customer customer = customerRepositoryService.getCustomer(id.get()).get();
            model.addAttribute("customer", customer);
        } else {
            model.addAttribute("customer", new Customer());
        }
        return "add-edit-customer";
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteEmployeeById(Model model, @PathVariable("id") Long id) {
        customerRepositoryService.deleteCustomerbyid(id);
        return "redirect:/";
    }

    @RequestMapping(path = "/createCustomer", method = RequestMethod.POST)
    public String createOrUpdateEmployee(Customer customer)
    {
        customerRepositoryService.createCustomer(customer);
        return "redirect:/";
    }
}
