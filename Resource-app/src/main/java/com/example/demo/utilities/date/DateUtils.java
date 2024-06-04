package com.example.demo.utilities.date;

import java.util.Calendar;
import java.util.Date;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateUtils {
	public static Date getCurrentDate() {
		Calendar calendar = Calendar.getInstance();
		Date currentDate = calendar.getTime();
		return currentDate;
	}

	public static String getHoursMinutes(Date date) {
		return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault())
				.format(DateTimeFormatter.ofPattern("HH:mm"));
	}

	public static boolean isTimeGreaterThanTime2(String time1, String time2) {
		try {
			LocalTime parsedTime1 = LocalTime.parse(time1, DateTimeFormatter.ofPattern("HH:mm"));
		      LocalTime parsedTime2 = LocalTime.parse(time2, DateTimeFormatter.ofPattern("HH:mm"));
		      return parsedTime1.isAfter(parsedTime2) || parsedTime1.equals(parsedTime2);
		}catch(Exception e) {
			return false;
		}
	}

}
