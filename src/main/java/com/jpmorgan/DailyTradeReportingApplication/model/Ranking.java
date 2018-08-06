package com.jpmorgan.DailyTradeReportingApplication.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to store the ranking of the entity
 * 
 * @author Jayshree Bose
 *
 */
public class Ranking {

	/**
	 * Map to hold the entity and the amount
	 */
	private Map<String, Double> map;

	private String name;

	/**
	 * Constructor
	 * 
	 * @param name
	 */
	public Ranking(String name) {
		this.name = name;
		this.map = new HashMap<String, Double>();
	}

	/**
	 * Method to add the amount
	 * 
	 * @param ent
	 * @param amount
	 */
	public void addAmount(Entity ent, double amount) {
		String entName = ent.getName().toLowerCase();

		if (!this.map.containsKey(entName)) {
			this.map.put(entName, 0.0);
		}
		amount = this.map.get(entName) + amount;
		this.map.replace(entName, amount);
	}

	/**
	 * Print the ranking of the entities
	 */
	public void printRanking() {
		System.out.println(this.name);
		this.map.entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed()).limit(10)
				.forEach(System.out::println);
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

}
