import java.io.*;

public class Execute{
	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		//Please comment out the test cases that are not being tested at the current time
		try{
			double profit;
			/*
			//Test Case 1
			System.out.println("Test Case 1:");
			Bike B[] = readInventoryFromFile("inventory.txt");
			printInventory(B);
			profit = updateInventoryBasedOnClientsRequests(B, "clientrequests.txt");
			System.out.println("Profit: " +profit);
			printInventory(B);
		
		
			//Test Case 2
			System.out.println("\nTest Case 2:");
			Bike B2[] = readInventoryFromFile("inventory.txt");
			printInventory(B2);
			profit = updateInventoryBasedOnClientsRequests(B2, "client.txt");
			System.out.println("Profit: " +profit);
			printInventory(B2);
		*/
			//Test Case 3
			System.out.println("\nTest Case 3:");
			Bike B3[] = readInventoryFromFile("inventory2.txt");
			printInventory(B3);
			profit = updateInventoryBasedOnClientsRequests(B3, "clientrequests1.txt");
			System.out.println("Profit: " +profit);
			printInventory(B3);
		
		/*	//Test Case 4
			System.out.println("\nTest Case 4:");
			Bike B4[] = readInventoryFromFile("inventory3.txt");
			printInventory(B4);
			profit = updateInventoryBasedOnClientsRequests(B4, "clientrequests3.txt");
			System.out.println("Profit: " +profit);
			printInventory(B4);
		// */
		}catch (Exception e){
			
		}
	}
	
	public static Bike[] readInventoryFromFile(String fileName) throws FileNotFoundException, IOException{
		try{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			BufferedReader br2 = new BufferedReader(new FileReader(fileName));
			int size = 0;
			int i = 0;
			int indexOf;
			String tempString;
			
			//Find the size needed to make the array
			while ((tempString = br.readLine()) != null)
			{
				size++;
			}
			String[][] temp = new String[size][];
			//Populate a temporary 2D array, with all the information of the bikes
			while ((tempString = br2.readLine()) != null)
			{
				temp[i] = tempString.split(",");
				for (int j = 0; j < temp[i].length; j++)
				{
					temp[i][j] = temp[i][j].trim();
					
				}
				i++;
			}
			
			Bike[] B = new Bike[size];
			try{
				//Create all the bike objects and put them in an array
				for (int j = 0; j < temp.length; j++){  
					indexOf = temp[j][6].indexOf("-");
					if(temp[j][0].equals("Mountain Bike"))
					{
						//Sends all the info for a mountain bike to the constructor in that class
						B[j] = new MountainBike(temp[j][1], temp[j][4], Integer.parseInt(temp[j][6].substring(0,indexOf)), Integer.parseInt(temp[j][6].substring(indexOf+1)), Integer.parseInt(temp[j][5]), Integer.parseInt(temp[j][2].substring(1)), Integer.parseInt(temp[j][3].substring(1)), temp[j][7], Integer.parseInt(temp[j][8]));
					}
					else if(temp[j][0].equals("Road Bike"))
					{
						//Sends all the info for a road bike to the constructor in that class
						B[j] = new RoadBike(temp[j][1], temp[j][4], Integer.parseInt(temp[j][6].substring(0,indexOf)), Integer.parseInt(temp[j][6].substring(indexOf+1)), Integer.parseInt(temp[j][5]), Integer.parseInt(temp[j][2].substring(1)), Integer.parseInt(temp[j][3].substring(1)), Integer.parseInt(temp[j][7]), Double.parseDouble(temp[j][8]));
					}
					else if(temp[j][0].equals("City Bike"))
					{
						//Sends all the info for a city bike to the constructor in that class
						B[j] = new CityBike(temp[j][1], temp[j][4], Integer.parseInt(temp[j][6].substring(0,indexOf)), Integer.parseInt(temp[j][6].substring(indexOf+1)), Integer.parseInt(temp[j][5]), Integer.parseInt(temp[j][2].substring(1)), Integer.parseInt(temp[j][3].substring(1)), Integer.parseInt(temp[j][7]), temp[j][8]);
					}
					else //If we do not have a bike of the 3 types above, that means the file is somehow incorrect so this will stop the execution 
						throw new RuntimeException("incorrect file format");
				}
			} catch(Exception e){
				System.out.println("\nText file is not formatted correctly, please check and try again\n");
				return null;
			}
			
			return B;
		} catch (Exception e){
			System.out.println("File not found");
		}
		return null;
	}
	
	public static double updateInventoryBasedOnClientsRequests(Bike[] B, String fileName) throws FileNotFoundException, IOException{
		try{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			BufferedReader br2 = new BufferedReader(new FileReader(fileName));
			PrintWriter writer = new PrintWriter(fileName.substring(0, (fileName.length() - 4)) +".missing.txt"); //the substring is there to cut off ".txt" from the original fileName
			int size = 0;
			String tempString;
			int i = 0;
			int temp;
			double amountEarned = 0;
			
			//Find the size needed to create the new array
			while(br.readLine() != null)
			{
				size++;
			}
			
			//Make and populate the temproary array of strings
			String[][] tempArr = new String[size][];
			while((tempString = br2.readLine()) != null){
				tempArr[i] = (tempString.split(","));
				for (int j = 0; j < tempArr[i].length; j++){
					tempArr[i][j] = tempArr[i][j].trim();
				}
				i++;
			}
			try{
				//Checks the model number and color against all existing bikes. If it doesn't exist then it will add it to the file of missing bikes
				for (int j = 0; j < tempArr.length; j++){
					for (int k = 0; k < B.length; k++){
						//Checks model number first
						if (tempArr[j][1].equals(B[k].getModelNumber())){
							//Checks color second
							if (tempArr[j][2].equals(B[k].getColor())){
								temp = B[k].getNumBikes() - Integer.parseInt(tempArr[j][3]);
								//Checks if there are enough in stock
								if (temp >= 0){
									amountEarned += (B[k].getSellPrice()-B[k].getPriceBought()) * Integer.parseInt(tempArr[j][3]);
									B[k].setNumBikes(temp);	
									break;
								}
								else{ //if there are some in stock but not enough to fill the request it will go here instead
									amountEarned += B[k].getNumBikes() * (B[k].getSellPrice()-B[k].getPriceBought());
									B[k].setNumBikes(0);
									temp = 0 - temp;
									writer.println(tempArr[j][0] +", " +tempArr[j][1] +", " +tempArr[j][2] +", amount missing: " +temp);
									break;
								}
							}
							else if (k == B.length-1){
								writer.println(tempArr[j][0] +", " +tempArr[j][1] +", " +tempArr[j][2] +", amount missing: " +tempArr[j][3]);
							}
						}
						else if (k == tempArr.length-1){
							writer.println(tempArr[j][0] +", " +tempArr[j][1] +", " +tempArr[j][2] +", amount missing: " +tempArr[j][3]);
						}
					}
				}
				writer.close();
			} catch (Exception e){
				System.out.println("Incorrect file format, please check the file and try again");
				return -1;
			}
			
			return amountEarned;
			
		} catch (Exception e){
			System.out.println("File does not exist");
			System.exit(0);
		}
		return -1;
	}
	
	public static void printInventory(Bike[] B){
		//Converts each bike into a string and prints them out
		for (int i = 0; i < B.length; i++){
			System.out.println(B[i].toString());
		}
		
	}
}