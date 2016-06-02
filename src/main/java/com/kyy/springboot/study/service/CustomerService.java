package com.kyy.springboot.study.service;

import com.kyy.springboot.study.domain.Customer;
import com.kyy.springboot.study.service.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by yongyeonkim on 2016. 5. 30..
 */
@Service
@Transactional
public class CustomerService {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    SimpleJdbcInsert insert;

    @Autowired
    CustomerRepository customerRepository;

    @PostConstruct // 기본키 생성
    public void init() {
        insert = new SimpleJdbcInsert(
                (JdbcTemplate)jdbcTemplate.getJdbcOperations())
                .withTableName("customers")
                .usingGeneratedKeyColumns("id");
    }

    public List<Customer> findAll() {
        return customerRepository.findAllOrderByName();
    }

    public Customer findOne(Integer id) {
        return customerRepository.findOne(id);
    }

    public Customer create(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer update(Customer customer){
        return customerRepository.save(customer);
    }

    public void delete(Integer id) {
        customerRepository.delete(id);
    }
}
