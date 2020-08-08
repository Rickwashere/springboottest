package com.example.demo.controller;

import com.example.demo.model.Customer;
//import com.example.demo.services.;
import com.example.demo.services.CustomerRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.*;


@RestController
public class CustomerController {
    @Autowired
   // customerRepositoryService customerRepositoryService;
    CustomerRepositoryService customerRepositoryService;
    
    @RequestMapping(value = "/customers", method = GET)
    public ResponseEntity<Object> getCustomerList() {
        return new ResponseEntity<>(customerRepositoryService.getCustomerList(), HttpStatus.OK);
    }

    @RequestMapping(value = "/customers/{id}", method = GET)
    public ResponseEntity<Object> getCustomer(@PathVariable("id") Long id) {
        Optional<Customer> temp = customerRepositoryService.getCustomer(id);
        if(temp.isEmpty()) {
            throw new CustomerNotFoundException(id);
        }else{
            return new ResponseEntity<>(customerRepositoryService.getCustomer(id), HttpStatus.OK);
        }


    }

    @RequestMapping(value = "/newcustomer", method = POST)
    public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerRepositoryService.createCustomer(customer), HttpStatus.OK);
    }

    @RequestMapping(value = "/updatecustomer", method = PUT)
    public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerRepositoryService.updateCustomer(customer), HttpStatus.OK);
    }

    @RequestMapping(value = "/deletecustomer", method = DELETE)
    public ResponseEntity<Object>  deleteCustomer(@RequestBody Customer customer) {
         customerRepositoryService.deleteCustomer(customer);
        return new ResponseEntity<>("Customer Deleted", HttpStatus.OK);
    }
}
