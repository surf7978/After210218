package com.yedam.board.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.board.service.CommentsService;
import com.yedam.emp.CommentsVO;

@RestController  //@RestController 모든 메소드 ajax로 호출 메소드별로하고싶으면 각 메소드에 @ResponseBody 넣으면됨
public class CommentsController {
	
	@Autowired CommentsService commentsService;
	
	//등록처리
	@PostMapping("/comments")
	public CommentsVO insertCommentsProc(@RequestBody CommentsVO vo) {
		commentsService.insertComments(vo);
		if(vo.getId().equals("0")) {
			return vo;
		}else {
			return commentsService.getComments(vo);
		}
	}
	//삭제
	@DeleteMapping(value = "/comments")// /{id}") //@PostMapping에 (value = "/comments/{id}", method=RequestMethod.DELETE) 이렇게해도됨
	public Map<String, Integer> deleteCommentsProc(@RequestBody CommentsVO vo){//,@PathVariable String id) {
		int r = commentsService.deleteComments(vo);
		return Collections.singletonMap("cnt",r);
	}
	//게시글의 댓글조회
	@GetMapping("/comments")
	public List<CommentsVO> getSearchComments(CommentsVO vo) {
		return commentsService.getSearchComments(vo);
	}
	//수정처리
	@PutMapping("/comments")
	public CommentsVO updateCommentsProc(@RequestBody CommentsVO vo) {
		System.out.println("수정 : "+vo);
		return vo;
	}
	//단건조회
	@GetMapping("/comments/{id}")
	public CommentsVO getComments(CommentsVO vo, @PathVariable String id ) {
		vo.setId(id);
		return commentsService.getComments(vo);
	}
}
