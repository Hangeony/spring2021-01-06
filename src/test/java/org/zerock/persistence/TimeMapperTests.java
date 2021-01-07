package org.zerock.persistence;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.TimeMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTests {
	@Setter(onMethod_= @Autowired)
	private TimeMapper timeMapper;

	@Test
	public void testGetTime() {
		
		assertNotNull(timeMapper);//값이 잘들어왔는지 
		
		log.info("┌----------------------┐");
		log.info(timeMapper.getClass().getName()); // 클레스이름이랑 클래스가 잘들어갔는지 확인
		log.info("├----------------------┤");
		
		log.info(timeMapper.getTime()); //getTime메소드가 실제로 실행되는지 확인
	
	}
	@Test
	public void testGetTime2() {
		
		assertNotNull(timeMapper.getTime2());
		log.info("├----------------------┤");
		log.info(timeMapper.getTime2());
		log.info("└----------------------┘");
	}

}
