package com.test.testserver;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.dao.MemberDao;
import com.test.dto.MemberDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberDaoTest {
	@Autowired
	private MemberDao dao;
	
	@Test
	public void testInsertMember() throws Exception {
		MemberDto dto = new MemberDto();
		dto.setId(null);
		dao.insert(new MemberDto("test","1234","테스트",1000));
	}
	
	@Test
	public void testSelectList() throws Exception {
		dao.selectList();
		
	}
	@Test
	public void testSelectOne() throws Exception{
		dao.login(new MemberDto("test","1234"));
	}
	
}
