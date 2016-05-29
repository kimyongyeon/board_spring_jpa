package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by yongyeonkim on 2016. 5. 29..
 */
@Controller
public class MainController {

    @Autowired
    BoardService boardService;

    @RequestMapping(value = "/")
    public String index() {
        Board b = new Board();
        b.setContents("나는 누구인가...");
        b.setWriter("글쓴이");
        boardService.save(b);
        List<Board> list = boardService.findAll();

        list.forEach(name-> System.out.println(name.getWriter()));

        return "index";
    }

    @RequestMapping(value = "list")
    public String list() {
        return "board_list";
    }
    @RequestMapping(value = "form")
    public String form() {
        return "board_form";
    }
    @RequestMapping(value = "detail")
    public String detail() {
        return "board_detail";
    }


}
