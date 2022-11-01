package com.example.ex02.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/*
 * Mapper 인터페이스
 * 
 * Mapper를 작성하는 작업은 xml을 이용할수 있지만, 최소한 코드를 작성하기위해서
 *  Mapper 인터페이스를 사용한다
 * 
 * */
@Mapper // 꼭 적어줘야지만 익식을 하게된다 
public interface TimeMapper {
	
	@Select("SELECT SYSDATE FROM DUAL")
	public String getTime();
	//이렇게 되면 XML을 만들지 않아도 바로 쿼리를 실행할수 있따 연결된 스키마에서
	//한마디로 짧은 것은 여기 이용하고 길고 복잡한것은 XML을 이용하라는 뜻이다 
	
	
	public String getTime2();
	//root-context.xml에  -> Namespaces -> mybatis-spring을 설정에 클릭을해야지만 스캔을 해서 사용할수있다
}
