package design.patterns.creational.builder;

import java.util.ArrayList;
import java.util.List;

public abstract class Room {

	private List<Item> itemsList;

	public Room() {
		this.itemsList = new ArrayList<>();
	}

	public abstract void buildRoom();

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		this.itemsList.forEach((item) -> s.append(item));
		return s.toString();
	}

	public List<Item> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<Item> itemsList) {
		this.itemsList = itemsList;
	}

}
