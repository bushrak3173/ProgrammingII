public class Passenger {
	private String name;
	private int birthYear;
	private double weight;
	private char gender;
	private int numCarryOn;
	
	public Passenger(){
		name = "";
		birthYear = 1900;
		weight = 0.0;
		gender = 'u';
		numCarryOn = 0;
	}
	
	public Passenger(java.lang.String name, int birthYear, double weight, char gender, int numCarryOn) {
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
		System.out.printf("Name: %20s | Year of Birth: %4d | Weight: %10.2f | Gender: %c | NumCarryOn: ", name, birthYear, weight, gender, numCarryOn);
		System.out.println(numCarryOn);
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
	
	
}