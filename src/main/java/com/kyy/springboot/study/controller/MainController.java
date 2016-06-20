package com.kyy.springboot.study.controller;

import com.kyy.springboot.study.domain.Board;
import com.kyy.springboot.study.service.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 * Created by yongyeonkim on 2016. 5. 29..
 */
@Controller
public class MainController {

    @Autowired
    BoardRepository boardRepository;

    @RequestMapping(value = "/")
    public String index(Model model) {

        Board b = new Board();
        b.setContent("내용입니다.");
        b.setTitle("제목입니다.");
        b.setWriter("글쓴이");
        boardRepository.save(b);

        List<Board> list = boardRepository.findAll();

        list.forEach(name-> System.out.println(name.getWriter()));

        model.addAttribute("msg", "this is after print ...");

        return "index";
    }

    @RequestMapping(value = "highchart")
    public String hichart() {

        return "highchart";
    }


    @RequestMapping(value = "list/{id}")
    public String list(@PathVariable("id") long id) {
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
