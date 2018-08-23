package design.patterns.creational.builder;

public interface Architect {

	void setHouseBuilder(HouseBuilder houseBuilder);

	void buildHouse();

	House getfinalFinishedHouse();

}
