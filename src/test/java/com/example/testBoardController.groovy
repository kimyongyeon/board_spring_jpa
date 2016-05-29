package com.example

import spock.lang.Specification

/**
 * Created by yongyeonkim on 2016. 5. 29..
 */
class testBoardController extends Specification{
    def "정상적인 사용자 정보를 로딩할 때 반환된 객체 타입과 정보 확인"() {

        given:
        def name = "kimyongyeon"
        def service = BoardService

        when:
        def mockUserRepo = Mock(BoardService)

        then:
        service.name == name

    }
}
