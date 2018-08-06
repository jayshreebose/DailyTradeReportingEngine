package com.jpmorgan.DailyTradeReportingEngine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.jpmorgan.DailyTradeReportingApplication.service.TradeService;
/**
 *  This class is the entry point of the Spring Boot Application
 * @author Jayshree Bose
 *
 */
@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class DailyTradeReportingEngineApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DailyTradeReportingEngineApplication.class, args);
		// Get the service bean
		TradeService service = (TradeService) ctx.getBean("service");
		// generates the trade report
		service.generateReports();
	}
}
