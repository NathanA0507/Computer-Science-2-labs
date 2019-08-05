public class MountainBike extends Bike{
    private String userLvl;
    private int wheelSize;



    public MountainBike(String type,String model,int purchasePrice,int retailPrice,String color,int numBikes,String ageRange,String userLvl, int wheelSize) {
        super(type,model, purchasePrice, retailPrice, color, numBikes, ageRange);
        this.userLvl = userLvl;
        this.wheelSize = wheelSize;
    }

    
    //getters
    public String getUserLvl() {
        return this.userLvl;
    }

    public int getWheelSize() {
        return this.wheelSize;
    }
    //setters
    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }

    public void setUserLvl(String userLvl) {
        this.userLvl = userLvl;
    }

    @Override
    public String toString() {
        return  super.toString() +"{" +
            " userLvl='" + userLvl + "'" +
            ", wheelSize='" + wheelSize + "'" +
            "}";
    }


}