package com.kyy.springboot.study

import com.kyy.springboot.study.domain.Board
import com.kyy.springboot.study.config.FixturesProperty
import com.kyy.springboot.study.service.repository.BoardRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.IntegrationTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Created by yongyeonkim on 2016. 5. 30..
 */
@IntegrationTest
@ContextConfiguration(classes = [TestAppConfig])
class testBoardService extends Specification{

    @Autowired
    BoardRepository boardService

    def "게시판에 내용을 저장합니다"() {
        setup:
        FixturesProperty fixturesProperty = new FixturesProperty()
        def b = new Board(title: "title ....", writer: "writer man")

        when:
        fixturesProperty.getArticles().size()
        boardService.save(b)
        def list = boardService.findAll()
        def expected = list.size()

        then:
        expected == 3

    }

    def "게시판에 내용을 출력합니다"() {
        given:
        print("설정")
        when:
        print("처리")
        then:
        print("결과")
    }

    def "게시판에 내용을 삭제합니다."() {
        given:
        print("설정")
        when:
        print("처리")
        then:
        print("결과")
    }

    def "게시판에 내용을 수정합니다."() {
        given:
        print("설정")
        when:
        print("처리")
        then:
        print("결과")
    }

    def "게시판 페이징 처리"() {
        given:
        print("설정")
        when:
        print("처리")
        then:
        print("결과")
    }



}
