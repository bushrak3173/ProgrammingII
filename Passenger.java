public abstract class Passenger implements Eater{
	private String name;
	private int birthYear;
	private double weight;
	private char gender;
	private int numCarryOn;
	private double height;
	private int caloriesConsumed = 0;
	private int caloriesAccumulator = 0;
	
	public Passenger(){
		name = "";
		birthYear = 1900;
		weight = 0.0;
		gender = 'u';
		numCarryOn = 0;
		height = 0.0;
	}
	
	public Passenger(java.lang.String name, int birthYear, double weight, double height, char gender, int numCarryOn) {
		if (height>=0.0) {
			this.height = height;
		}
		else {
			this.height = -1;
		}
		this.name = name;
		this.birthYear = birthYear;
		if (weight >=0) {
			this.weight = weight;
		}
		else {
			this.weight = -1;
		}
		
		if (gender == 'f' || gender == 'm' || gender == 'u') {
			this.gender = gender;
		}
		else {
			this.gender = 'u';
		}
		
		if (numCarryOn < 0) {
			this.numCarryOn = 0;
		}
		else if (numCarryOn > 2) {
			this.numCarryOn = 2;
		}
		else {
			this.numCarryOn = numCarryOn;
		}
		
	}
	
	public int calculateAge(int currentYear) {
		if (currentYear< birthYear) {
			return -1;
		}
		else{
			int age = currentYear - birthYear;
			return age;
		}
	}
	
	public void gainWeight() {
		weight += 1;
	}
	
	public void gainWeight(double gained) {
		if (weight + gained >= 0) {
			weight += gained;
		}
	}
	
	public int getBirthYear() {
		return birthYear;
	}
	
	public char getGender() {
		return gender;
	}
	
	public String getName() {
		return name;
	}
	
	public void setNumCarryOn(int numCarryOn) {
		if (numCarryOn<0) {
			this.numCarryOn = 0;
		}
		if (numCarryOn> 2) {
			this.numCarryOn = 2;
		}
		else {
			this.numCarryOn = numCarryOn;
		}
	}
	
	public int getNumCarryOn() {
		return numCarryOn;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public boolean isFemale() {
		boolean see;
		if (gender == 'f') {
			see = true;
		}
		else {
			see = false;
		}
		return see;
	}
	
	public boolean isMale() {
		boolean see;
		if (gender == 'm') {
			see = true;
		}
		else {
			see = false;
		}
		return see;
	}
	
	public void loseWeight() {
		if (weight >= 1) {
			weight--;
		}
	}
	
	public void loseWeight(double weight) {
		this.weight -= weight;
		if (this.weight <0) {
			this.weight = 0;
		}
	}
	
	public void printDetails() {
		System.out.printf("Name: %20s | Year of Birth: %4d | Weight: %10.2f | Height: %10.2f | Gender: %c | NumCarryOn: %\n", name, birthYear, weight, height, gender, numCarryOn);
		
	}
	
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
	public void setGender(char gender) {
		if (gender == 'm' || gender == 'f' || gender == 'u') {
			this.gender = gender;
		}
		else {
			this.gender = 'u';
		}
	}
	
	public void setName(java.lang.String name) {
		this.name = name;
	}
	
	public void setWeight(double weight) {
		if (weight>=0) {
			this.weight = weight;
		}
		else {
			this.weight = -1.0;
		}
	}
	
	public void setHeight(double height) {
		if (height>= 0.0) {
			this.height = height;
		}
		else {
			this.height = -1;
		}
	}
	
	public double getHeight() {
		return height;
	}
	
	public double calculateBMI() {
		double bmi = (weight * 703);
		double hs = Math.pow(height, 2.0);
		bmi /= hs;
		return bmi;
	}
	
	public int getCaloriesConsumed() {
		return caloriesConsumed;
	}
	
	public void setCaloriesConsumed(int numConsumed) {
		caloriesConsumed = numConsumed;
	}
	
	public int getCaloriesAccumulator() {
		return caloriesAccumulator;
	}
	
	public void setCaloriesAccumulator(int acc) {
		caloriesAccumulator = acc;
	}

	
	@Override
	public String toString() {
		String d = String.format("Name: %20s | Year of Birth: %4d | Weight: %10.2f | Height: %10.2f | Gender: %c | NumCarryOn: %2d\n", name, birthYear, weight, height, gender, numCarryOn);
		return d;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Passenger) {
			//downcasts downcasts from superclass to subclass so you have access to methods
			Passenger a = (Passenger)obj;
			if (this.birthYear == a.getBirthYear() && this.gender == a.getGender() && this.name == a.getName()) {
				if (Math.abs(this.weight-a.getWeight()) <= 0.5 && Math.abs(this.height - a.getHeight()) <= 0.5) {
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
		else {
			return false;
		}
	}

	@Override
	public abstract double metabolizeAccumulatedCalories();
}