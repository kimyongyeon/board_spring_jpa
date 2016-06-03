package com.kyy.springboot.study

import spock.lang.Specification

/**
 * Created by yongyeonkim on 2016. 5. 29..
 */
class testHelloSpock extends Specification{

    def "test for SayHello"() {
        given:
        def helloSpock = new HelloSpock()
        def ROOT = BoardSpringJpaStudyApplication.ROOT
        System.out.println("운영체제 종류: " + System.getProperty("os.name") );


        when:
        def expected = helloSpock.sayHello("world")
        def osName = System.getProperty("os.name")

        if(osName.contains("Windows")) {
            System.out.println("W: " + System.getProperty("os.name") );
        } else {
            System.out.println("U: " + System.getProperty("os.name") );
        }


        then:
        expected == "Hello world"


    }

}
