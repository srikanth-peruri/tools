package design.patterns.creational.builder;

public class DoubleRoom extends Room {

	@Override
	public void buildRoom() {
		this.getItemsList().add(new Door());
		this.getItemsList().add(new Door());
		this.getItemsList().add(new Window());
		this.getItemsList().add(new Window());
		this.getItemsList().add(new Window());
		this.getItemsList().add(new Fan());
		this.getItemsList().add(new Fan());
		this.getItemsList().add(new Paint("Yellow"));
	}

}
