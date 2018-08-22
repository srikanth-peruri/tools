package design.patterns.creational.prototype;

public class PrototypeExample implements Cloneable {

	private String initialStr;

	public Object clone() {
		Object clone = null;
		try {
			clone = super.clone();
		} catch (Exception e) {
			throw new RuntimeException("Exception while creating a clone ", e);
		}
		return clone;
	}

	public String getInitialStr() {
		return initialStr;
	}

	public void setInitialStr(String initialStr) {
		this.initialStr = initialStr;
	}

}
