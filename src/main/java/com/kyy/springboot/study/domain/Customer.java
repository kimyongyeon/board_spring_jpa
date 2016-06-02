package com.kyy.springboot.study.domain;

import lombok.*;

import javax.persistence.*;

/**
 * Created by yongyeonkim on 2016. 5. 30..
 */

@Entity
@Table(name = "customers") // 기본적으로 테이블 이름은 클래스와 같이 하지만 다르게 하자
@Data
@AllArgsConstructor // 전체 필드를 인자로 받는 생성자 생성
@NoArgsConstructor // 기본 생성자 생성
public class Customer {

    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.AUTO) // DB가 기본 키 번호를 자동으로 매기도록 하기 위함
    private Integer id;
    @Column(nullable = false) // not null 제약사항 설정
    private String firstName;
    @Column(nullable = false)
    private String lastName;


}
