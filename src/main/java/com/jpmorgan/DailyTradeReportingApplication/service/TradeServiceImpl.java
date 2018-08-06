package com.jpmorgan.DailyTradeReportingApplication.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jpmorgan.DailyTradeReportingApplication.model.DailyReport;
import com.jpmorgan.DailyTradeReportingApplication.model.Ranking;
import com.jpmorgan.DailyTradeReportingApplication.model.Trade;
import com.jpmorgan.DailyTradeReportingApplication.parser.TradeParser;
import com.jpmorgan.DailyTradeReportingApplication.processor.TradeProcessor;

/**
 * Service class which services the report generation
 * @author Jayshree Bose
 *
 */
@Service
public class TradeServiceImpl implements TradeService {
	/**
	 * Parses the trade data from the file
	 */
	TradeParser parser;
	/**
	 * Processes the trade data
	 */
	TradeProcessor processor;
	/**
	 * Generate daily report
	 */
	DailyReport dailyReport;
	/**
	 * incoming value
	 */
	Ranking rankingIncoming;
	/**
	 * outgoing value
	 */
	Ranking rankingOutgoing;
	/**
	 * File which holds the trading details
	 */
	@Value("${fileName}")
	File file;

	List<Trade> tradeList = new ArrayList<Trade>();
	/**
	 * This method generate the trading report from the trade raw data
	 */
	@Override
	public void generateReports() {
		// Parse the file and extract the trade information
		tradeList = parser.parse(file);
		// Total number of trades printed
		// Enable the below statement in case the number of trade details read is to be informed/used
		//System.out.println(" Total trade records read is : "+tradeList.size());
		
		// Process each trade
		for(Trade trade: tradeList){
			processor.process(trade,rankingIncoming,rankingOutgoing,dailyReport);
		}
		// Generate a report
		dailyReport.printDailyReport();
		rankingIncoming.printRanking();
		rankingOutgoing.printRanking();
	}

	/**
	 * @return the parser
	 */
	public TradeParser getParser() {
		return parser;
	}

	/**
	 * @param parser the parser to set
	 */
	public void setParser(TradeParser parser) {
		this.parser = parser;
	}

	/**
	 * @return the processor
	 */
	public TradeProcessor getProcessor() {
		return processor;
	}

	/**
	 * @param processor the processor to set
	 */
	public void setProcessor(TradeProcessor processor) {
		this.processor = processor;
	}

	/**
	 * @return the dailyReport
	 */
	public DailyReport getDailyReport() {
		return dailyReport;
	}

	/**
	 * @param dailyReport the dailyReport to set
	 */
	public void setDailyReport(DailyReport dailyReport) {
		this.dailyReport = dailyReport;
	}

	/**
	 * @return the rankingIncoming
	 */
	public Ranking getRankingIncoming() {
		return rankingIncoming;
	}

	/**
	 * @param rankingIncoming the rankingIncoming to set
	 */
	public void setRankingIncoming(Ranking rankingIncoming) {
		this.rankingIncoming = rankingIncoming;
	}

	/**
	 * @return the rankingOutgoing
	 */
	public Ranking getRankingOutgoing() {
		return rankingOutgoing;
	}

	/**
	 * @param rankingOutgoing the rankingOutgoing to set
	 */
	public void setRankingOutgoing(Ranking rankingOutgoing) {
		this.rankingOutgoing = rankingOutgoing;
	}
	
	
}
