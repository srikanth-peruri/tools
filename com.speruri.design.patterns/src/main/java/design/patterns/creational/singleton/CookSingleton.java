package design.patterns.creational.singleton;

public class CookSingleton {

	private static CookSingleton singleton = createCook();
	private boolean saltAdded = false;

	private CookSingleton() {
	}

	private synchronized static CookSingleton createCook() {
		CookSingleton cook = singleton;
		if (cook == null) {
			cook = new CookSingleton();
		}
		return cook;
	}

	public static CookSingleton getInstance() {
		return singleton;
	}

	public void makeBroth() {
		if (!saltAdded) {
			System.out.println("Adding salt by : " + this.getClass().getName());
			saltAdded = true;
		}
	}
}
