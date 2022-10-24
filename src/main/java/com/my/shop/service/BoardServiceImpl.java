package com.my.shop.service;

import com.my.shop.dao.map.BoardMap;
import com.my.shop.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired BoardMap boardMap;

    @Override
    public List<Board> listBoard() {
        return boardMap.listBoard();
    }

    @Override
    public int insertBoard(Board board) {
        return boardMap.insertBoard(board);
    }

    @Override
    public List<Board> detailBoard(int board_num) {
        return boardMap.detailBoard(board_num);
    }

    @Override
    public int deleteBoard(int board_num) {
      return boardMap.deleteBoard(board_num);
    }
}
