package com.jpmorgan.DailyTradeReportingApplication.model;

/**
 * Class to store the foreign currency
 * 
 * @author Jayshree Bose
 *
 */
public class CurrencyImpl implements Currency {

	/**
	 * Currency symbol
	 */
	private String symbol;
	/**
	 * Start of the week Starts on Monday for all currency except AED and SAR
	 * For AED and SAR week starts on Sunday
	 */
	private int weekStart;
	/**
	 * End of the week Ends on Friday for all currency except AED and SAR For
	 * AED and SAR week ends on Thursday
	 */
	private int weekEnds;
	/**
	 * Foreign exchange rate w.r.t USD
	 */
	private double agreededFx;

	/**
	 * Method that initializes the weekends depending on the currency
	 */
	private void init() {
		int ws = 2;
		int we = 6;
		if (this.symbol.equals(SAR) || this.symbol.equals(AED)) {
			ws = 1;
			we = 5;
		} else if (this.symbol.equals(USD)) {
			ws = 2;
			we = 6;
			// Assumed if the currency is USD the agreededFX is 1
			this.agreededFx = 1;
		} else {
			ws = 2;
			we = 6;
		}
		this.weekStart = ws;
		this.weekEnds = we;
	}

	public CurrencyImpl(String symbol, double agreededFx) {
		this.symbol = symbol;
		this.agreededFx = agreededFx;
		this.init();

	}

	@Override
	public String getSymbol() {

		return this.symbol;
	}

	@Override
	public void setSymbol(String symbol) {

		this.symbol = symbol;
	}

	@Override
	public int getWeekStart() {

		return weekStart;
	}

	@Override
	public int getWeekEnds() {

		return weekEnds;
	}

	@Override
	public double getAgreededFx() {

		return this.agreededFx;
	}

	@Override
	public void setAgreededFx(double agreededFx) {

		// Prevent change in agreededFX if the currency is USD
		if (!this.symbol.equals(USD))
			this.agreededFx = agreededFx;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CurrencyImpl [symbol=" + symbol + "]";
	}

}
