package com.prox.api.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateFormatter {

	public static String format(Date date) {
		TimeZone tz = TimeZone.getTimeZone("UTC");
		SimpleDateFormat ISO8601DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.GERMANY);
		ISO8601DATEFORMAT.setTimeZone(tz);
		return ISO8601DATEFORMAT.format(date);
	}
}
