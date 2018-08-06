/**
 * 
 */
package com.jpmorgan.DailyTradeReportingApplication.processor;

import com.jpmorgan.DailyTradeReportingApplication.model.DailyReport;
import com.jpmorgan.DailyTradeReportingApplication.model.Ranking;
import com.jpmorgan.DailyTradeReportingApplication.model.Trade;

/**
 * @author jbose
 *
 */
public interface TradeProcessor {
	void process(Trade trade,Ranking rankingIncoming,Ranking rankingOutgoing,DailyReport dailyReport);
}
