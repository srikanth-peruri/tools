package design.patterns.creational.singleton;

public class Cook {

	private boolean saltAdded = false;

	public Cook() {

	}

	public void makeBroth() {
		if (!saltAdded) {
			System.out.println("Adding salt by : " + this.getClass().getName());
			saltAdded = true;
		}
	}
}
