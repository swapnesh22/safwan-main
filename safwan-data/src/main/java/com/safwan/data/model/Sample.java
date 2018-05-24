package com.safwan.data.model;

import java.text.DecimalFormat;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Months;

public class Sample {
	
	public static void main(String[] args) {
		compareDates();
	}
	
	private static double compareDates() {
		DateTime date1 = new DateTime().withDate(2019, 1,1);
		DateTime date2 = new DateTime().withDate(2019, 3,30);
		int numberOfMonths = Months.monthsBetween(date1, date2).getMonths();
		int numberOfDays = Days.daysBetween(date1, date2).getDays();
		System.out.println("Months between two dates "+numberOfMonths);
		System.out.println("Days between two dates "+numberOfDays);
		System.out.println("Days to Month "+numberOfDays/30);
		
		double months = 80/30;
		
		System.out.println(months);
		String s = String.format("%.2f", months);

		System.out.println("Months "+s);
		
		return months;
	}

}
