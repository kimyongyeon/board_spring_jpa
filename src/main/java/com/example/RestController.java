package com.example;

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
    BoardService boardService;

    @RequestMapping(value = "/list_proc")
    public List<Board> list() {
        return boardService.findAll();
    }

    @RequestMapping(value = "/insert_proc")
    public void insertBoard(HttpServletRequest request) {

        try {
            Board b = new Board();
            b.setWriter(request.getParameter("w"));
            b.setContent(request.getParameter("c"));
            boardService.save(b);
        } catch (Exception e ) {

        }
    }
}
