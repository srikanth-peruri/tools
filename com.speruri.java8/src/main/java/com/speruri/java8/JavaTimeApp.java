package com.speruri.java8;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class JavaTimeApp {
	public static void main(String[] args) throws InterruptedException {

		Instant start = Instant.now();
		System.out.println("Start : " + start);
		Instant end = Instant.now();

		System.out.println("Start : " + end);

		Duration elapsed = Duration.between(start, end);
		System.out.println("Duration is : " + elapsed.toMillis() + " millis");

		LocalDate ld = LocalDate.now();
		System.out.println("Local date is : " + ld);

		LocalDate ldOf = LocalDate.of(2018, 05, 25);
		System.out.println(ldOf);

		LocalTime lt = LocalTime.now();
		System.out.println("Local time : " + lt);

		LocalTime ltOd = LocalTime.of(10, 25, 59);
		System.out.println(ltOd);

		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		
		LocalDateTime ltdOf = LocalDateTime.of(ldOf, ltOd);
		System.out.println(ltdOf);

	}
}
