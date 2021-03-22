package com.iu.s3;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ConnectionTest extends MyAbstractTest{
	
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void connectionTest() throws Exception {
		assertNotNull(dataSource.getConnection());
	}

	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void sqlTest() throws Exception{
		assertNotNull(sqlSession);//우리가 만드는 클래스가 아니고 DB-sql을 쓰는 친구라서 DML같은 언어를 씀 그래서 gettersetter가 없음
	}
}
