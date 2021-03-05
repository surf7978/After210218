package com.yedam.board.service;

import java.util.List;

import com.yedam.emp.CommentsVO;

public interface CommentsService {
	int insertComments(CommentsVO vo);
	int deleteComments(CommentsVO vo);
	CommentsVO getComments(CommentsVO vo);
	List<CommentsVO> getSearchComments(CommentsVO vo);
}
