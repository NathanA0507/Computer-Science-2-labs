/*********************************************************************************************
 * In this file, you will find code that will allow you to write information in a file, as 
 * well as to read information from a file.
 * You will see that there are at times different ways to do it (several methods are proposed).
 * Get yourself familiar with it and be ready to answer questions about it.
 *********************************************************************************************/

import java.io.*;
import java.util.Scanner;
import java.util.*;

public class ReadWrite {
    
    /****************************************************************************************
     * This method, readFile, takes the name of a file as input
     * readFile returns nothing
     * readFile goes through the file called filename and prints out its content line by line
     ****************************************************************************************/
    public static void readFile(String filename) throws FileNotFoundException, IOException {
		FileReader fr = new FileReader(filename);
        BufferedReader textReader = new BufferedReader(fr);

        while (textReader.ready()) {
            System.out.println(textReader.readLine());   
        }
        
        textReader.close();
    }
    
    /****************************************************************************************
     * This method, readFilePicky, takes the name of a file and a string as input
     * readFile returns nothing
     * readFile goes through the file called filename and prints out only the lines that start 
     * with its parameter "start"
     ****************************************************************************************/
    public static void readFilePicky(String filename, String start) throws FileNotFoundException, IOException {
		FileReader fr = new FileReader(filename);
        BufferedReader textReader = new BufferedReader(fr);
        String currentLine;
        
        while (textReader.ready()) {
            currentLine = textReader.readLine();
            if (currentLine.startsWith(start))
                System.out.println(currentLine);   
        }
        
        textReader.close();
    }
    
    /********************************* Or we could use a Scanner ******************************/
    public static void readFilePicky2(String filename, String start) throws FileNotFoundException, IOException {
        File file = new File(filename);
        Scanner in = new Scanner(file);
        String currentLine;

        while (in.hasNextLine()) {
            currentLine = in.nextLine();
            if (currentLine.startsWith(start))
                System.out.println(currentLine);               
        }
    }
    
    /****************************************************************************************
     * This method, writeInFile, takes the name of a file as input
     * writeInFile returns nothing
     * writeInFile prints "Hello there!" in the file called filename
     ****************************************************************************************/
    public static void writeInFile(String filename) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(filename);
        writer.print("Hello there!");
        writer.close();    
    }
    
    /***************** Or another way to write in a file ************************************/
    public static void writeInFile2(String filename) throws FileNotFoundException, IOException {
        FileWriter writer = new FileWriter(filename,true);
        writer.write("Hello there!\n");
        writer.flush();
        writer.close();
    }
    
    /****************************************************************************************
     * The main method calls readFile on this very java file and when you execute it, 
     * you will see that it prints this whole java file :)
     * It then calls readFilePicky on this same java file, but its second parameter value "import"
     * causes it to only print the lines of this file that start with "import"
     * It finally calls writeInFile with a parameter "myNewFile.txt": when you execute it,
     * you will see that it creates this file (if it does not exist yet) and prints 
     * "Hello there!" inside
     * Finally, it will test the two extra methods, readFilePicky2 and writeInFile2, which use
     * different implementations for the same result.
     ****************************************************************************************/
	public static void main(String[] args) throws FileNotFoundException, IOException {
        String filename = "ReadWrite.java";
        readFile(filename);
        readFilePicky(filename,"import");
        writeInFile("myNewFile.txt");
        System.out.println("Now trying the other options:");
        readFilePicky2(filename,"import");
        writeInFile2("myNewFile.txt");
    }
	
}