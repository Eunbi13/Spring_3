package com.iu.s3.user01;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Component;
@Component
public class User01Login {

	public Connection user01Login() throws Exception{
		String user = "user01";
		String password = "user01";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}
	
	
}
