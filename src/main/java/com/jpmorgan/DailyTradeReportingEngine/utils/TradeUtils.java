package com.jpmorgan.DailyTradeReportingEngine.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
/**
 * Interface to hold the constants for the project
 * @author Jayshree Bose
 *
 */
public interface TradeUtils {
	// comma separator
	static final String CSV = ",";
	// Date format in which the trade dates appear
	final SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy", Locale.ENGLISH);
	// Calendar instance
	Calendar c = Calendar.getInstance();
	String BUY = "B";
	String SELL = "S";
}
