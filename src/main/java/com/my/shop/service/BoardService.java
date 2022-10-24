package com.my.shop.service;

import com.my.shop.model.Board;

import java.util.List;

public interface BoardService {
    List<Board> listBoard();
    int insertBoard(Board board);
    List<Board> detailBoard(int board_num);
    int deleteBoard(int board_num);
}
