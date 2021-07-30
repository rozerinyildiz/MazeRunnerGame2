package MazeGamee2;

import java.io.IOException;
import java.util.Scanner;

public class MazeGame2 {
	
	public static Scanner input = new Scanner(System.in);
    public static Maze2 mazeTable = new Maze2();
    public static String up = "";
    public static String down = "";
    public static String left = "";
    public static String right = "";
    public static String userMoves="";
    
    
    public static void main(String[] args){
        //declaring variables
        String direction = "";
        int moveCount = 0;
      

        // welcome message
       
        UserOptions();
        //intro();
        
        while(!mazeTable.areYouWin()) {
            direction = userMove(); /*prompting and getting user direction input*/
            takeMove(direction); /*checking and making move if it is possible*/
            ++moveCount;
            movesMessage(moveCount);
            if (moveCount>60) {
                System.out.println("Sorry, but you didn't escape in time- you lose!");
                break;
            }
        }
        //closing message
        System.out.println("Congratulations, you made it out alive! And you did it in " + moveCount + " moves");
    }
    public static void UserOptions() {
    	
    	System.out.println("---------Table-------");
    	System.out.println("1- Choose keys for directions");
    	System.out.println("2- Play the game ");
    	System.out.println("3- Settings");
    	System.out.println("4- Exit");
    	System.out.println("---------Table-------");
    	
    	Scanner scanner = new Scanner(System.in);
    	int select=0;
        
    	while(select != 4){
        	
        	System.out.println("Please Choose One Of Them:");
        	select = scanner.nextInt();
        	
        	if(select == 2) {
        		intro();
        		break;
        	}else if(select == 1) {
        		chooseDirections();
        	}else if(select == 3) {
        		UserOptions();
        	}else{
        		
        		System.exit(select);
        		break;
        		
        	}
        	
        }
    	
    }
    public static void chooseDirections() {
    	
    	Scanner scannerDirection = new Scanner(System.in);
    	
    	System.out.println("Choose key for up:");
    	up = scannerDirection.nextLine();
    	System.out.println("Choose key for down:");
    	down = scannerDirection.nextLine();
    	System.out.println("Choose key for left:");
    	left = scannerDirection.nextLine();
    	System.out.println("Choose key for right:");
    	right = scannerDirection.nextLine();
    	
    	
    }
    public static void intro(){
        System.out.println("Welcome to Maze Game!\n Here is your current position:");
        mazeTable.printMap();
    }
    
    public static String userMove(){
        String userChoice;
        do{
            System.out.print("Where would you like to move? (right, left, up, down) ");
            userChoice = input.next();
        }while(!userChoice.equals(right) && !userChoice.equals(left) && !userChoice.equals(up) && !userChoice.equals(down));
        
        	clearOldVersion();

        return userChoice;
    }
    public static void clearOldVersion() {
    	
    	try { //to clear old version of mazeTable
    		Process exitCode;
    		if( System.getProperty( "os.name" ).startsWith( "Window" ) ) {
    			exitCode = Runtime.getRuntime().exec("cls");
    		}else {
    			exitCode = Runtime.getRuntime().exec("clear");
    		}
    	}catch (IOException e) {
    		for(int i = 0; i < 1000; i++) {
    			System.out.println();
    		}
    	}
    }
    
    public static void movesMessage(int moves){
        if (moves == 30) {
            System.out.println("Warning: You have made 30 moves, you have 30 remaining before the maze exit closes");
        } else if (moves == 45) {
            System.out.println("Alert! You have made 45 moves, you only have 15 moves left to escape.");
        } else if (moves == 60) {
            System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
        }
    }
    
    public static void takeMove(String userChoice){
    	if(userChoice.equals(up) && mazeTable.canIMoveUp()) {
            mazeTable.moveUp();
        } else if (userChoice.equals(down) && mazeTable.canIMoveDown()) {
            mazeTable.moveDown();
        } else if (userChoice.equals(left) && mazeTable.canIMoveLeft()) {
            mazeTable.moveLeft();
        } else if (userChoice.equals(right) && mazeTable.canIMoveRight()){
            mazeTable.moveRight();
        }  else {
            System.out.println("Sorry, but you’ve hit a wall.");
        }

        mazeTable.printMap();
    }
    public static String userMovesList(String userChoice) {
    	userMoves += userChoice;
    	
    	return userMoves;
    }

}
