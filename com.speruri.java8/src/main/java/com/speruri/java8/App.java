package com.speruri.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class App {
	public static void main(String[] args) {
		IFuntionalInterface testI = () -> System.out.println("Hi Srikanth, this is jyo");
		testI.test();

		IFuntionalInterfaceWithArgs testIA = (int1, int2) -> {
			System.out.println(int1 + int2);
		};
		testIA.calculate(5, 6);
		testIA = (int1, int2) -> {
			System.out.println(int1 - int2);
		};
		testIA.calculate(5, 6);

		Runnable r = () -> {
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
			System.out.println("Running thread 1");
		};
		Runnable r1 = () -> {
			System.out.println("Running thread 2");
		};

		new Thread(r).start();
		new Thread(r1).start();

		List<Person> persons = new ArrayList<>();
		persons.add(new Person(31, "Srikanth"));
		persons.add(new Person(28, "Jyothi"));
		persons.add(new Person(1, "Rishika"));

		Predicate<Person> pred = (p) -> p.getAge() > 30;
		Predicate<Person> pred1 = (p) -> p.getAge() < 5;

		display(persons, pred);
		display(persons, pred1);
		System.out.println("Sorting=========");
		Collections.sort(persons, Person::comparePersonAges);
		persons.forEach((p) -> System.out.println(p));

	}

	private static void display(List<Person> persons, Predicate<Person> pred) {
		// persons.forEach((p) -> {
		// if (pred.test(p)) {
		// System.out.println(p);
		// }
		// });

		persons.stream().parallel().filter(pred).forEach(p -> System.out.println(p));
	}
}
