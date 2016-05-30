package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertThat;
import static sun.nio.cs.Surrogate.is;

/**
 * Created by yongyeonkim on 2016. 5. 30..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BoardSpringJpaStudyApplication.class)
public class FixturesPropertyTest3 {
    @Autowired
    private FixturesProperty fixturesProperty;

    @Test
    public void testGetArticles() {
        List<Map> articles = fixturesProperty.getArticles();

        //assertThat(articles.size(), is(3));
    }

}