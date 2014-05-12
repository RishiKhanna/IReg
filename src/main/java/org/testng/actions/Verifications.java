package org.testng.actions;

import org.apache.log4j.Logger;
import org.testng.utilities.Logg;

public class Verifications {

	private final Logger log = Logg.createLogger();

	public boolean compareExactText(String actual, String expected) {
		log.info("Actual Value=" + actual + " Expected Value=" + expected);
		log.info("Result of exact comparison is " + actual.equals(expected));
		return actual.equals(expected);
	}

	public boolean comparePartialText(String actual, String expected) {
		log.info("Actual Value=" + actual + " Expected Value=" + expected);
		log.info("Result of partial comparison is " + actual.contains(expected));
		return actual.contains(expected);
	}

	public boolean compareMultipleText(String excelArray[][], String webElementArray[],
			int... index) {
		int column = 0;

		if (index.length == 0) {
			index[0] = 0;
			column = webElementArray.length;
		} else if (index.length == 1 && index[0] < webElementArray.length) {
			column = webElementArray.length;
		} else if (index.length == 2 && index[1] < webElementArray.length && index[0] < index[1]) {
			column = index[1];
		}

		log.info("Length of index is " + index.length);
		for (int i = 0; i < excelArray.length; i++) {
			for (int j = index[0]; j < column; j++) {
				if (!(excelArray[i][j].equals(webElementArray[j]))) {
					log.info("Value from Test Data sheet " + excelArray[i][j]);
					log.info("Value from the application " + webElementArray[j]);
					log.info("Returning False");
					return false;
				} else {
					log.info("Value from Test Data sheet " + excelArray[i][j]);
					log.info("Value from the application " + webElementArray[j]);
				}
			}
		}
		return true;
	}
}
