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
public class FixturesPropertyTest {
    @Autowired
    private FixturesProperty fixturesProperty;

    @Test
    public void testGetArticles() {
        List<Article> articles = fixturesProperty.getArticles();
        assertThat(articles.size(), is(3));
    }

    @Test
    public void testGetCommentsByArticle() {
        List<Article> articles = fixturesProperty.getArticles();
        Article article = articles.get(0);
        List<Comment> comments = article.getComments();
        assertThat(comments.size(), is(2));

    }

}
