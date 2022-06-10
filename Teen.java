public class Teen extends Person implements Mover{
	
	@Override
	public double metabolizeAccumulatedCalories() {
		double weightGained = 0;
		int ca = this.getCaloriesAccumulator();
		
		while (ca - 5000 >= 0) {
			weightGained++;
			this.gainWeight();
			ca -= 5000;
		}
		if (ca < 5000) {
			double frac = ca / 5000.00;
			this.gainWeight(frac);
		}
		this.setCaloriesAccumulator(0);
		return weightGained;
	}
	
	@Override
	public void eat(Food food) {
		int foodCals = food.getCalories();
		
		int calsConsumed = this.getCaloriesConsumed();
		this.setCaloriesConsumed(calsConsumed + foodCals);
		
		int calsAccumulated = this.getCaloriesAccumulator();
		this.setCaloriesAccumulator(calsAccumulated + foodCals);
	}
	
	@Override
	public void eat(Food[] food) {
		int totalCalsAdded = 0;
		for (Food a : food) {
			totalCalsAdded += a.getCalories();
		}
		
		int calsConsumed = this.getCaloriesConsumed();
		this.setCaloriesConsumed(calsConsumed + totalCalsAdded);
		
		int calsAccumulated = this.getCaloriesAccumulator();
		this.setCaloriesAccumulator(calsAccumulated + totalCalsAdded);
	}
	
	@Override
	public String move() {
		return "run fast and jump";
	}
	
	@Override
	public String move(int count) {
		String a = "";
		while (count > 1) {
			String b = "run fast and jump\n";
			a += b;
			count--;
		}
		a += "run fast and jump";
		return a;
	}

}