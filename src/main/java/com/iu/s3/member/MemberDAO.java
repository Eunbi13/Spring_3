package com.iu.s3.member;



import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.iu.s3.member.MemberDAO.";
	
	public int memberJoin(MemberDTO memberDTO) throws Exception{
		
		
		return sqlSession.insert(NAMESPACE+"memberJoin", memberDTO);
	}
	
	

	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception {
		
		String sql = "SELECT * FROM member WHERE id=? and pw=?";
		
		
		return memberDTO;
	}
}
