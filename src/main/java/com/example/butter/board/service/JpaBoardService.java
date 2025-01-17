package com.example.butter.board.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.butter.board.entity.BoardEntity;

public interface JpaBoardService {

	List<BoardEntity> selectBoardList() throws Exception;

	void saveBoard(BoardEntity board) throws Exception;
	
	BoardEntity selectBoardDetail(int boardIdx) throws Exception;

	void deleteBoard(int boardIdx);
}
