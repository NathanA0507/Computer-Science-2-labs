public class CityBike extends Bike{
	private int numBaskets;
	private String brakes;
	
	//Default constructor
	public CityBike(){
		super();
	}
	//Main constructor 
	public CityBike(String modelNumber, String color, int ageRangeL, int ageRangeR, int numBikes, int priceBought, int sellPrice, int numBaskets, String brakes){
		super(modelNumber, color, ageRangeL, ageRangeR, numBikes, priceBought, sellPrice);
		this.numBaskets = numBaskets;
		this.brakes = brakes;
	}
	
	//Setters
	public void setNumBaskets(int numBaskets){
		this.numBaskets = numBaskets;
	}
	public void setBrakes(String brakes){
		this.brakes = brakes;
	}
	
	//Getters
	public int getNumBaskets(){
		return this.numBaskets;
	}
	public String getBrakes(){
		return this.brakes;
	}
	
	//Overriding java's toString method
	@Override
	public String toString(){
		String result = "City Bike, ";
		result += super.toString();
		result += " Number of Baskets: " + numBaskets +" Brake type: " +brakes;	
		return result;		
	}

}