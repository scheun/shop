package com.my.shop.dao.map;

import com.my.shop.model.Board;

import java.util.List;

public interface BoardMap {
    List<Board> listBoard();
    int insertBoard(Board board);
    List<Board> detailBoard(int board_num);
    int deleteBoard(int board_num);
}
