package design.patterns.creational.singleton;

public class SingletonApp {
	public static void main(String[] args) {
		Cook cook1 = new Cook();
		Cook cook2 = new Cook();
		Cook cook3 = new Cook();

		cook1.makeBroth();
		cook2.makeBroth();
		cook3.makeBroth();

		CookSingleton cooks1 = CookSingleton.getInstance();
		CookSingleton cooks2 = CookSingleton.getInstance();
		CookSingleton cooks3 = CookSingleton.getInstance();

		cooks1.makeBroth();
		cooks2.makeBroth();
		cooks3.makeBroth();

	}
}
