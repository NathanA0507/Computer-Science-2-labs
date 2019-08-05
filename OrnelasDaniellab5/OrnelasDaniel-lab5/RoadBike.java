public class RoadBike extends Bike{
    private int numGears;
    private double weight;

    public RoadBike(String type,String model,int purchasePrice,int retailPrice,String color,int numBikes,String ageRange,int numGears,double weight){
        super(type,model, purchasePrice, retailPrice, color, numBikes, ageRange);
        this.numGears = numGears;
        this.weight = weight;
    }
    //getters
    public int getNumGears() {
        return this.numGears;
    }

    public double getWeight() {
        return this.weight;
    }
    //setters
	public void setNumGears(int numGears) {
        this.numGears = numGears;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }



    @Override
    public String toString() {
        return   super.toString() + "{" +
            " numGears='" + getNumGears() + "'" +
            ", weight='" + getWeight() + "'" +
            "}";
    }



}