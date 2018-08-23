package design.patterns.creational.builder;

public class SuperArchitect implements Architect {

	HouseBuilder houseBuilder;

	@Override
	public void setHouseBuilder(HouseBuilder argHouseBuilder) {
		this.houseBuilder = argHouseBuilder;
	}

	@Override
	public void buildHouse() {

	}

	@Override
	public House getfinalFinishedHouse() {
		// TODO Auto-generated method stub
		return null;
	}

}
