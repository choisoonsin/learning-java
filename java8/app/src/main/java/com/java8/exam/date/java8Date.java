package com.java8.exam.date;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class java8Date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate date = LocalDate.now();
		System.out.println(date);
		
		LocalTime time = LocalTime.now();
		System.out.println(time);
		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		
		/* DateTimeFormatter */
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate1 = LocalDate.parse("2017-11-01"	, dateFormatter);
		LocalDate localDate2 = LocalDate.parse("2017-11-10"	, dateFormatter);
		System.out.println(Duration.between(localDate2.atStartOfDay(), localDate1.atStartOfDay()).toDays());
		
		// 포매팅된 localDate객체에 연산하는 경우 리턴된 localDate값 포맷 상속 됨.
		LocalDate localDate3 = localDate1.minusDays(1);
		LocalDate localDate4 = localDate1.plusWeeks(2);
		System.out.println("baseDate["+localDate1+"] -1 day:"+localDate3);
		System.out.println("baseDate["+localDate1+"] +2 week:"+localDate4);
		
		LocalTime currentTime = LocalTime.now();
		System.out.println("current time:"+currentTime);
		System.out.println("current time + 1time"+currentTime.plusHours(2));
		System.out.println("current time + 1time"+currentTime.plusMinutes(30));
		
		// Use ChronoUnit
		long term = ChronoUnit.DAYS.between(localDate2, localDate1);
		System.out.println("term:"+term);
		
		// Use until
		LocalDate currentDate = LocalDate.of(2017, Month.NOVEMBER , 13);
		LocalDate christmas = LocalDate.of(2017, Month.DECEMBER, 25);
		
		System.out.println("Until christmas: " + currentDate.until(christmas));
		
		System.out.println("Until christmas (with crono): " + currentDate.until(christmas, ChronoUnit.DAYS));
	}

}
