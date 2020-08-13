package com.example.demo.services;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerService {

    private static Map<Long, Customer> customerRepo = new HashMap<>();
    static {
        /*
        Customer c1 = new Customer(1L,"Rick", "M");
        customerRepo.put(1L,c1);
        Customer c2 = new Customer(2L,"Sam", "M");
        customerRepo.put(2L,c2);

         */
    }

    public Customer createCustomer(Customer customer) {
        customerRepo.put(customer.getId(), customer);
        return customerRepo.get(customer.getId());
    }

    public Customer updateCustomer(Customer customer) {
       // Customer temp= customerRepo.get(customer.getId());
        //temp = customer;
       customerRepo.replace(customer.getId(), customer);
        return  customerRepo.get(customer.getId());
       //return customerRepo.replace(customer.getId(), customer);
    }

    public void deleteCustomer(Customer customer) {
        if(!customerRepo.isEmpty() && customerRepo.containsKey(customer.getId())) {
            customerRepo.remove(customer.getId());
        }
    }

    public Customer getCustomer(Long id) {
        return customerRepo.get(id);
    }

    public Collection<Customer> getCustomerList() {
        return customerRepo.values();
    }
}
