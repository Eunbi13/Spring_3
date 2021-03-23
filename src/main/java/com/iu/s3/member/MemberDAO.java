package com.iu.s3.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //
public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.iu.s3.member.memberDAO.";
	
	public int memberJoin(MemberDTO memberDTO) throws Exception{
		
		
		return sqlSession.insert(NAMESPACE+"memberJoin", memberDTO);
	}
	
	
//
//	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception {
//		
//		String sql = "SELECT * FROM member WHERE id=? and pw=?";
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setString(1, memberDTO.getId());
//		st.setString(2, memberDTO.getPw());
//		
//		ResultSet rs = st.executeQuery();
//		
//		if (rs.next()) {
//			memberDTO.setEmail(rs.getString("email"));
//			memberDTO.setphone(rs.getString("phone"));
//			memberDTO.setName(rs.getString("name"));
//		}else {
//			memberDTO=null;
//		}
//		
//		rs.close();
//		st.close();
//		con.close();
//		
//		return memberDTO;
//	}
}
