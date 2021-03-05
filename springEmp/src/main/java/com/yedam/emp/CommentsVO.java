package com.yedam.emp;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class CommentsVO {
	private String id; //int 9자리 long 13자리 BigDecimal 38자리 
	private String name;
	private String content;
	private String board_id;
	private String out_msg;
	@JsonIgnore private String[] ids;
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	private Date wdate;
}
