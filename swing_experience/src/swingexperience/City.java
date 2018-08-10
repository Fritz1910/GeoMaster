package swingexperience;

final class City {

	String name;
	private final double cityLocX;
	private final double cityLocY;

	City(String name, double cityLocX, double cityLocY) {
		this.name = name;
		this.cityLocX = cityLocX;
		this.cityLocY = cityLocY;
	}

//	private final List<City> cities = new ArrayList<>();
//
//	void addStadt(final City city) {
//		this.cities.add(Objects.requireNonNull(city, "PanelFile Panel = null"));
//	}

	String getName() {
		return this.name;
	}

	double getCityLocX() {
		return this.cityLocX;
	}

	double getCityLocY() {
		return this.cityLocY;
	}

}
