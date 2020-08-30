package com.example.demo.services;

import com.example.demo.dto.CustomerDto;
import com.example.demo.model.Customer;
import com.example.demo.model.CustomerEvent;
import com.example.demo.model.Event;
import com.example.demo.repository.CustomerQueryRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerRepositoryService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    CustomerQueryRepository queryRepository;

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

    public void deleteCustomerbyid(Long givenId) {
        Customer customer= customerRepository.findById(givenId).get();
        customerRepository.delete(customer);
    }

    public Optional<Customer> getCustomer(Long id) {
        Optional<Customer> c = customerRepository.findById(id);
        List<CustomerEvent> eventList= c.get().getCustomerSideEventList();
        for(CustomerEvent ce: eventList){
            Event e = eventRepository.findById(ce.getEventId()).get();
            ce.setEventType(e.getEventType());
            ce.setDescription(e.getDescription());
        }
        return c;

    }
    public Collection<CustomerDto> customerQueryList(){
       return queryRepository.getCustomerContactList();
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
