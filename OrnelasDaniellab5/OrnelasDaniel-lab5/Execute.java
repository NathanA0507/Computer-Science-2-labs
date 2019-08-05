
import java.util.*;
import java.io.*;
public class Execute{
    public static void main(String[] args){
        Bike[] B = readInventoryFromFile(args[0]);
        printInventory(B);
        double profit = updateInventoryBasedOnClientsRequests(B, args[1]);
        System.out.println("------------");
        System.out.println("Updated Inventory");
        printInventory(B);
        System.out.println("Profit = " + profit);
    }

    /**
     * Method to read a file and create bike objects depending on type of bike
     * @param filename filename containing bike inventory
     * @return Bike array containing bike objects
     */
    public static Bike[] readInventoryFromFile(String filename){
        int inventorySize = countFileLines(filename);
        Bike[] B = new Bike[inventorySize];
        try{
            File file = new File(filename);
            Scanner in = new Scanner(file);
            int line =0;
            while (in.hasNextLine()) {
                //Split string by comma
                String[] bikeContent = in.nextLine().split(",");
                //Extract common information, 
                //trim all contents to remove whitespace
                String bikeType = bikeContent[0].trim();
                String model = bikeContent[1].replaceAll("Model","").trim();
                //substring removes $ symbol
                int purchasePrice = Integer.parseInt(bikeContent[2].trim().substring(1));
                int retailPrice = Integer.parseInt(bikeContent[3].trim().substring(1));
                String color = bikeContent[4].trim();
                int numBikes = Integer.parseInt(bikeContent[5].trim());
                String ageRange = bikeContent[6].trim();
                switch(bikeType){
                    //Extract class specific content inside cases and create Bike objects
                    case "Mountain Bike":
                        String userLvl = bikeContent[7].trim();
                        int wheelSize = Integer.parseInt(bikeContent[8].trim());
                        B[line] = new MountainBike(bikeType,model, purchasePrice, retailPrice, color, numBikes, ageRange, userLvl, wheelSize);
                        break;
                    case "City Bike":
                       
                        int numBaskets = Integer.parseInt(bikeContent[7].trim());
                        String brakeType = bikeContent[8].trim();
                        B[line] = new CityBike(bikeType,model, purchasePrice, retailPrice, color, numBikes, ageRange, numBaskets, brakeType);
                        break;
                    case "Road Bike":
                        int numGears = Integer.parseInt(bikeContent[7].trim());
                        double weight = Double.parseDouble(bikeContent[8].trim());
                        B[line] = new RoadBike(bikeType,model, purchasePrice, retailPrice, color, numBikes, ageRange, numGears, weight);
                        break;

                }
                line++;
            }
            in.close();
          
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
            System.exit(1);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Array out of bounds");
            System.exit(1);
        }
        catch(NumberFormatException e){
            e.printStackTrace();
            System.out.println("Number format error");
            System.exit(1);
        }
        return B;
    }

    /**
     * Method to calculate profit of sales based on inventory and client requests.
     * Generates a missing.txt file if bike requests are not in inventory
     * @param B array of bikes representing the inventory
     * @param filename file containing the client requests
     * @return profit of sales
     */
    public static double updateInventoryBasedOnClientsRequests(Bike[] B, String filename){
        double profit = 0.0;
        try{
            File file = new File(filename);
            Scanner in = new Scanner(file);
            PrintWriter writer = new PrintWriter("missing.txt");
            
            //read through file 
            while (in.hasNextLine()) {
                //Split string by comma
                String[] requestContent = in.nextLine().split(",");
                //trim all contents to remove whitespace
                String bikeType = requestContent[0].trim();
                String model = requestContent[1].replaceAll("Model","").trim();
                String color = requestContent[2].trim();
                int reqBikes = Integer.parseInt(requestContent[3].trim());
                //Loop through inventory bikes
                for(Bike b : B){
                    //Compare request type with object class
                    if(bikeType.equals(b.getType())){
                        //types match, compare model
                        if(model.equals(b.getModel())){
                            //model matches, compare color
                            if(color.equals(b.getColor())){
                                //bike is found, compare inventory to client request
                                //more bikes requested than inventory
                                int numBikes = b.getNumBikes();
                                if(reqBikes > numBikes){
                                    //sell all bikes in inventory
                                    profit += (b.getRetailPrice() - b.getPurchasePrice()) * numBikes;
                                    //update requested bikes and inventory
                                    reqBikes -= numBikes;
                                    b.setNumBikes(0);
                                }
                                else{
                                    //requested bikes <= inventory bikes
                                    //sell all requested bikes
                                    profit += (b.getRetailPrice() - b.getPurchasePrice()) * reqBikes;
                                    //update inventory and requested bikes
                                    b.setNumBikes(numBikes-reqBikes);
                                    reqBikes = 0;
                                }
                            }
                        }
                    }
                }
                //if we did not sell all the bikes requested for a model, write to missing
                if(reqBikes > 0){
                    writer.print(bikeType + " , Model" + model + " , " + color + " , " + reqBikes);
                }
            }
            in.close();
            writer.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found");
            System.exit(1);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Array out of bounds");
            System.exit(1);
        }
        catch(NumberFormatException e){
            System.out.println("Number format error");
            System.exit(1);
        }
        
        return profit;
    }


    /**
     * Print bike inventory
     * @param B array containing bike inventory
     */
    public static void printInventory(Bike[] B){
        for(Bike b : B){
            System.out.println(b.toString());
        }
    }

    /**
     * Method to count number of lines in a file
     * @param filename name of the file to read
     * @return number of lines in file
     */
    public static int countFileLines(String filename){
        int lines = 0;
        try{
            File file = new File(filename);
            Scanner in = new Scanner(file);
            while (in.hasNextLine()) {
                in.nextLine();
                lines++;
            }
            in.close();
          
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
            System.exit(1);
        }
        return lines;
    }
}