package com.iu.s3.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s3.account.AccountDTO;
import com.iu.s3.util.Pager_backUp;



@Repository
public class BankBookDAO {
	@Autowired
	private SqlSession sqlSession;//sqlSessionTemplet을 상속하는 sqlSession
	
	private final String NAMESPACE="com.iu.s3.bankbook.BankBookDAO.";//final 상수=>전부 대문자 표기 mapper의 namespace를 적는거임
	
	
	//getList
	//bankbook 테이블의 모든 데이터 조회 후 리턴
	public List<BankBookDTO> getList(Pager_backUp pager) throws Exception{
	
		return sqlSession.selectList(NAMESPACE+"getList", pager);
	}
	
	public long getTotalCount(Pager_backUp pager) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getTotalCount", pager);
	}
	
	
	public BankBookDTO getSelect(BankBookDTO bankBookDTO)throws Exception{
//		long num = 1L;
//		bankBookDTO=sqlSession.selectOne(NAMESPACE+"getSelect", num);//파라미터로 num 변수를 넘기겟다.
		
		return sqlSession.selectOne(NAMESPACE+"getSelect", bankBookDTO);
		
	}
	
	public int setAdd(BankBookDTO bankBookDTO) throws Exception {
		int result = sqlSession.insert(NAMESPACE+"setAdd", bankBookDTO);
		//mapper의 id를 적는다.아하 위치 정보,, namespace안에 있는 아이디명, 넘길 파라미터 정보
		
		return result;
		
	}
	
	public int setDelete(BankBookDTO bankBookDTO)throws Exception{
		return sqlSession.delete(NAMESPACE+"setDelete", bankBookDTO);//int리턴되니까 걍 다이렉트로 넣어버리기
				
	}
	
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setUpdate", bankBookDTO);
	
		
	}
	
	
	
}
