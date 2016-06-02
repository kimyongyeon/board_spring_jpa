package com.kyy.springboot.study.controller;

import com.kyy.springboot.study.domain.Board;
import com.kyy.springboot.study.service.repository.BoardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yongyeonkim on 2016. 5. 30..
 */
@Controller
@RequestMapping("/board/*")
public class BoardController {

    public static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    BoardRepository boardRepository;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void regsiterGET(Board board, Model model) throws Exception {
        logger.info("register get....");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String regsiterPOST(Board board, Model model) throws Exception {
        logger.info("register post....");
        logger.info(board.toString());

        boardRepository.save(board);

        model.addAttribute("result", "success");

        return "/redirect:/board/listAll";
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public void listAll(Model model) throws Exception {
        logger.info("show all list....");

    }
}
