package com.kyy.springboot.study.service.repository;

import com.kyy.springboot.study.domain.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by yongyeonkim on 2016. 5. 30..
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("select x from Customer x order by x.firstName, x.lastName")
    List<Customer> findAllOrderByName();

    @Query("select x from Customer x order by x.firstName, x.lastName")
    Page<Customer> findAllOrderByName(Pageable pageable);
}
