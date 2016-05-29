package com.example

import spock.lang.Specification

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
