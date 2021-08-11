package com.test.service;

import java.util.List;

import com.test.dto.MemberDto;


public interface MemberService {
	
	public String login(MemberDto dto) throws Exception;
	
	void insert(MemberDto dto) throws Exception;
	
	List<MemberDto> selectList();
	
	void update(MemberDto dto);
	
	void delete(MemberDto dto);
}



