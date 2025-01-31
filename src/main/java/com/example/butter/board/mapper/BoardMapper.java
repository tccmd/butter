package com.example.butter.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
// import org.apache.ibatis.annotations.Param;

import com.example.butter.board.dto.BoardDto;
// import com.example.butter.board.dto.BoardFileDto;

@Mapper
public interface BoardMapper {
	List<BoardDto> selectBoardList() throws Exception;
	
	void insertBoard(BoardDto board) throws Exception;

	BoardDto selectBoardDetail(int boardIdx) throws Exception;

	void updateHitCount(int boardIdx) throws Exception;
	
	void updateBoard(BoardDto board) throws Exception;
	
	void deleteBoard(int boardIdx) throws Exception;
}
