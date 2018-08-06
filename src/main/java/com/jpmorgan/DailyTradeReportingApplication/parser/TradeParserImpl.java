package com.jpmorgan.DailyTradeReportingApplication.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.jpmorgan.DailyTradeReportingApplication.model.Trade;
import com.jpmorgan.DailyTradeReportingEngine.utils.TradeUtils;

/**
 * This class implements the TradeParser. It processes the file that stores the
 * trade details
 * 
 * @author Jayshree Bose
 *
 */
public class TradeParserImpl implements TradeParser {

	@Override
	public List<Trade> parse(File filePath) {
		// object to store the trades
		List<Trade> listOfTrade = new ArrayList<Trade>();

		InputStream inputStream;
		BufferedReader br = null;
		try {
			if (filePath.exists()) {

				inputStream = new FileInputStream(filePath);
				br = new BufferedReader(new InputStreamReader(inputStream));

				// Use of Java 8 Stream API to process the csv file.
				// A simple way can be used as this file is not huge currently
				// but the usage of
				// new features of JAVA is showcased.This is used in case the
				// incoming file is huge in size
				listOfTrade = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());

				br.close();
			} else {
				System.out.println(" No such file in :s" + filePath);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		return listOfTrade;
	}

	/**
	 * Function to process the trade objects Used Java 8 Lambda Expressions to
	 * process the data
	 */
	private Function<String, Trade> mapToItem = (line) -> {
		// Comma separated values
		String[] tradeObject = line.split(TradeUtils.CSV);
		Trade trade = new Trade();
		trade.setEntity(tradeObject[0].trim().toLowerCase());
		trade.setTradeType(tradeObject[1].trim());
		trade.setAgreedFX(tradeObject[2].trim());
		trade.setCurrency(tradeObject[3].trim());
		trade.setInstructionDate(tradeObject[4].trim());
		trade.setSettlementDate(tradeObject[5].trim());
		trade.setUnits(tradeObject[6].trim());
		trade.setPricePerUnit(tradeObject[7].trim());
		return trade;
	};

}
