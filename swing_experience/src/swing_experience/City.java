package swing_experience;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class City {

	String name;
	int x;
	int y;

	private City(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}

	private final List<City> cities = new ArrayList<>();

	void addStadt(final City city) {
		this.cities.add(Objects.requireNonNull(city, "PanelFile Panel = null"));
	}
}
