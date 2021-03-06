public class Airplane {
	private Passenger[] passengers;
	private String airplaneName;
	private int numPassengers;
	
	public Airplane() {
		airplaneName = "";
		numPassengers = 0;
		passengers = new Passenger[100];
	}
	public Airplane(int maxPassengers) {
		if (numPassengers < 0) {
			this.passengers = new Passenger[0];
			maxPassengers = 0;
		}
		else {
			this.passengers = new Passenger[maxPassengers];
		}
		airplaneName = "";
		this.numPassengers = 0;
		passengers = new Passenger[maxPassengers];
	}
	
	public Airplane(String airplaneName) {
		this.airplaneName = airplaneName;
		numPassengers = 0;
		passengers = new Passenger[100];
	}
	
	public Airplane(String airplaneName, int maxPassengers) {
		this.airplaneName = airplaneName;
		if (numPassengers<0) {
			this.passengers = new Passenger[0];
			maxPassengers = 0;
		}
		else {
			this.passengers = new Passenger[maxPassengers];
		}
		this.airplaneName = airplaneName;
		this.numPassengers = 0;
		passengers = new Passenger[maxPassengers];
	}
	
	public void addPassenger(Passenger a) {
		if (numPassengers  < passengers.length){
			passengers[numPassengers] = a;
			numPassengers++;
		}
		else {
			Passenger[] old = new Passenger[passengers.length * 2];
			for (int i = 0; i< passengers.length; i++) {
				old[i] = passengers[i];
			}
			passengers = old;
			passengers[numPassengers] = a;
			numPassengers++;
		}
	}
	
	public Passenger getFirstPassenger() {
		if (passengers.length >= 0) {
			return passengers[0];
		}
		else {
			return null;
		}
	}
	
	public String getAirplaneName() {
		return airplaneName;
	}
	
	public double getTotalWeightOfAllPassengers() {
		double total = 0.0;
		double holdWeight =0.0;
		for (int i = 0; i < numPassengers; i++) {
			Passenger a = passengers[i];
			holdWeight = a.getWeight();
			total += holdWeight;
		}
		return total;
	}
	
	public double getAverageWeightOfAllPassengers() {
		if (numPassengers > 0) {
			double average = getTotalWeightOfAllPassengers();
			average /= numPassengers;
			return average;
		}
		else {
			return 0;
		}
	}
	
	public Passenger getPassenger(int index) {
		if (index >= 0 && index <= numPassengers && passengers[index] != null) {
			return passengers[index];
		}
		else {
			return null;
		}
	}
	
	public Passenger[] getPassengers() {
		return passengers;
	}
		
	
	public Passenger getLastPassenger() {
		return passengers[numPassengers-1];
	}
	
	public int getNumberOfPassengersAboveWeight(double weight) {
		int count = 0;
		if (weight > 0.0) {
			for (int i = 0; i<numPassengers; i++) {
				Passenger a = passengers[i];
				double test = a.getWeight();
				if (test > weight) {
					count += 1;
				}
			}
		}
		return count;
	}
	
	public int getNumberOfPassengersBelowWeight(double weight) {
		int count = 0;
		if (weight > 0.0) {
			for (int i = 0; i< numPassengers; i++) {
				if (passengers[i].getWeight() < weight) {
					count += 1;
				}
			}
		}
		return count;
	}
	
	public int getNumPassengers() {
		return numPassengers;
	}
	
	public void setAirplaneName(java.lang.String name) {
		airplaneName = name;
	}
	
	public Passenger removePassenger(int index) {
		if (index >= 0 && index < numPassengers) {
			Passenger[] hold = new Passenger[passengers.length];
			Passenger a = passengers[index];
			int j = 0;
			for (int i = 0; i < numPassengers; i++) {
				if (i != index) {
					hold[j] = passengers[i];
					j++;
				}
			}
			passengers = hold;
			numPassengers -= 1;
			return a;
		} 
		else{
			return null;
		}
	}
	
	public void removeAllPassengers() {
		for (int i = 0; i < numPassengers; i++) {
			passengers[i] = null;
		}
		numPassengers = 0;
	}
	
	public void increaseWeightOfAllPassengers(){
		for (int i = 0; i<numPassengers; i++){
			Passenger a = passengers[i];
			a.gainWeight();
		}
	}
	
	public void increaseWeightOfAllPassengers(double weight) {
		for (int i = 0; i<numPassengers; i++) {
			Passenger a = passengers[i];
			a.gainWeight(weight);
		}
	}
	
	public void printAllDetails() {
		System.out.printf("AirplaneName: %20s | Number of Passengers: %4d | Airplane Size: %4d\n", airplaneName, numPassengers, passengers.length);
		for (int i = 0; i< numPassengers; i++){
			passengers[i].printDetails();
		}
	}
	
	public static void main(String[] args){
		Passenger emma = new Passenger("Emma", 2020, -1, 'f', 1);
		Passenger dylan = new Passenger("Dylan", 2020, .90999, 'f', 2);
		Passenger carry = new Passenger("Carry", 2020, 1000, 'f', 3);
		
		Airplane a  = new Airplane();
		emma.gainWeight();
		a.addPassenger(emma);
		a.addPassenger(dylan);
		a.addPassenger(carry);
		System.out.println("Total Weight: " + a.getTotalWeightOfAllPassengers());

		System.out.println("Average Weight: " + a.getAverageWeightOfAllPassengers());
		System.out.println("Num above 12: " + a.getNumberOfPassengersAboveWeight(999));
		System.out.println("Num below 0: " + a.getNumberOfPassengersBelowWeight(1));
	}
}
	