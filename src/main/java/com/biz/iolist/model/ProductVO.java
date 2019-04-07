package com.biz.iolist.model;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//p_code	CHAR(13)		PRIMARY KEY,
//p_name	nVARCHAR2(50)	NOT NULL	,
//p_tax	char(1)		DEFAULT '1', -- 입력하지않으면 1로하겠다
//p_iprice	NUMBER		,
//p_oprice	NUMBER	

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductVO {
	
	private String p_code;
	private String p_name;
	private String p_tax;
	private int p_iprice;
	private int p_oprice;
	
}
