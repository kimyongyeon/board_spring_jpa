package com.kyy.springboot.study;

import com.kyy.springboot.study.domain.Customer;
import com.kyy.springboot.study.service.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class BoardSpringJpaStudyApplication extends SpringBootServletInitializer implements CommandLineRunner  {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public void run(String... args) throws Exception {

		// 데이터 추가
		Customer created = customerRepository.save(new Customer(null, "Hidetoshi", "Dekisugi"));
		System.out.println(created + " is created");
		created.setFirstName("kimyongyeon");

		// 데이터 표시
		customerRepository.findAll().forEach(System.out::println);
	}

	/**
	 * SpringBootServletInitializer를 상속받고 아래 메소드를 선언해야 static 폴더 위치를 찾아 간다.
	 * @param application
	 * @return
     */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BoardSpringJpaStudyApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(BoardSpringJpaStudyApplication.class, args);
	}
}
