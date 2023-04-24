package com.spring.mvc.chap05.repository;

import com.spring.mvc.chap05.entity.Board;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

@Repository
public class BoardRepositoryImpl
        implements BoardRepository {

    private final static Map<Integer, Board> boardMap;
    private static int sequence;

    static {
        boardMap = new HashMap<>();
        Board b1 = new Board(++sequence, "원피스", "루피");
        Board b2 = new Board(++sequence, "나루토", "나루토");
        Board b3 = new Board(++sequence, "블리치", "이치고");
        boardMap.put(b1.getBoardNo(), b1);
        boardMap.put(b2.getBoardNo(), b2);
        boardMap.put(b3.getBoardNo(), b3);
    }

    @Override
    public List<Board> findAll() {
        return boardMap.values()
                .stream()
                .sorted(comparing(Board::getBoardNo).reversed())
                .collect(toList())
                ;
    }

    @Override
    public Board findOne(int boardNo) {
        return boardMap.get(boardNo);
    }

    @Override
    public boolean save(Board board) {
        board.setBoardNo(++sequence);
        boardMap.put(board.getBoardNo(), board);
        return true;
    }

    @Override
    public boolean deleteByNo(int boardNo) {
        boardMap.remove(boardNo);
        return true;
    }
}