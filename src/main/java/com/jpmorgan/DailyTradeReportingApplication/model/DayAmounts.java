package com.jpmorgan.DailyTradeReportingApplication.model;

/**
 * Bean to save the incoming and outgoing data of a day.
 * @author jbose
 *
 */
public class DayAmounts {
	
	//Total amount of income
	private double incoming = 0;
	//Total amount of outgoing value
	private double outgoing = 0;

	public DayAmounts(){
		
	}
	/**
	 * Return incoming value
	 * @return
	 */
	public double getIncoming() {
		return incoming;
	}
	/**
	 * Sets the incoming value as per the trade type
	 * @param incoming
	 */
	public void setIncoming(double incoming) {
		this.incoming = incoming;
	}
	/**
	 * Returns the outgoing value
	 * @return
	 */
	public double getOutgoing() {
		return outgoing;
	}
	/**
	 * Sets the outgoing value as per the trade type
	 * @param outgoing
	 */
	public void setOutgoing(double outgoing) {
		this.outgoing = outgoing;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DayAmounts [incoming=" + incoming + ", outgoing=" + outgoing + "]";
	}
	
	
}
