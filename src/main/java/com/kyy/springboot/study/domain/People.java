package com.kyy.springboot.study.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by yongyeonkim on 2016. 6. 2..
 */
@Data
@AllArgsConstructor
public class People {
    private String nameStr;
    private int ageInt;
    private PeopleSex sexEnum;

    public static enum PeopleSex {
        MALE, FEMALE
    }
}
