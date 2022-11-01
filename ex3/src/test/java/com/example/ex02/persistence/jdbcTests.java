package com.example.ex02.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class jdbcTests {
	
	static { //먼저 클래스를 메모리에 올린다
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//이렇게하면 해당 드라이버는 메모리에 올라갈것이다.
	
	@Test
	public void testConnection() {
		//트라이문 괄호안에다가 커넥션을 넣게되면 close를 사용하지않아도 자동적으로 꺼지게된다
		 try(Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr")){
			 log.info(connection);
		 }catch(Exception e) {
			 //JUnit의 메서드로서, 무조건 실패로 처리한 뒤 실행을 중지한다.
			 fail(e.getMessage()); 
		 }
	}
}

//히카리컨피규를 통해서 db커넥션풀을 사용할수 인다
//JNDI를 사용해서 커넥션객체를 넣기위해서 데이터 소를 넣기위해서 사용해서 인터페이스를 사용해서 해당경로를 찾아가서 객체로 가져오는것을 말한다
