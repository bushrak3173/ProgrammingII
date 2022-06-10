public class Infant extends Person{
	
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
	
}