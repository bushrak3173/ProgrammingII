public class Infant extends Person implements Mover{
	
	private final InfantToy[] toys = new InfantToy[10];
	private int numInfantToys;
	
	public Infant() {
		numInfantToys = 0; 
	}
	
	public Infant(String name, int birthYear, double weight, double height, char gender, int numCarryOn) {
		super(name, birthYear, weight, height, gender, numCarryOn, 0);
		numInfantToys = 0;
		
	}
	
	public void addInfantToy(String name, int rating) {
		InfantToy addition = new InfantToy(name, rating);
		if (numInfantToys < 10) {
			toys[numInfantToys] = addition;
			numInfantToys++;
		}
		else {
			System.out.print("toys has reached capacity of 10");
		}
	}
	
	public String getInfantToyAsString(int index) {
		if (index >=0 && index<numInfantToys) {
			String a = toys[index].toString();
			return a;
		}
		else {
			return "invalid index " + index;
		}
		
	}
	
	public int getNumInfantToys() {
		return numInfantToys;
	}
	
	public int getHighestInfantToyRating() {
		int highest = 0;
		for (int i = 0; i<numInfantToys; i++) {
			InfantToy a = toys[i];
			int curr = a.infantToyRating;
			if (curr > highest) {
				highest = curr;
			}
		}
			return highest;
	}
	
	public String getInfantToyName(int index) {
		if (index >= 0 && index < numInfantToys) {
			InfantToy a = toys[index];
			return a.infantToyName;
		}
		else {
			return "invalid index " + index;
		}
	}
	
	public int getInfantToyRating(int index) {
		if (index >= 0 && index <numInfantToys) {
			InfantToy a = toys[index];
			return a.infantToyRating;
		}
		else {
			return -1;
		}
	}
	
	public class InfantToy{
		private String infantToyName;
		private int infantToyRating;
		
		
		public InfantToy(String name, int rating) {
			infantToyName = name;
			infantToyRating = rating;
		}
		
		@Override
		public String toString() {
			String a = String.format("InfantToy: Toy Name: %20s | Rating %4d\n", infantToyName, infantToyRating);
			return a;
		}
	}
	
	@Override 
	public void printDetails() {
		super.printDetails();
		System.out.printf("Infant: Number of Toys: %4d | InfantToys: \n", numInfantToys);
		for (InfantToy a : toys) {
			System.out.println(a.toString());
		}
	}
	
	@Override
	public String toString() {
		String a = super.toString();
		for (InfantToy b : toys) {
			String c = b.toString();
			a.concat(" " + c);
		}
		return a;
	}
	
	@Override
	public double metabolizeAccumulatedCalories() {
		double weightGained = 0;
		int ca = this.getCaloriesAccumulator();
		while (ca - 1200 >= 0) {
			weightGained++;
			this.gainWeight();
			ca -= 1200;
		}
		if (ca < 1200) {
			double frac = ca / 1200.00;
			this.gainWeight(frac);
		}
		this.setCaloriesAccumulator(0);
		return weightGained;
	}
	
	@Override
	public String move() {
		return "flail arms and legs";
	}
	
	@Override
	public String move(int count) {
		String a = "";
		for (int i = 0; i<= count; i++) {
			a.concat("flail arms and legs \n");
		}
		return a;
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
	
}