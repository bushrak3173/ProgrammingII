public class Food {
	
	private String name;
	private int calories;
	
	public Food(String name, int calories) {
		this.name = name;
		this.calories = calories;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setCalories(int calories) {
		this.calories = calories;
	}
	
	public int getCalories() {
		return calories;
	}
	
	@Override
	public String toString() {
		String a = String.format("Food - name: %10s | calories: %4d", name, calories);
		return a;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Food) {
			Food a = (Food)obj;
			if (this.name == a.name && this.calories == a.calories) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
}
