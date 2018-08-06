/**
 * 
 */
package com.jpmorgan.DailyTradeReportingApplication.model;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import com.jpmorgan.DailyTradeReportingEngine.utils.TradeUtils;

/**
 * Bean to store/process trade details
 * @author Jayshree Bose
 *
 */
public class Trade {
	private Entity entity;
	private TradeType tradeType;
	private Double agreedFX;
	private Currency currency;
	private Date instructionDate;
	private Date settlementDate;
	private int units;
	private double pricePerUnit;
	

	/**
	 * @param entity
	 * @param tradeType
	 * @param agreedFX
	 * @param currency
	 * @param instructionDate
	 * @param settlementDate
	 * @param units
	 * @param pricePerUnit
	 * @param c
	 */
	public Trade(String entity, String tradeType, String agreedFX, String currency, String instructionDate,
			String settlementDate, String units, String pricePerUnit) {
		super();
		setEntity(entity);
		setTradeType(tradeType);
		setAgreedFX(agreedFX);
		setAgreedFX(agreedFX);
		setCurrency(currency);
		setInstructionDate(instructionDate);
		setUnits(units);
		setPricePerUnit(pricePerUnit);

	}

	public Trade() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the entity
	 */
	public Entity getEntity() {
		return entity;
	}

	/**
	 * @param entity
	 *            the entity to set
	 */
	public void setEntity(String entity) {
		this.entity = new Entity(entity);
	}

	/**
	 * @return the tradeType
	 */
	public TradeType getTradeType() {
		return this.tradeType;
	}

	/**
	 * @param tradeType
	 *            the tradeType to set
	 */
	public void setTradeType(String tradeType) {
		if (tradeType.equals(TradeUtils.BUY)) {
			this.tradeType = TradeType.BUY_TYPE;
		} else if (tradeType.equals(TradeUtils.SELL)) {
			this.tradeType = TradeType.SELL_TYPE;
		}
	}

	/**
	 * @return the agreedFX
	 */
	public Double getAgreedFX() {
		return agreedFX;
	}

	/**
	 * @param agreedFX
	 *            the agreedFX to set
	 */
	public void setAgreedFX(String agreedFX) {
		this.agreedFX = Double.valueOf(agreedFX);
	}

	/**
	 * @return the currency
	 */
	public Currency getCurrency() {
		return currency;
	}

	/**
	 * @param currency
	 *            the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = new CurrencyImpl(currency, this.agreedFX);
	}

	/**
	 * @return the instructionDate
	 */
	public Date getInstructionDate() {
		return instructionDate;
	}

	/**
	 * @param instructionDate
	 *            the instructionDate to set
	 */
	public void setInstructionDate(String instructionDate) {

		try {
			this.instructionDate = TradeUtils.sdf.parse(instructionDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return the settlementDate
	 */
	public Date getSettlementDate() {
		return settlementDate;
	}

	/**
	 * @param settlementDate
	 *            the settlementDate to set
	 */
	public void setSettlementDate(String settlementDate) {
		try {
			this.settlementDate = TradeUtils.sdf.parse(settlementDate);			
			TradeUtils.c.setTime(this.settlementDate);
			int dayOfWeek = TradeUtils.c.get(Calendar.DAY_OF_WEEK);
			/*
			 * We add 1 day to settlement date until the settlement date not fall in weekend
			 */
			while(!((dayOfWeek>=this.currency.getWeekStart())&&(dayOfWeek<=this.currency.getWeekEnds()))){
				TradeUtils.c.add(Calendar.DATE, 1);
				dayOfWeek = TradeUtils.c.get(Calendar.DAY_OF_WEEK);
			}
			this.settlementDate = TradeUtils.c.getTime();			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the units
	 */
	public int getUnits() {
		return units;
	}

	/**
	 * @param units
	 *            the units to set
	 */
	public void setUnits(String units) {
		this.units = Integer.parseInt(units);
	}

	/**
	 * @return the pricePerUnit
	 */
	public double getPricePerUnit() {
		return pricePerUnit;
	}

	/**
	 * @param pricePerUnit
	 *            the pricePerUnit to set
	 */
	public void setPricePerUnit(String pricePerUnit) {
		this.pricePerUnit = Double.parseDouble(pricePerUnit);
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Trade [entity=" + entity + ", tradeType=" + tradeType + ", agreedFX=" + agreedFX + ", currency="
				+ currency + ", instructionDate=" + instructionDate + ", settlementDate=" + settlementDate + ", units="
				+ units + ", pricePerUnit=" + pricePerUnit + "]";
	}

}
