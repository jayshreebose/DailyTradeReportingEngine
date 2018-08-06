package com.jpmorgan.DailyTradeReportingEngine;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;

import com.jpmorgan.DailyTradeReportingApplication.service.TradeService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ImportResource("classpath:applicationContext.xml")
public class DailyTradeReportingEngineApplicationTests {

	@Test
	public void contextLoads() {
		ApplicationContext ctx = SpringApplication.run(DailyTradeReportingEngineApplicationTests.class);
		TradeService service = (TradeService) ctx.getBean("service");
		service.generateReports();
	}

}
