package com.kyy.springboot.study.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.Date;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 * Created by yongyeonkim on 2016. 6. 3..
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer rno;

    @Column(name = "bno", nullable = false)
    private Integer bno;

    @Column(name = "replytext", nullable = false)
    private String replytext;

    @Column(name = "replyer", nullable = false)
    private String replyer;

    @Column(name = "regdate", nullable = false)
    private Date regdate;

    @Column(name = "updatedate", nullable = false)
    private Date updatedate;
}
