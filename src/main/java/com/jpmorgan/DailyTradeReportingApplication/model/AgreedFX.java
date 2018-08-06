package com.jpmorgan.DailyTradeReportingApplication.model;

/**
 * Class that maintains the foreign exchange rate with respect to USDs
 * @author Jayshree Bose
 *
 */
public class AgreedFX {
	String agreedFx;

	/**
	 * @param agreedFx
	 */
	public AgreedFX(String agreedFx) {
		super();
		this.agreedFx = agreedFx;
	}

	/**
	 * Fetches the agreedFX
	 * @return the agreedFx
	 */
	public String getAgreedFx() {
		return agreedFx;
	}

	/**
	 * @param agreedFx
	 *            the agreedFx to set
	 */
	public void setAgreedFx(String agreedFx) {
		this.agreedFx = agreedFx;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AgreedFX [agreedFx=" + agreedFx + "]";
	}

}
