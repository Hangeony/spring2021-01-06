package org.zerock.sample;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTests {
	
	@Autowired
	private ApplicationContext context;
	//context 객체를 만들거나 이xml파일을 사용하라고 명시해두지 않아도 된다.
	
	@Setter(onMethod_ = {@Autowired})
	private Restaurant restaurant;
	
	
	public void testExist() {
		assertNotNull(restaurant);
		
		log.info(restaurant);
		log.info("----------");
		log.info(restaurant.getChef());
	}
	
	
	@Test
	public void testExist2() {
		Chef c1 = (Chef) context.getBean("chef");
		Restaurant r1 = (Restaurant) context.getBean("restaurant");
		
//		assertNull(r1.getChef()); restaurant의 @Autowired을 안써서 값이 없어 참인 결과값이 나온다
		assertNotNull(r1.getChef()); //@Autowired의 값이 들어갔는지 확인
		assertEquals(c1, r1.getChef()); //두개의 값이 똑같은지 확인
		
		log.info("------");
		assertNotNull(context);
		assertNotNull(context.getBean("chef"));
		assertNotNull(context.getBean("restaurant"));
	}
	
}
