package com.example.demo.utilities.date;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	public static Date getCurrentDate() {
		Calendar calendar = Calendar.getInstance();
		Date currentDate = calendar.getTime();
		return currentDate;
	}
}
