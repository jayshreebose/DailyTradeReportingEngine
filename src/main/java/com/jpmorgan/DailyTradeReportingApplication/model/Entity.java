package com.jpmorgan.DailyTradeReportingApplication.model;

/**
 * Bean to store the entity
 * @author Jayshree Bose
 *
 */
public class Entity {
	/**
	 * Entity name
	 */
	private String name;

	/**
	 * @param name
	 */
	public Entity(String name) {
		super();
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Entity [name=" + name + "]";
	}

}
