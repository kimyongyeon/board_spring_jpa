package com.kyy.springboot.study.service;

import com.kyy.springboot.study.domain.Customer;
import com.kyy.springboot.study.service.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

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

    public void save(Customer customer) {
        SqlParameterSource param = new BeanPropertySqlParameterSource(customer);
        if (customer.getId() == null) { // insert
            Number key = insert.executeAndReturnKey(param);
            customer.setId(key.intValue());
            customerRepository.save(customer);
        } else { // update
            customerRepository.save(customer);
        }
    }

    public List<Customer> findAll() {
        return customerRepository.findAllOrderByName();
    }
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAllOrderByName(pageable);
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

    private static final RowMapper<Customer> customerRowMapper = (rs, i) -> {
        Integer id = rs.getInt("id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        return new Customer(id, firstName, lastName);
    };

    private final ConcurrentMap<Integer, Customer> customerConcurrentMap = new ConcurrentHashMap<Integer, Customer>();

//    public List<Customer> findAll() {
//
//        List<Customer> customers = jdbcTemplate.query(
//                "select id, first_name, last_name from customers order by id", customerRowMapper
//        );
//
//        customers.forEach(x -> System.out.println(x));
//        customers.forEach((x) -> System.out.println(x));
//        customers.forEach(System.out::println);
//
//        return customers;
////        return new ArrayList<>(customerConcurrentMap.values());
//    }
//
//    public Customer findOne(Integer customerId) {
//        return customerConcurrentMap.get(customerId);
//    }
//
//    public Customer save(Customer customer) {
//        return customerConcurrentMap.put(customer.getId(), customer);
//    }
//
//    public Customer delete(Integer customerId) {
//        return customerConcurrentMap.remove(customerId);
//    }

}
