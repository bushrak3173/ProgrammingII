public class Elder extends Person implements Mover{
	
	@Override
	public double metabolizeAccumulatedCalories() {
		double weightGained = 0;
		int ca = this.getCaloriesAccumulator();
		
		while (ca - 300 >= 0) {
			weightGained++;
			this.gainWeight();
			ca -= 300;
		}
		if (ca < 300) {
			double frac = ca / 300.00;
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
		return "ouch my back wait for me";
	}
	
	@Override
	public String move(int count) {
		String a = "";
		while (count > 1) {
			String b = "ouch my back wait for me\n";
			a += b;
			count--;
		}
		a += "ouch my back wait for me";
		return a;
	}
}