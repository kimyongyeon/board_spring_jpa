package com.kyy.springboot.study;

import com.kyy.springboot.study.domain.Customer;
import com.kyy.springboot.study.service.repository.CustomerRepository;
import net.sf.log4jdbc.Log4jdbcProxyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 프로그램 엔트리 포인트 처음 진입점
 */
@SpringBootApplication
public class BoardSpringJpaStudyApplication extends SpringBootServletInitializer implements CommandLineRunner  {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public void run(String... args) throws Exception {
		// JPA을 이용하는 방법
		// 데이터 추가
		Customer created = customerRepository.save(new Customer(null, "Hidetoshi", "Dekisugi"));
		System.out.println(created + " is created");
		created.setFirstName("kimyongyeon");
		// 데이터 표시
		customerRepository.findAll().forEach(System.out::println);

		// 페이징 처리
		Pageable pageable = new PageRequest(0, 3);
		Page<Customer> page = customerRepository.findAll(pageable);
		page.getSize(); // 한페이지당 데이터 수
		page.getNumber(); // 현재 페이지
		page.getTotalPages(); // 전체 페이지 수
		page.getTotalElements(); // 전체 데이터 수
		page.getContent().forEach(System.out::println); // 해당 페이지의 데이터 리스트를 가져올 수 있습니다.
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
