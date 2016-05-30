package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by yongyeonkim on 2016. 5. 30..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BoardSpringJpaStudyApplication.class)
public class ServerPropertyTest {
    @Autowired
    private ServerHolder serverHolder;

    @Test
    public void testGetArticles() {
        System.out.println(serverHolder.getServers());
    }

}
