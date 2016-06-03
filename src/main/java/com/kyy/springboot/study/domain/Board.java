package com.kyy.springboot.study.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by yongyeonkim on 2016. 5. 29..
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {

    public enum RoleType {
        ADMIN, USER
    }

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String bno;

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "writer", nullable = false, length = 50)
    private String writer;

    @Column(name = "regdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regdate;

    @Column(name = "viewcnt")
    private double viewcnt;
}
