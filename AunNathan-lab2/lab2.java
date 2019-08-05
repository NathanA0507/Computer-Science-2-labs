import java.io.*;
import java.util.Scanner;
import java.util.*;

public class lab2{
	public static void main(String args[]) throws FileNotFoundException, IOException{
		
		int[][] sudokuBoard = readSudoku(args[0]);
		printSudoku(sudokuBoard);
		printWinOrLoss(checkSudoku(sudokuBoard));
	
	}
	
	public static int[][] readSudoku(String fileName) throws FileNotFoundException, IOException{
		//There is a try catch here in order to deal with exceptions in the case that the file is not a 9x9 table of numbers seperated by a space 
		try{
			FileReader fr = new FileReader(fileName);
			BufferedReader readBoard = new BufferedReader(fr);
			String[][] stringBoard = new String[9][]; //stringBoard is a temporary array that exists to make the 2D array
			int[][] sudokuBoard = new int[9][9]; //sudokuBoard is the final array that we return, a 2D array of integers taken from the file
			String[] boardByLine = new String[9]; //This is another temporary array in order to read every number from the file
			int i = 0;
			
			//This loop reads the file, assigns each line to array boardByLine, then makes a 2D array of strings with each digit as one string
			while (readBoard.ready()){
				boardByLine[i] = readBoard.readLine();
				stringBoard[i] = boardByLine[i].split(" ");
				i++;   
			}
			readBoard.close();
			
			//This loop makes sure that the board is 9x9. If it's any bigger or smaller this will make an exception and crash the program
			for (i = 0; i < stringBoard.length; i++){
				if (stringBoard[i].length != 9)
					throw new RuntimeException("Not the right length");
			}
			
			//This loop makes the 2D array of integers 
			for (i = 0; i < 9; i++){
				for (int j = 0; j < 9; j++){
					sudokuBoard[i][j] = Integer.parseInt(stringBoard[i][j]);
					if (sudokuBoard[i][j] > 9 || sudokuBoard[i][j] < 1)
						throw new RuntimeException("Number too large for sudoku");
				}
			}
			
			return sudokuBoard;
		} catch (Exception e){
			System.out.println("Invalid input, please check the file and try again!");
			System.exit(0);
		}
		int[][] fail = {{1,2}, {1, 2}};
		return fail;
		
	}
	
	// Method printSudoku just prints the sudoku board
	public static void printSudoku(int[][] sudokuBoard){
		
		for (int i = 0; i < 14; i++)
			System.out.print("= ");
		
		System.out.println();
		for (int i = 0; i < 9; i++){
			if (i % 3 == 0 && i > 0){
				System.out.print("|| - - - - - - - - - - - ||\n");
			}
			System.out.print("|| ");
			for (int j = 0; j < 9; j++){
				if (j % 3 == 0 && j > 0)
					System.out.print("| ");
				System.out.print(sudokuBoard[i][j] + " ");
			}
			System.out.println("||");
		}
			
		for (int i = 0; i < 14; i++)
			System.out.print("= ");
			
		
	}
	
	public static boolean checkSudoku(int[][] sudokuBoard){
		int startingIndex = 0;
		int startingIndexY = 0;
		boolean[] quadrantArray = new boolean[9];
		
		//These two blocks are practically the same in function, the first one checks rows and the second checks columns. it does this 
		//by comparing all numbers with each other and if there are any duplicates then it returns false.
		for (int i = 0; i < 9; i++){
			for (startingIndex = 0; startingIndex < 9; startingIndex++){
				for (int j = startingIndex + 1; j < 9; j++)
					if (sudokuBoard[i][startingIndex] == sudokuBoard[i][j])
						return false;
			}
			
		}
		
		for (int i = 0; i < 9; i++){
			for (startingIndex = 0; startingIndex < 9; startingIndex++){
				for (int j = startingIndex + 1; j < 9; j++)
					if (sudokuBoard[startingIndex][i] == sudokuBoard[j][i])
						return false;
			}
			
		}	
		
		
		//This loop checks each quadrant instead of rows or columns and it works a little differently. The starting index is set
		//in this first for loop and that's important because it then uses that value to check the 3 x 3 area starting from that first value.
		for (int quadrantNum = 0; quadrantNum < 9; quadrantNum++){
			switch (quadrantNum){
				case 0: startingIndex = 0;
						startingIndexY = 0;
						break;
				case 1: startingIndex = 3;
						startingIndexY = 0;
						break;
				case 2: startingIndex = 6;
						startingIndexY = 0;
						break;
				case 3: startingIndex = 0;
						startingIndexY = 3;
						break;
				case 4: startingIndex = 3;
						startingIndexY = 3;
						break;
				case 5: startingIndex = 6;
						startingIndexY = 3;
						break;
				case 6: startingIndex = 0;
						startingIndexY = 6;
						break;
				case 7: startingIndex = 3;
						startingIndexY = 6;
						break;
				case 8: startingIndex = 6;
						startingIndexY = 6;
						break;
			}
			//this block here just checks if there is one of each number in the array. If there are any values left 
			//as false, it will return false.
			for (int i = startingIndex; i < startingIndex + 3; i++){
				for (int k = startingIndexY; k < startingIndexY + 3; k++){
					switch (sudokuBoard[i][k]){
						case 1: quadrantArray[0] = true; break;
						case 2: quadrantArray[1] = true; break;
						case 3: quadrantArray[2] = true; break;
						case 4: quadrantArray[3] = true; break;
						case 5: quadrantArray[4] = true; break;
						case 6: quadrantArray[5] = true; break;
						case 7: quadrantArray[6] = true; break;
						case 8: quadrantArray[7] = true; break;
						case 9: quadrantArray[8] = true; break;
					}
				}
			}
			
			for (int i = 0; i < 9; i++){
				if (!quadrantArray[i])
					return false;
				else
					quadrantArray[i] = false; //we set it all equal to false here again after it checks so that we can use it again in the next iteration.
			}
			
		}
		
		return true;
	}

	public static void printWinOrLoss(boolean result){
		if (result)
			System.out.println("\nCongratulations! You have successfully completed this sudoku puzzle!");
		else
			System.out.println("\nThe puzzle has not been successfully completed. Please try again!");
	}
}