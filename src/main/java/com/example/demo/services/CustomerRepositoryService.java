package com.example.demo.services;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Service
public class CustomerRepositoryService {

    @Autowired
    CustomerRepository customerRepository;

    @Transactional
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    @Transactional
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    @Transactional
    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }

    public Optional<Customer> getCustomer(Long id) {
        return customerRepository.findById(id);

    }

    public Collection<Customer> getCustomerList(Integer pno, Integer psze, String order ) {

        Pageable paging = PageRequest.of(pno, psze, Sort.by(order).ascending()); //or descending
        //if pagination info is required use page. Otherwise use slice for performance
        //Page<Customer> pagedResult = customerRepository.findAll(paging);
        Slice<Customer> slicedResult = customerRepository.findAll(paging);

        //pagedResult.getTotalPages();
        return slicedResult.getContent();

        /*
        You don't need sort with pagination
        Pageable paging = PageRequest.of(pageNo, pageSize);

        Page<EmployeeEntity> pagedResult = repository.findAll(paging);
         */

        /*
        * if no pagination
        * return customerRepository.findAll();
        * */

    }
    private void  deepcopyCustomerOriginal(){

    }
}
