package com.speruri.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateFormatterExample {
	public static void main(String[] args) {
		LocalDate ld = LocalDate.now();
		DateTimeFormatter df = DateTimeFormatter.ISO_DATE;
		System.out.println(df.format(ld));

		LocalTime lt = LocalTime.now();
		DateTimeFormatter dft = DateTimeFormatter.ISO_TIME;
		System.out.println(dft.format(lt));

		LocalDateTime ltDT = LocalDateTime.now();
		DateTimeFormatter dfdt = DateTimeFormatter.ISO_DATE_TIME;
		System.out.println(dfdt.format(ltDT));
		
		
		DateTimeFormatter df_long = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		System.out.println(df_long.format(ld));
		
		DateTimeFormatter df_short = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		System.out.println(df_short.format(ld));
		
		System.out.println(df_long.withLocale(Locale.FRENCH).format(ld));
		
		
		

	}
}
