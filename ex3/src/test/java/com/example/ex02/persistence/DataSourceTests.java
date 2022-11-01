package com.example.ex02.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests {
	@Autowired
	private DataSource dataSource;
	
	@Autowired//세션 팩토리까지 주입을 받아야되기때문에 넣어주기
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testConnection() {
		
		try
		(
			SqlSession sqlSession = sqlSessionFactory.openSession(true);//true 오토 커밋을 하기위해서
			Connection connection = sqlSession.getConnection();	
		){
			log.info(sqlSession);
			log.info(connection);
		}catch(Exception e) {
			fail(e.getMessage());
		}//매퍼 쪽에서 기본적인 세팅은 완료가 되었다 이제부터 파일 경로 설정 아키 택처 부분 건드릴꺼야
		//interface - 자바쪽 xml sql 작성하게된다 xml->interface를  매퍼
		
//		try(Connection connection = dataSource.getConnection()){
//			log.info(connection);
//		} catch (Exception e) {
//			fail(e.getMessage());
//		}
	}
}
