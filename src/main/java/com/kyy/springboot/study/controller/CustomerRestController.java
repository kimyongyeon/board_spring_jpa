package com.kyy.springboot.study.controller;

import com.kyy.springboot.study.domain.Customer;
import com.kyy.springboot.study.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Created by yongyeonkim on 2016. 6. 2..
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("api/customers")
public class CustomerRestController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    List<Customer> getCustomers() {
        List<Customer> customers = customerService.findAll();
        return customers;
    }

    @RequestMapping(method = RequestMethod.GET)
    Page<Customer> getCustomers(@PageableDefault Pageable pageable) {
        Page<Customer> customers = customerService.findAll(pageable);
        return customers;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    Customer getCustomer(@PathVariable Integer id) {
        Customer customer = customerService.findOne(id);
        return customer;
    }

    // 신규 고객 작성
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<Customer> postCustomers(@RequestBody Customer customer, UriComponentsBuilder uriBuilder) {
        Customer created = customerService.create(customer);
        URI location = uriBuilder.path("api/customers/{id}")
                .buildAndExpand(created.getId()).toUri();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(location);
        return new ResponseEntity<Customer>(created, headers, HttpStatus.CREATED);
    }

    // 고객 한명의 정보 업데이트
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    Customer putCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        customer.setId(id);
        return customerService.update(customer);
    }

    // 고객 한 명의 정보 삭제
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCustomer(@PathVariable Integer id) {
        customerService.delete(id);
    }

}
