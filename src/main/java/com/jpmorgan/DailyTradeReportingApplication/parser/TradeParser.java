/**
 * 
 */
package com.jpmorgan.DailyTradeReportingApplication.parser;

import java.io.File;
import java.util.List;

import com.jpmorgan.DailyTradeReportingApplication.model.Trade;

/**
 * Interface to parse the file that contains the trade details
 * 
 * @author Jayshree Bose
 *
 */
public interface TradeParser {
	List<Trade> parse(File filePath);
}
