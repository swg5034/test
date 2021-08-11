package com.test.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public String login(MemberDto dto) throws Exception {
		System.out.println("!!!!!!!!!!!!!!!!!!");
		System.out.println("id : " + dto.getId());
		System.out.println("pw : " + dto.getPw());
		String name = sqlSession.selectOne("com.test.mapper.MemberMapper.login",dto);
		return name;
	}
	
	@Override
	public void insert(MemberDto dto) throws Exception {
		sqlSession.insert("com.test.mapper.MemberMapper.insertMember",dto);
	}

	@Override
	public List<MemberDto> selectList() {
		@SuppressWarnings("unused")
		List<MemberDto> list = new ArrayList<>();
		list = sqlSession.selectList("com.test.mapper.MemberMapper.selectList");
		for(MemberDto dto : list) {
			System.out.println(dto.getId()+ " " + dto.getName()+" "+dto.getPoint()+" "+dto.getPw());
		}
		return sqlSession.selectList("com.test.mapper.MemberMapper.selectList");
	}

	@Override
	public void update(MemberDto dto) {
		sqlSession.update("com.test.mapper.MemberMapper.updateMember",dto);
	}

	@Override
	public void delete(MemberDto dto) {
		sqlSession.delete("com.test.mapper.MemberMapper.deleteMember",dto);
	}


}
