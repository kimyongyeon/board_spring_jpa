package com.kyy.springboot.study.controller;

import com.kyy.springboot.study.domain.Customer;
import com.kyy.springboot.study.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by yongyeonkim on 2016. 5. 30..
 */
@Controller
@RequestMapping("customers")
public class CustomerController {

//    @Autowired
//    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    String list(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "/customers/list";
    }

//    @RequestMapping(method = RequestMethod.GET)
//    List<Customer> getCustomers() {
//        List<Customer> customers = customerService.findAll();
//        return customers;
//    }
//
//    @RequestMapping(value = "{id}", method = RequestMethod.GET)
//    Customer getCustomer(@PathVariable Integer id) {
//        Customer customer = customerService.findOne(id);
//        return customer;
//    }
//
//    public void create() {
//        customerRepository.save(new Customer( "Hidetoshi", "Dekisugi"));
//        customerRepository.findAll().forEach(System.out::println);
//
//        // 페이징 처리
//        Pageable pageable = new PageRequest(0, 3);
//        Page<Customer> page = customerRepository.findAll(pageable);
//        System.out.println("한페이지당 데이터 수=" + page.getSize());
//        System.out.println("한페이지=" + page.getNumber());
//        System.out.println("전체페이지수=" + page.getTotalPages());
//        System.out.println("전체데이터수=" + page.getTotalElements());
//        page.getContent().forEach(System.out::println);
//    }


}
