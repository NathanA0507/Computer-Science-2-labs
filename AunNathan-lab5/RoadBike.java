public class RoadBike extends Bike{
	private int numGears;
	private double weight;
	
	//Default constructor here
	public RoadBike(){
		super();
	}
	//Constructor that we are using here
	public RoadBike(String modelNumber, String color, int ageRangeL, int ageRangeR, int numBikes, int priceBought, int sellPrice, int numGears, double weight){
		super(modelNumber, color, ageRangeL, ageRangeR, numBikes, priceBought, sellPrice);
		this.numGears = numGears;
		this.weight = weight;
	}
	//Setters
	public void setNumGears(int numGears){
		this.numGears = numGears;
	}
	public void setWeight(double weight){
		this.weight = weight;
	}
	//Getters
	public int getNumGears(){
		return this.numGears;
	}
	public double getWeight(){
		return this.weight;
	}
	//Overriding java's toString here 
 	@Override
	public String toString(){
		String result = "Road Bike, ";
		result += super.toString();
		result += " Number of gears: " + numGears +" Weight: " +weight;	
		return result;		
	}

}