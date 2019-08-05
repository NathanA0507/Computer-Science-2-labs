public class MountainBike extends Bike{
	private String userLevel;
	private int wheelSize;
	//Defult constructor
	public MountainBike(){
		super();
	}
	//The constructor we are mainly using
	public MountainBike(String modelNumber, String color, int ageRangeL, int ageRangeR, int numBikes, int priceBought, int sellPrice, String userLevel, int wheelSize){
		super(modelNumber, color, ageRangeL, ageRangeR, numBikes, priceBought, sellPrice);
		this.userLevel = userLevel;
		this.wheelSize = wheelSize;
	}
	//Setters
	public void setUserLevel(String userLevel){
		this.userLevel = userLevel;
	}
	public void setWheelSize(int wheelSize){
		this.wheelSize = wheelSize;
	}
	//Getters
	public String getUserLevel(){
		return this.userLevel;
	}
	public int getWheelSize(){
		return this.wheelSize;
	}
	//Overriding java's toString method
	@Override
	public String toString(){
		String result = "Mountain Bike, ";
		result += super.toString();
		result += " User Level: " + userLevel +" Wheel Size: "	+wheelSize;	
		return result;		
	}
}