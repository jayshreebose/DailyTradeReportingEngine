package com.jpmorgan.DailyTradeReportingApplication.model;

/**
 * Class that stores the currency
 * 
 * @author Jayshree Bose
 *
 */
public interface Currency {

	String USD = "USD";
	String AED = "AED";
	String SAR = "SAR";

	public String getSymbol();

	public void setSymbol(String symbol);

	public int getWeekStart();

	public int getWeekEnds();

	public double getAgreededFx();

	public void setAgreededFx(double agreededFx);
}
