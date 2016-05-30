package com.example

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.IntegrationTest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import sun.security.util.ByteArrayTagOrder

import java.lang.invoke.MethodHandleImpl

/**
 * Created by yongyeonkim on 2016. 5. 30..
 */
@IntegrationTest
@ContextConfiguration(classes = [TestAppConfig])
class FixturesPropertyTest extends Specification{

    @Autowired
    BoardService boardService

    def "test for SayHello"() {
        setup:
        def b = new Board(title: "title ....", writer: "writer man")

        when:
        boardService.save(b)
        def list = boardService.findAll()
        def expected = list.size()

        then:
        expected == 3

    }

}
