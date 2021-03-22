package com.iu.s3;


import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public abstract class MyAbstractTest { //얘네 계속 하기 귀찮으니까 추상클래스로 만들어서 다 줘버리겠다.

	

}
