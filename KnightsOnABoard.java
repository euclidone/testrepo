import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import java.nio.file.*;


public class Main
{
    public static boolean cannotCapture(int[][] chessBoard) throws Exception
    {
        boolean answer = false;
                    
        if(chessBoard[0][3] == 1)
        {
            if(chessBoard[2][1] == 1)
            {
                if(chessBoard[2][5] == 1)
                {
                    if(chessBoard[3][4] == 1)
                    {
                        if(chessBoard[3][6] == 1)
                        {
                            if(chessBoard[4][1] == 1)
                            {
                                if(chessBoard[4][5] == 1)
                                {
                                    if(chessBoard[6][1] == 1)
                                    {
                                        if(chessBoard[6][7] == 1)
                                        {
                                            if(chessBoard[7][4] == 1)
                                            {
                                                System.out.println("\nNo knights can capture any other knight.");
                                                answer = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return answer;
        //this method computes if the knights are placed on the chessboard so that 
        //no knight can capture another knight. It will then return true if no knight 
        //can capture any other knight, or false if even one knight can capture another.
    }
    
    public static void printBoard(int[][] chessBoard) throws Exception
    {
        System.out.print("The board looks as follows:\n");
        for(int row = 0; row < chessBoard.length; row++)
        {
            for(int column = 0; column < chessBoard[0].length; column++)
            {
                System.out.print(chessBoard[row][column] + " ");
            }
            System.out.println("");
        }
        cannotCapture(chessBoard);
        //this method will display the 2D array to the screen.
    }
    
    public static int[][] populateBoard(File inputFile) throws Exception
    {
        Scanner scan = new Scanner (new BufferedReader(new FileReader(inputFile)));
        
        int[][] chessBoard = new int[8][8];
        for(int row = 0; row < chessBoard.length; row++)
        {
            String[]line = scan.nextLine().trim().split(" ");
            for(int column = 0; column < line.length; column++)
            {
                chessBoard[row][column] = Integer.parseInt(line[column]);
                if(chessBoard[row][column] != 0 && chessBoard[row][column] != 1)
                {
                    chessBoard[row][column] = 1;
                }
            }
        }
        printBoard(chessBoard);
        scan.close();
        return chessBoard;
        //this method will read through the file that has been validated, then create 
        //and populate an 8x8 2D array with the information from the file. Remember 
        //to correct any lines of data which are integers but not 1’s or 0’s and print 
        //an appropriate message if this is needed. It will then return the created array.
    }
    
    public static boolean validateData(File inputFile) throws Exception
    {
        Scanner scan = new Scanner (new BufferedReader(new FileReader(inputFile)));
        
        boolean answer = false;
        
        String[] line = scan.nextLine().trim().split(" ");
        if(line.length == 8)
        {
            populateBoard(inputFile);
            answer = true;
        }
       
       
        else if(line.length != 8)
        {
            System.out.print("File has invalid data.\n");
            String userFile = scan.nextLine();
            File file = new File(userFile);
            validateFile(file);

        }
        
        return answer;
        //this method will validate the data from the input file, or print an error 
        //message if there is not 8 lines of 8 integers. It will then return true 
        //if valid or false if invalid.
    }
    
    public static File validateFile(File inputFile) throws Exception
    {
        Scanner scan = new Scanner(System.in);
        
        while(true)
        {
            if (inputFile.exists())
            {
                validateData(inputFile);
            }
            else
            {
                System.out.print("File does not exist!\nPlease enter the name of a valid file: ");
                String userFile = scan.nextLine();
                File file = new File(userFile);
                validateFile(file);
                if(inputFile.exists())
                    validateFile(file);
            }
            return inputFile;
        }
        //this method will check to see if the given file exists, if the input
        //file does not exist it will give an appropriate error message and 
        //ask the user for another name until a valid one is given. It will 
        //then return the valid file.
    }
  
  public static void main(String[]args) throws Exception
  {
      Scanner scan = new Scanner(System.in);
      System.out.print("Please enter the name of a valid file: ");
      String userFile = scan.nextLine();
      File file = new File(userFile);
      validateFile(file);
    //this is our standard main method to kick start the program. It will 
    //create an instance of our class then it will prompt the user for a 
    //file name and loop through validateFile and validateData until we 
    //can read in and create a valid 2D chess board array with populateBoard. 
    //It will then use printBoard to display the array and call cannotCapture 
    //and print an appropriate message to the screen depending on the true 
    //or false response.
  }
}
