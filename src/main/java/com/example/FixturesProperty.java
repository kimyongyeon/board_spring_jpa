package com.example;

/**
 * Created by yongyeonkim on 2016. 5. 30..
 */

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Filename : FixturesProperty.java
 * Author   : saltfactory<saltfactory@gmail.com>
 * Created  : 11/23/15.
 */
@Component
@EnableConfigurationProperties
@ConfigurationProperties(locations = {"fixtures.yml"}, prefix = "fixtures")
public class FixturesProperty {
    @NestedConfigurationProperty
    private List<Article> articles = new ArrayList<>();

    public List<Article> getArticles() {
        return articles;
    }
}
