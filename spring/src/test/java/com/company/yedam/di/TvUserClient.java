package com.company.yedam.di;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.yedam.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml") //applicationContext.xml방식
//@ContextConfiguration(classes = {AppConfig.class}) //@Configuration @Bean방식 +{AppConfig.class, , }여러개가능
public class TvUserClient {
	@Autowired TV tv;
	@Autowired TV tv2;
	
	//@Test
	public void singleTest() {
		assertEquals(tv, tv2);
	}
	
	@Test
	public void tvtest() {
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}
}
