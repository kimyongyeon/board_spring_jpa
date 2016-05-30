package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String index(Model model) {

        Board b = new Board();
        b.setContent("내용입니다.");
        b.setTitle("제목입니다.");
        b.setWriter("글쓴이");
        boardService.save(b);

        List<Board> list = boardService.findAll();

        list.forEach(name-> System.out.println(name.getWriter()));

        model.addAttribute("msg", "this is after print ...");

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
