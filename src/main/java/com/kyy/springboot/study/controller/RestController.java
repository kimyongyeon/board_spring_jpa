package com.kyy.springboot.study.controller;

import com.kyy.springboot.study.domain.Board;
import com.kyy.springboot.study.service.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yongyeonkim on 2016. 5. 29..
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    BoardRepository boardRepository;

    @RequestMapping(value = "/list_proc")
    public List<Board> list() {
        return boardRepository.findAll();
    }

    @RequestMapping(value = "/insert_proc")
    public void insertBoard(HttpServletRequest request) {

        try {
            Board b = new Board();
            b.setWriter(request.getParameter("w"));
            b.setContent(request.getParameter("c"));
            boardRepository.save(b);
        } catch (Exception e ) {

        }
    }
}
