package design.patterns.creational.builder;

public class Paint implements Item {

	private String paint;

	public Paint(String argPaint) {
		this.paint = argPaint;
	}

	@Override
	public String getName() {
		return "This is " + this.paint + " Paint";
	}

}
