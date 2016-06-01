package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by yongyeonkim on 2016. 5. 30..
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("select x from Customer x order by x.firstName, x.lastName")
    List<Customer> findAllOrderByName();
}
