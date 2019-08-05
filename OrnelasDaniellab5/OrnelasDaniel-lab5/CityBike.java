public class CityBike extends Bike{
    private int numBaskets;
    private String brakeType;

    public CityBike(String type,String model,int purchasePrice,int retailPrice,String color,int numBikes,String ageRange,int numBaskets,String brakeType){
        super(type,model, purchasePrice, retailPrice, color, numBikes, ageRange);
        this.brakeType = brakeType;
        this.numBaskets = numBaskets;
    }
   
    //getters
    public int getNumBaskets() {
        return this.numBaskets;
    }

    public String getBrakeType() {
        return this.brakeType;
    }

    //setters
	public void setNumBaskets(int numBaskets) {
        this.numBaskets = numBaskets;
    }
    public void setBrakeType(String brakeType) {
        this.brakeType = brakeType;
    }


    @Override
    public String toString() {
        return  super.toString() + "{" +
            " numBaskets='" + getNumBaskets() + "'" +
            ", brakeType='" + getBrakeType() + "'" +
            "}";
    }


}