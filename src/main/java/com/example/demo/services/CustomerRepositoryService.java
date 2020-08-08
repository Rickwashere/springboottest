package com.example.demo.services;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CustomerRepositoryService {

    @Autowired
    CustomerRepository customerRepository;


    public Optional<Customer> createCustomer(Customer customer) {
        customerRepository.save(customer);
        return customerRepository.findById(customer.getId());
    }

    public Customer updateCustomer(Customer customer) {
        Customer temp= customerRepository.findById(customer.getId()).get();
        temp.setName(customer.getName());
        temp.setGender(customer.getGender());
        return customerRepository.save(temp);
    }

    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }

    public Optional<Customer> getCustomer(Long id) {
        return customerRepository.findById(id);

    }

    public Collection<Customer> getCustomerList() {
        return customerRepository.findAll();

    }
}
