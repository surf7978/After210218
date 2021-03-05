package com.yedam.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.board.service.CommentsService;
import com.yedam.emp.CommentsVO;

@Service
public class CommentsServiceImpl implements CommentsService {
	
	@Autowired CommentsMapper dao;
	
	public int insertComments(CommentsVO vo) {
		return dao.insertComments(vo);
	}

	public int deleteComments(CommentsVO vo) {
		return dao.deleteComments(vo);
	}

	public CommentsVO getComments(CommentsVO vo) {
		return dao.getComments(vo);
	}

	public List<CommentsVO> getSearchComments(CommentsVO vo) {
		return dao.getSearchComments(vo);
	}

}
