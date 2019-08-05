public class Bike{
	private int ageRangeL;
	private int ageRangeR;
	private int numBikes;
	private int priceBought;
	private int sellPrice;
	private String modelNumber;
	private String color;
	
	//Defualt constructor
	public Bike(){
		
	}
	//Constructor that every class uses
	public Bike(String modelNumber, String color, int ageRangeL, int ageRangeR, int numBikes, int priceBought, int sellPrice){
		this.modelNumber = modelNumber;
		this.color = color;
		this.ageRangeL = ageRangeL;
		this.ageRangeR = ageRangeR;
		this.numBikes = numBikes;
		this.priceBought = priceBought;
		this.sellPrice = sellPrice;		
	}
	//Setters
	public void setModelNumber(String modelNumber){
		this.modelNumber = modelNumber;
	}
	public void setColor(String color){
		this.color = color;
	}
	public void setAgeRangeL(int ageRangeL){
		this.ageRangeL = ageRangeL;
	}
	public void setAgeRangeR(int ageRangeR){
		this.ageRangeR = ageRangeR;
	}
	public void setNumBikes(int numBikes){
		this.numBikes = numBikes;
	}
	public void setPriceBought(int priceBought){
		this.priceBought = priceBought;
	}
	public void setSellPrice(int sellPrice){
		this.sellPrice = sellPrice;
	}
	//Getters
	public String getModelNumber(){
		return this.modelNumber;
	}
	public String getColor(){
		return this.color;
	}
	public int getAgeRangeL(){
		return this.ageRangeL;
	}
	public int getAgeRangeR(){
		return this.ageRangeR;
	}
	public int getNumBikes(){
		return this.numBikes;
	}
	public int getPriceBought(){
		return this.priceBought;
	}
	public int getSellPrice(){
		return this.sellPrice;
	}
	//Overriding java's basic toString method for our own purposes here
	@Override
	public String toString(){
		String result = "Model number: " +modelNumber +" Color: " +color +" Age Range: " +ageRangeL +"-" +ageRangeR +" Number of bikes: " +numBikes +" Price bought: $" +priceBought +" Price sold: $" +sellPrice;
		return result;
	}
}