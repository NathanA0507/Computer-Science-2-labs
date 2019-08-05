public class Bike{
   
    private String type;
    private String model;
    private int purchasePrice;
    private int retailPrice;
    private String color;
    private int numBikes;
    private String ageRange;

    
    //Constructors
    public Bike(){}

    public Bike(String type,String model,int purchasePrice,int retailPrice,String color,int numBikes,String ageRange){
        this.type = type;
        this.model = model;
        this.purchasePrice = purchasePrice;
        this.retailPrice = retailPrice;
        this.color = color;
        this.numBikes = numBikes;
        this.ageRange = ageRange;
    }

    //Setters
	public void setModel(String model) {
        this.model = model;
    }
    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
    public void setRetailPrice(int retailPrice) {
        this.retailPrice = retailPrice;
    }
    public void setType(String type){
        this.type = type;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setNumBikes(int numBikes) {
        this.numBikes = numBikes;
    }
    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    //Getters
    public String getType(){
        return this.type;
    }
    public String getModel() {
        return this.model;
    }

    public int getPurchasePrice() {
        return this.purchasePrice;
    }

    public int getRetailPrice() {
        return this.retailPrice;
    }

    public String getColor() {
        return this.color;
    }

    public int getNumBikes() {
        return this.numBikes;
    }

    public String getAgeRange() {
        return this.ageRange;
    }

    //ToString

    @Override
    public String toString() {
        return "{" +
            " type = '" + getType() + "'"+
            " model='" + getModel() + "'" +
            ", purchasePrice='" + getPurchasePrice() + "'" +
            ", retailPrice='" + getRetailPrice() + "'" +
            ", color='" + getColor() + "'" +
            ", numBikes='" + getNumBikes() + "'" +
            ", ageRange='" + getAgeRange() + "'" +
            "}";
    }
    
}