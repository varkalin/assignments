package com.poseitech.assignment.util;

import java.text.ParseException;
import java.util.Date;

public class DateUtils {
	
	private static String defaultPattern = "yyyy-MM-dd";
	
	public static Date currentDate() throws ParseException {
		return new Date();
	}
	
	public static Date parseDate(String str) throws ParseException {
		return parseDate(str, defaultPattern);
	}
	
	public static Date parseDate(String str, String parsePatterns) throws ParseException {
		return org.apache.commons.lang3.time.DateUtils.parseDate(str, parsePatterns);
	}
}
