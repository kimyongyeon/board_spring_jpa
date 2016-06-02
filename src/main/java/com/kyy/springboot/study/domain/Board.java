package com.kyy.springboot.study.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by yongyeonkim on 2016. 5. 29..
 */
@Entity
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


    public Board() {
    }

    public String getBno() {
        return bno;
    }

    public void setBno(String bno) {
        this.bno = bno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public double getViewcnt() {
        return viewcnt;
    }

    public void setViewcnt(double viewcnt) {
        this.viewcnt = viewcnt;
    }
}
