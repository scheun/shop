package com.my.shop.controller;

import com.my.shop.model.Board;
import com.my.shop.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BoardController {

    @Autowired BoardService boardService;

    @GetMapping("/board/insertBoard")
    public String insertBoard() {
        return "board/insertBoard";
    }

    @PostMapping("/insertBoard")
    @ResponseBody
    public int insert(Board board, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String id = session.getAttribute("id").toString();
        board.setId(id);
        return boardService.insertBoard(board);
    }

    @GetMapping("/board/listBoard")
    public String listBoard(Model model) {
        List<Board> board = boardService.listBoard();
        model.addAttribute("board", board);
        return "board/listBoard";
    }

    @GetMapping("/board/detailBoard")
    public String detailBoard(Model model, int board_num) {
        List<Board> board = boardService.detailBoard(board_num);
        model.addAttribute("board", board);
        return "board/detailBoard";
    }

    @ResponseBody
    @DeleteMapping("/deleteBoard/{board_num}")
    public void deleteBoard(@PathVariable int board_num) {
        boardService.deleteBoard(board_num);
    }
}
