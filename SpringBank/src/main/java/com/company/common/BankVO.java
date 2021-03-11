package com.company.common;

import lombok.Data;

@Data
public class BankVO {
	String api_tran_id;
	String fintech_use_num;
	String api_tran_dtm;
	String rsp_code;
	String rsp_message;
	String user_name;
	String res_cnt;
	String res_list;
	String account_alias;
	String bank_code_std;
	String bank_code_sub;
	String bank_name;
	
	String access_token;
}
