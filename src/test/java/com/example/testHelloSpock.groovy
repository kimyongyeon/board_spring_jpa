package com.example

import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import spock.lang.Specification

import javax.annotation.Resource

/**
 * Created by yongyeonkim on 2016. 5. 29..
 */
class testHelloSpock extends Specification{

    def "test for SayHello"() {
        given:
        def helloSpock = new HelloSpock()

        when:
        def expected = helloSpock.sayHello("world")

        then:
        expected == "Hello world"

    }
}
