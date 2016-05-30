package com.example;

/**
 * Created by yongyeonkim on 2016. 5. 30..
 */

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private List<Map> articles = new ArrayList<>();

    FixturesProperty() {
        Map<String, String> m = new HashMap<>();
        m.put("1", "ya");
        articles.add(m);
    }

    public List<Map> getArticles() {
        return articles;
    }
}
