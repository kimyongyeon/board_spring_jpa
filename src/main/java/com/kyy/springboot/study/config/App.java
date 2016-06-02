package com.kyy.springboot.study.config;

import com.kyy.springboot.study.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by yongyeonkim on 2016. 6. 2..
 */
@Configuration
public class App implements CommandLineRunner{

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        // 원시적인 방법
//        String sql = "select id, first_name, last_name from customers where id = :id";
//        SqlParameterSource param = new MapSqlParameterSource().addValue("id", 1);
        // 람다 사용후
//        Customer result = jdbcTemplate.queryForObject(sql, param,
//                (rs, rowNum)-> new Customer(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name")));
//        System.out.println(result);

        // 람다 사용전
//        Customer result = jdbcTemplate.queryForObject(sql, param, new RowMapper<Customer>() {
//            @Override
//            public Customer mapRow(ResultSet rs, int i) throws SQLException {
//                return new Customer(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"));
//            }
//        });



        // 데이터베이스가 붙는지 테스트 할때 간단하게 테스트 해볼 수있음
//        String sql = "SELECT 1";
//        SqlParameterSource param = new MapSqlParameterSource();
//        Integer result = jdbcTemplate.queryForObject(sql, param, Integer.class);
//        System.out.println(result);

//        // 데이터 저장
//        customerService.save(new Customer(1, "Nobita", "Nobi"));
//        customerService.save(new Customer(2, "Takeshi", "Goda"));
//        customerService.save(new Customer(3, "Suneo", "Honekawa"));
//
//        // 데이터 표시
//        customerService.findAll().forEach(System.out::println);
    }
}
