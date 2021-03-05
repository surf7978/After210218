package com.yedam.board.service.impl;

import java.util.List;

import com.yedam.emp.CommentsVO;

public interface CommentsMapper {
	public int insertComments(CommentsVO vo);
	public int deleteComments(CommentsVO vo);
	public CommentsVO getComments(CommentsVO vo);
	public List<CommentsVO> getSearchComments(CommentsVO vo);
}
