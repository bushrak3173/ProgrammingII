public abstract class Person extends Passenger{
	private int numOffspring;
	
	public Person() {
		numOffspring = 0;
	}
	
	public Person(int a) {
		numOffspring = a;
	}
	
	public Person(String name, int birthYear, double weight, double height, char gender, int numCarryOn, int numOffspring) {
		super(name, birthYear, weight, height, gender, numCarryOn);
		if (numOffspring < 0) {
			this.numOffspring = 0;
		}
		else {
			this.numOffspring = numOffspring;
		}
	}
	
	public void setNumOffspring(int a) {
		if (a < 0) {
			numOffspring = 0;
		}
		else {
			numOffspring = a;
		}
	}
	
	public int getNumOffspring() {
		return numOffspring;
	}
	
	@Override
	public void printDetails() {
		super.printDetails();
		String d = String.format("Person: Number of Offspring: %4d\n", numOffspring);
		System.out.println(d);
	}
	
	@Override
	public String toString() {
		String a = super.toString();
		String b = String.format("Person: Number of Offspring: %4d\n", numOffspring);
		return a + b;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person a = (Person)obj;
			if (super.equals(obj) == true) {
				if (this.numOffspring == a.numOffspring) {
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
}