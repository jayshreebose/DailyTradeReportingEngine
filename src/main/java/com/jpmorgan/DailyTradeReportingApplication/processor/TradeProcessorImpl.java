package com.jpmorgan.DailyTradeReportingApplication.processor;

import java.util.Date;

import com.jpmorgan.DailyTradeReportingApplication.model.DailyReport;
import com.jpmorgan.DailyTradeReportingApplication.model.Entity;
import com.jpmorgan.DailyTradeReportingApplication.model.Ranking;
import com.jpmorgan.DailyTradeReportingApplication.model.Trade;
import com.jpmorgan.DailyTradeReportingApplication.model.TradeType;

/**
 * This class processes all the incoming and outging trade
 * @author Jayshree Bose
 *
 */
public class TradeProcessorImpl implements TradeProcessor {
	
	@Override
	public void process(Trade trade,Ranking incoming,Ranking outgoing,DailyReport dailyReport) {
		// TODO Auto-generated method stub
    	Double amount = trade.getPricePerUnit()*trade.getUnits()*trade.getCurrency().getAgreededFx();
    	Date settlementDate = trade.getSettlementDate();
    	Entity entity = trade.getEntity();
    	// In case when the trade type "BUY", add it to the outgoing trade
    	// else add to the incoming trade
    	if(trade.getTradeType().equals(TradeType.BUY_TYPE)){
    		// Sets the map for the daily incoming/outgoing trade
    		dailyReport.addOutgoing(settlementDate,amount);
    		//Sets the entity amount
    		outgoing.addAmount(entity, amount);
    	}else if(trade.getTradeType().equals(TradeType.SELL_TYPE)){
    		// Sets the map for the daily incoming/outgoing trade
    		dailyReport.addIncoming(settlementDate,amount);
    		//Sets the entity amount
    		incoming.addAmount(entity, amount);
    	}
	}

}
