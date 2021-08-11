package com.test.dao;

import java.util.List;

import com.test.dto.MemberDto;

public interface MemberDao {
	
	String login(MemberDto dto) throws Exception;
	
	void insert(MemberDto dto) throws Exception;
	
	List<MemberDto> selectList();
	
	void update(MemberDto dto);
	
	void delete(MemberDto dto);
}
