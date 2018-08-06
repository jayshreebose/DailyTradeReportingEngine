/**
 * 
 */
package com.jpmorgan.DailyTradeReportingApplication.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import com.jpmorgan.DailyTradeReportingEngine.utils.TradeUtils;

/**
 * This class holds the calculation Logic for the generation of daily report
 * 
 * @author Jayshree Bose
 *
 */
public class DailyReport {
	// Map of dates and DayAmounts
	private Map<String, DayAmounts> map;
	// SimpleDateFormat to save the dates of trades as Strings that can be
	// sorted
	// private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",
	// Locale.ENGLISH);

	public DailyReport() {
		map = new HashMap<String, DayAmounts>();
	}

	/**
	 * Add the amount of a trade to the incoming amount of a day
	 * 
	 * @param date
	 *            Date - The date of trade
	 * @param incoming
	 *            Double - The amount of trade
	 */
	public void addIncoming(Date date, double incoming) {
		String settlementDate = TradeUtils.sdf.format(date);

		if (!this.map.containsKey(settlementDate)) {
			this.map.put(settlementDate, new DayAmounts());
		}
		incoming = this.map.get(settlementDate).getIncoming() + incoming;
		this.map.get(settlementDate).setIncoming(incoming);
	}

	/**
	 * Add the amount of a trade to the outgoing amount of a day
	 * 
	 * @param date
	 *            Date - The date of trade
	 * @param outgoing
	 *            Double - The amount of trade
	 */
	public void addOutgoing(Date date, double outgoing) {
		String settlementDate = TradeUtils.sdf.format(date);
		if (!this.map.containsKey(settlementDate)) {
			this.map.put(settlementDate, new DayAmounts());
		}
		outgoing = this.map.get(settlementDate).getOutgoing() + outgoing;
		this.map.get(settlementDate).setOutgoing(outgoing);

	}

	/**
	 * Method that prints the daily report of the data stored in the Map
	 */
	public void printDailyReport() {
		SortedSet<String> keys = new TreeSet<String>(this.map.keySet());
		for (String key : keys) {
			System.out.println(key + " Incoming: " + this.map.get(key).getIncoming() + " Outgoing: "
					+ this.map.get(key).getOutgoing());
		}
	}

}
