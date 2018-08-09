package com.speruri.java8;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.function.Predicate;

public class ZonedateApp {
	public static void main(String[] args) {
		ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("America/New_York"));
		DateTimeFormatter dft = DateTimeFormatter.ISO_DATE;
		System.out.println(dft.format(zdt));

		Set<String> zones = ZoneId.getAvailableZoneIds();
		Predicate<String> pred = zoneID -> zoneID.contains("London");
		zones.stream().filter(pred).forEach(zone -> System.out.println(zone));
	}
}
